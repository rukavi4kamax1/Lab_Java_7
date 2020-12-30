package homework;

import homework.exception.WrongOrderException;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.log4j.Logger;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

@EqualsAndHashCode(callSuper = true)
@Data
public class PizzaCooker extends Employee<Pizza> {
    private static final Logger LOGGER = Logger.getLogger(PizzaCooker.class);
    private static final double MAX_PRICE = 250;
    private static final double UPPER_INTERMEDIATE_PRICE = 220;
    private static final double INTERMEDIATE_PRICE = 200;
    private static final double UPPER_BEGINNER_PRICE = 180;
    private static final double BEGINNER_PRICE = 150;
    private static final double MIN_PRICE = 100;
    private static final double STANDARD_SIZE = 30;
    private List<Pizza> pizzas = new ArrayList<>();

    public PizzaCooker(String name, double experience, int age, List<Pizza> pizzas) {
        super(name, experience, age);
        this.pizzas = pizzas;
    }

    private void checkPizzasSize(List<Pizza> pizzas) {
        if (pizzas.isEmpty()) {
            throw new WrongOrderException("The list should contain pizzas");
        }
    }

    public void setPizzas(List<Pizza> pizzas) {
        this.pizzas = pizzas;
    }

    public List<Pizza> work() {
        checkPizzasSize(pizzas);
        for (Pizza pizza : pizzas) {
            setPrice(pizza);
        }
        LOGGER.info("Pizzas have been cooked.");
        return pizzas;
    }

    public Double getSumOfAllPizzas() {
        checkPizzasSize(pizzas);
        return getPizzas()
                .stream()
                .map(Pizza::getPrice)
                .reduce(0D, Double::sum);
    }

    public Pizza getTheMostExpensivePizza() {
        checkPizzasSize(pizzas);
        return getPizzas()
                .stream()
                .max(Comparator.comparing(Pizza::getPrice))
                .orElseThrow(RuntimeException::new);
    }

    public Pizza getTheCheapestPizza() {
        checkPizzasSize(pizzas);
        return getPizzas()
                .stream()
                .min(Comparator.comparing(Pizza::getPrice))
                .orElseThrow(RuntimeException::new);
    }

    public Double getTheAveragePrice() {
        checkPizzasSize(pizzas);
        return getPizzas()
                .stream()
                .mapToDouble(Pizza::getPrice)
                .average()
                .orElseThrow(RuntimeException::new);
    }

    public Filling getTheMostPopularFilling() {
        checkPizzasSize(pizzas);
        return getPizzas()
                .stream()
                .map(Pizza::getFilling)
                .reduce(BinaryOperator.maxBy(Comparator.comparingInt(o
                        -> Collections.frequency(getPizzas(), o)))).orElse(null);
    }

    public List<Filling> getFillings() {
        checkPizzasSize(pizzas);
        return getPizzas()
                .stream()
                .map(Pizza::getFilling)
                .collect(Collectors.toList());
    }

    public Map<Boolean, List<Pizza>> getPizzaIfReady(Filling filling) {
        checkPizzasSize(pizzas);
        Map<Boolean, List<Pizza>> appropriatePizzas = new HashMap<>();
        List<Pizza> readyPizzas = getPizzas()
                .stream()
                .filter(p -> p.getFilling().equals(filling))
                .collect(Collectors.toList());
        appropriatePizzas.put(true, readyPizzas);
        List<Pizza> unReadyPizzas = getPizzas()
                .stream()
                .filter(p -> !readyPizzas.contains(p))
                .collect(Collectors.toList());
        appropriatePizzas.put(false, unReadyPizzas);
        LOGGER.info("List of ready pizzas: ");
        for (Pizza pizza : pizzas) {
            LOGGER.info(pizza);
        }
        LOGGER.info("Not yet ready Pizzas: ");
        for (Pizza pizza : unReadyPizzas) {
            LOGGER.info(pizza);
        }
        return appropriatePizzas;
    }

    @Override
    public Pizza work(Pizza pizza) {
        checkPizzasSize(pizzas);
        setPrice(pizza);
        LOGGER.info("Pizza has been cooked.");
        return pizza;
    }

    //Метод для встановлення ціни на піцу
    private void setPrice(Pizza pizza) {
        Filling filling = pizza.getFilling();
        if (filling.getMeat() != null && filling.getCheese() != null
                && filling.getVegetables() != null && pizza.getSize() > STANDARD_SIZE) {
            pizza.setPrice(MAX_PRICE);
            LOGGER.info("Pizza has MAX_PRICE");
        } else if (filling.getMeat() != null && filling.getCheese() != null
                && filling.getVegetables() != null && pizza.getSize() < STANDARD_SIZE) {
            pizza.setPrice(UPPER_INTERMEDIATE_PRICE);
            LOGGER.info("Pizza has UPPER_INTERMEDIATE price");
        } else if (filling.getMeat() != null && filling.getCheese() != null
                && pizza.getSize() > STANDARD_SIZE) {
            pizza.setPrice(INTERMEDIATE_PRICE);
            LOGGER.info("Pizza has INTERMEDIATE_PRICE ");
        } else if (filling.getMeat() != null && filling.getCheese() != null
                && pizza.getSize() < STANDARD_SIZE) {
            pizza.setPrice(UPPER_BEGINNER_PRICE);
            LOGGER.info("Pizza has UPPER_BEGINNER_PRICE ");
        } else if (pizza.getSize() > STANDARD_SIZE) {
            pizza.setPrice(BEGINNER_PRICE);
            LOGGER.info("Pizza has BEGINNER_PRICE ");
        } else {
            pizza.setPrice(MIN_PRICE);
            LOGGER.info("Pizza has MIN_PRICE ");
        }
    }
}
