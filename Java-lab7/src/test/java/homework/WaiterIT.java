package homework;

import homework.enums.Cheese;
import homework.enums.Meat;
import homework.enums.Vegetables;
import homework.exception.WrongOrderException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.internal.matchers.Or;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class WaiterIT {

    @Spy
    private Order myOrder;

    @Mock
    private Pizza pizza;
    private Waiter waiter;
    @Mock
    private PizzaCooker cooker;

    @Test
    public void ReturnsOrderWhenWaiterWorks() {
        waiter = new Waiter("Oleh", 2, 21);
        myOrder.setPizza(List.of(pizza));
        when(pizza.getSize()).thenReturn(15D);
        Assert.assertEquals(myOrder, waiter.work(myOrder));
    }

    @Test(expected = WrongOrderException.class)
    public void ThrowsExceptionWhenSizeOfPizzaTooLittle() {
        waiter = new Waiter("Oleh", 2, 21);
        myOrder.setPizza(List.of(pizza));
        when(pizza.getSize()).thenReturn(5D);
        waiter.work(myOrder);
    }

    @Test
    public void workAndPassWorkToPizzaCookerIT() {
        waiter = new Waiter("Oleh", 2, 21);
        Pizza pizza1 = new Pizza(new Pizza.Dough("yeast"),
                new Filling(Vegetables.OLIVES,
                        Cheese.MOZZARELLA, Meat.CHICKEN));
        Pizza pizza2 = new Pizza(new Pizza.Dough("puff"),
                new Filling(Vegetables.MUSHROOMS,
                        Cheese.BRYNZA, Meat.CHICKEN));
        Pizza pizza3 = new Pizza(new Pizza.Dough("non-yeast"),
                new Filling(Vegetables.TOMATOES,
                        Cheese.BRYNZA, Meat.SAUSAGES));
        Order order1 = new Order(List.of(pizza1, pizza2, pizza3));
        when(cooker.work(pizza1)).thenReturn(pizza1);
        when(cooker.work(pizza2)).thenReturn(pizza2);
        when(cooker.work(pizza3)).thenReturn(pizza3);
        waiter.workAndPassWorkToPizzaCooker(List.of(order1), cooker);
    }
}