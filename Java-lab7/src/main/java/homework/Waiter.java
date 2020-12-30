package homework;

import homework.exception.WrongOrderException;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.log4j.Logger;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@ToString
@Getter
@Setter
public class Waiter extends Employee<Order> {
    private static final Logger LOGGER = Logger.getLogger(Waiter.class);
    private static final String SUCCESS = "The order was done";

    private List<Order> orders = new ArrayList<>();

    public Waiter(String name, double experience, int age, List<Order> orders) {
        super(name, experience, age);
        this.orders = orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public Waiter(String name, double experience, int age) {
        super(name, experience, age);
    }

    public Long getNumberOfPizzasFromOrders() {
        checkOrderParameter();
        return getOrders()
                .stream()
                .map(Order::getAmount) // Function interface, method reference
                .count();
    }

    private void checkOrderParameter() {
        if (orders.isEmpty()) {
            throw new WrongOrderException("The order can't be empty");
        }
    }

    public Order getOrderWithMostOfAllPizzas() {
        checkOrderParameter();
        return getOrders().stream()
                .max(Comparator.comparing(Order::getAmount))
                .orElseThrow(() -> new RuntimeException("Such order is absent"));
    }

    public Filling getTheMostPopularFilling(){
        checkOrderParameter();
        return  getOrders()
                .stream()
                .flatMap(o -> o.getPizza().stream())
                .map(Pizza::getFilling)
                .filter(Objects::nonNull)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey).orElse(null);
    }


    public List<Order> work() {
        checkOrderParameter();
        for (Order order : orders) {
            List<Pizza> pizzas = order.getPizza();
            Iterator<Pizza> iterator = pizzas.iterator();
            while (iterator.hasNext()) {
                Pizza pizza = iterator.next();
                if (pizza.getSize() < 10) {
                    // використання власного WrongOrderException та обробка помилка в блоці try-catch-finally
                    throw new WrongOrderException("The size of pizza is too small..." +
                            "Enter the size more than 10 the next time...");
                }
            }
        }
        LOGGER.info(SUCCESS);
        return orders;
    }


    public List<Pizza> workAndPassWorkToPizzaCooker(List<Order> orders, PizzaCooker pizzaCooker) {
        if (orders.isEmpty()) {
            throw new WrongOrderException("The order can't be empty");
        }
        for (Order order : orders) {
            List<Pizza> pizzas = order.getPizza();
            for (Pizza pizza : pizzas) {
                pizzaCooker.work(pizza);
            }
        }
        LOGGER.info(SUCCESS);
        return orders.stream().flatMap(o -> o.getPizza().stream()).collect(Collectors.toList());
    }

    //Метод, який імітує взяття замовлення офіціантом
    @Override
    public Order work(Order order) {
        List<Pizza> pizzas = order.getPizza();
        Iterator<Pizza> iterator = pizzas.iterator();
        while (iterator.hasNext()) {
            Pizza pizza = iterator.next();
            if (pizza.getSize() < 10) {
                // використання власного WrongOrderException та обробка помилка в блоці try-catch-finally
                throw new WrongOrderException("The size of pizza is too small..." +
                        "Enter the size more than 10 the next time...");
            }
        }
        LOGGER.info(SUCCESS);
        return order;
    }
}
