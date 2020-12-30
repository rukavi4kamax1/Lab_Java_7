package homework;

import homework.enums.Cheese;
import homework.enums.Meat;
import homework.enums.Vegetables;
import homework.exception.NotEnoughExperienceException;
import homework.exception.WrongOrderException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class PizzaCookerTest {
    private static final double DELTA = 1e-15;
    private Pizza pizza;
    private PizzaCooker cooker;

    @Before
    public void setUp() throws Exception {
        pizza = new Pizza(new Pizza.Dough("yeast"),
                new Filling(Vegetables.OLIVES,
                        Cheese.MOZZARELLA, Meat.CHICKEN));
        pizza.setSize(45);
        pizza.setPrice(250);
        cooker = new PizzaCooker("Volodymyr", 10, 45, List.of(pizza, pizza));
    }

    @Test
    public void work() {
        Pizza expected = new Pizza(new Pizza.Dough("yeast"),
                new Filling(Vegetables.OLIVES,
                        Cheese.MOZZARELLA, Meat.CHICKEN));
        expected.setPrice(250);
        expected.setSize(45);
        Pizza actual = cooker.work(pizza);
        System.out.println(actual);
        Assert.assertEquals(expected.getPrice(), actual.getPrice(), DELTA);
    }

    @Test(expected = NotEnoughExperienceException.class)
    public void constructorTest() {
        PizzaCooker cooker = new PizzaCooker("Volodymyr", 1,
                45, List.of(pizza));
    }

    @Test
    public void getSumOfAllPizzas() {
        cooker.setPizzas(List.of(pizza, pizza));
        Assert.assertEquals(500D, cooker.getSumOfAllPizzas(), DELTA);
    }

    @Test(expected = WrongOrderException.class)
    public void getSumOfAllPizzasThrowsException() {
        cooker.setPizzas(List.of());
        cooker.getSumOfAllPizzas();
    }

    @Test
    public void getTheMostExpensivePizza() {
        Pizza pizza1 = new Pizza(new Pizza.Dough("yeast"),
                new Filling(Vegetables.CORNS,
                        Cheese.MOZZARELLA, Meat.SAUSAGES));
        cooker.setPizzas(List.of(pizza, pizza1));
        Assert.assertEquals(pizza, cooker.getTheMostExpensivePizza());
    }

    @Test(expected = WrongOrderException.class)
    public void getTheMostExpensivePizzaThrowsException() {
        cooker.setPizzas(List.of());
        cooker.getTheMostExpensivePizza();
    }

    @Test
    public void getTheCheapestPizza() {
        Pizza pizza1 = new Pizza(new Pizza.Dough("yeast"),
                new Filling(Vegetables.CORNS,
                        Cheese.MOZZARELLA, Meat.SAUSAGES));
        cooker.setPizzas(List.of(pizza, pizza1));
        Assert.assertEquals(pizza1, cooker.getTheCheapestPizza());
    }

    @Test(expected = WrongOrderException.class)
    public void getTheCheapestPizzaThrowsException() {
        cooker.setPizzas(List.of());
        cooker.getTheCheapestPizza();
    }

    @Test
    public void getTheAveragePrice() {
        Pizza pizza1 = new Pizza(new Pizza.Dough("yeast"),
                new Filling(Vegetables.CORNS,
                        Cheese.MOZZARELLA, Meat.SAUSAGES));
        cooker.setPizzas(List.of(pizza1, pizza));
        Assert.assertEquals(125D, cooker.getTheAveragePrice(), DELTA);
    }

    @Test(expected = WrongOrderException.class)
    public void workThrowsException() {
        cooker.setPizzas(List.of());
        cooker.work();
    }
}