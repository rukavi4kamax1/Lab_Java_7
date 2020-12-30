package homework.equals_hashcode_practice;

import homework.Filling;
import homework.Order;
import homework.Pizza;
import homework.Waiter;
import homework.enums.Cheese;
import homework.enums.Meat;
import homework.enums.Vegetables;
import homework.exception.NotEnoughExperienceException;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class EqualsHashcodeTest {
    private EqualsHashcodePractice practice = new EqualsHashcodePractice();

    @Test
    public void testNonOverriddenHashcode() {
        Pizza pizza1 = new Pizza(new Pizza.Dough("yeast"),
                new Filling(Vegetables.OLIVES, Cheese.MOZZARELLA, Meat.CHICKEN));
        Pizza pizza2 = new Pizza(new Pizza.Dough("yeast"),
                new Filling(Vegetables.OLIVES, Cheese.MOZZARELLA, Meat.CHICKEN));
        Assert.assertFalse(practice.nonOverriddenHashcode(pizza1, pizza2));
    }

    @Test
    public void testOverriddenHashcode() {
        Filling filling1 = new Filling(Vegetables.OLIVES, Cheese.MOZZARELLA, Meat.CHICKEN);
        Filling filling2 = new Filling(Vegetables.OLIVES, Cheese.MOZZARELLA, Meat.CHICKEN);
        Assert.assertTrue(practice.overriddenHashcode(filling1, filling2));
    }

    @Test
    public void testOverriddenEquals() {
        Pizza pizza = new Pizza(new Pizza.Dough("yeast"),
            new Filling(Vegetables.OLIVES, Cheese.MOZZARELLA, Meat.CHICKEN));
        Order order1 = new Order(List.of(pizza));
        Order order2 = new Order(List.of(pizza));
        Assert.assertTrue(practice.overriddenEquals(order1, order2));
    }

    @Test
    public void testNonOverriddenEquals() throws NotEnoughExperienceException {
        Waiter waiter1 = new Waiter("Vitalik", 5, 32);
        Waiter waiter2 = new Waiter("Vitalik", 5, 32);
        Assert.assertFalse(practice.nonOverriddenEquals(waiter1, waiter2));
    }
}
