package homework;

import homework.enums.Cheese;
import homework.enums.Meat;
import homework.enums.Vegetables;
import homework.exception.NotEnoughExperienceException;
import homework.exception.WrongOrderException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.List;

import static org.junit.Assert.*;

public class WaiterTest {
    @Rule
    public final ExpectedException exception = ExpectedException.none();
    private Pizza pizza;
    private Order order;
    private Order order2;
    private Waiter waiter;

    @Before
    public void setUp() throws Exception {
        pizza = new Pizza(new Pizza.Dough("yeast"),
                new Filling(Vegetables.OLIVES,
                        Cheese.MOZZARELLA, Meat.CHICKEN));
        order = new Order(List.of(pizza));
        order2 = new Order(List.of(pizza, pizza));
        waiter = new Waiter("Oleh", 2, 21, List.of(order, order2));
    }

    @Test
    public void work_Ok() {
        pizza.setSize(45);
        Assert.assertEquals(order, waiter.work(order));
    }

    @Test(expected = WrongOrderException.class)
    public void work() {
        pizza.setSize(5);
        waiter.work(order);
    }

    @Test(expected = WrongOrderException.class)
    public void workThrowsException() {
        waiter.setOrders(List.of());
        waiter.work();
    }


    @Test
    public void workTestList_Ok() {
        pizza.setSize(45);
        Order order2 = new Order(List.of(pizza, pizza));
        Assert.assertEquals(List.of(order, order2), waiter.work());
    }

    @Test(expected = WrongOrderException.class)
    public void workTestList() {
        pizza.setSize(5);
        exception.expect(IndexOutOfBoundsException.class);
    }

    @Test(expected = NotEnoughExperienceException.class)
    public void constructorTest() {
         new Waiter("Oleh", 1, 21);
    }

    @Test
    public void getOrderWithMostOfAllPizzas() {
        Assert.assertEquals(order2, waiter.getOrderWithMostOfAllPizzas());
    }

    @Test
    public void getTheMostPopularFilling() {
        Pizza pizza1 = new Pizza(new Pizza.Dough("yeast"),
                new Filling(Vegetables.CORNS,
                        Cheese.MOZZARELLA, Meat.SAUSAGES));
        order.setPizza(List.of(pizza, pizza1, pizza));
        Assert.assertEquals(new Filling(Vegetables.OLIVES,Cheese.MOZZARELLA, Meat.CHICKEN),
                waiter.getTheMostPopularFilling());
    }

    @Test
    public void getTheMostPopularFillingThrowsException() {
        order.setPizza(List.of());
        Assert.assertEquals(new Filling(Vegetables.OLIVES,Cheese.MOZZARELLA, Meat.CHICKEN),
                waiter.getTheMostPopularFilling());
    }
}