package homework.equals_hashcode_practice;

import homework.Filling;
import homework.Order;
import homework.Pizza;
import homework.Waiter;
import homework.enums.Cheese;
import homework.enums.Meat;
import homework.enums.Vegetables;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        EqualsHashcodePractice practice = new EqualsHashcodePractice();
        Pizza.Dough dough = new Pizza.Dough("yeast");

        Pizza pizza1 = new Pizza(dough,
                new Filling(Vegetables.OLIVES, Cheese.MOZZARELLA, Meat.CHICKEN));
        Pizza pizza2 = new Pizza(dough,
                new Filling(Vegetables.OLIVES, Cheese.MOZZARELLA, Meat.CHICKEN));
        System.out.println("NonOverriddenHashcode\nAre hashcodes equal? "
                + practice.nonOverriddenHashcode(pizza1, pizza2));

        Filling filling1 = new Filling(Vegetables.OLIVES, Cheese.MOZZARELLA, Meat.CHICKEN);
        Filling filling2 = new Filling(Vegetables.OLIVES, Cheese.MOZZARELLA, Meat.CHICKEN);
        System.out.println("OverriddenHashcode\nAre hashcodes equal? "
                + practice.overriddenHashcode(filling1, filling2));

        Pizza pizza = new Pizza(new Pizza.Dough("yeast"),
                new Filling(Vegetables.OLIVES, Cheese.MOZZARELLA, Meat.CHICKEN));
        Order order1 = new Order(List.of(pizza));
        Order order2 = new Order(List.of(pizza));
        System.out.println("OverriddenEquals\n Are object equal? "
                + practice.overriddenEquals(order1, order2));

        Waiter waiter1 = new Waiter("Vitalik", 5, 32);
        Waiter waiter2 =  new Waiter("Vitalik", 5, 32);

        System.out.println("NonOverriddenEquals\n Are object equal? " + practice.nonOverriddenEquals(waiter1, waiter2));
    }
}
