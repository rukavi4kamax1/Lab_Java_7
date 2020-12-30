package homework.equals_hashcode_practice;

import homework.Filling;
import homework.Order;
import homework.Pizza;
import homework.Waiter;

public class EqualsHashcodePractice {
    /*Викликаємо неперевизначений метод hashcode() класу
       Pizza. В результаті функція повертає false,
   оскільки методи неперевизначені і щоразу генерується
   новий унікальний хешкод*/
    public boolean nonOverriddenHashcode(Pizza pizza1, Pizza pizza2) {
        return pizza1.hashCode() == pizza2.hashCode();
    }

    /*Викликаємо перевизначений метод hashcode() класу
        Filling. В результаті функція повертає true,
    оскільки методи перевизначені і об'єкти і рівними*/
    public boolean overriddenHashcode(Filling filling1, Filling filling2) {
        return filling1.hashCode() == filling2.hashCode();
    }

    /*Викликаємо перевизначений метод equals() класу
        Order. В результаті функція повертає true,
    оскільки методи перевизначені і об'єкти і рівними*/
    public boolean overriddenEquals(Order order1, Order order2) {
        return order1.equals(order2);
    }

    /*Викликаємо неперевизначений метод equals() класу
       Order. В результаті функція повертає false,
    оскільки методи неперевизначені. Неперевизначений метод поверне
    true лише в тому випадку, якщо один об'єкт буде мати те ж посилання,
    що й інший(саме так порівнює об'єкти неперевизначений метод equals())*/
    public boolean nonOverriddenEquals(Waiter waiter1, Waiter waiter2) {
        return waiter1.equals(waiter2);
    }
}
