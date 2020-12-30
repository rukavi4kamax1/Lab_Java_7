package homework;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class Order {
    private int amount;
    private List<Pizza> pizza;

    public Order(List<Pizza> pizza) {
        this.pizza = pizza;
        this.amount = pizza.size();
    }

    public Order() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (amount != order.amount) return false;
        return pizza != null ? pizza.equals(order.pizza) : order.pizza == null;
    }
}
