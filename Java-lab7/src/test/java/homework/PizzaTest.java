package homework;

import homework.enums.Cheese;
import homework.enums.Meat;
import homework.enums.Vegetables;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class PizzaTest {
    Pizza pizza = new Pizza(new Pizza.Dough("yeast"),
            new Filling(Vegetables.OLIVES,
                    Cheese.MOZZARELLA, Meat.CHICKEN));

    @Test
    public void eat() {
        String expected = "Hmmm...This pizza is tasty";
        String actual = pizza.eat();
        Assert.assertEquals(expected, actual);
    }
}