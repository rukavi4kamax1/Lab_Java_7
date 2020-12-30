package homework;

import homework.enums.Cheese;
import homework.enums.Meat;
import homework.enums.Vegetables;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Filling {
    private Vegetables vegetables;
    private Cheese cheese;
    private Meat meat;

    public Filling(Vegetables vegetables, Cheese cheese, Meat meat) {
        this.vegetables = vegetables;
        this.cheese = cheese;
        this.meat = meat;
    }

    public Filling() {
    }

    // перевизначений hashCode()
    @Override
    public int hashCode() {
        int result = vegetables != null ? vegetables.hashCode() : 0;
        result = 31 * result + (cheese != null ? cheese.hashCode() : 0);
        result = 31 * result + (meat != null ? meat.hashCode() : 0);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Filling filling = (Filling) o;

        if (vegetables != filling.vegetables) return false;
        if (cheese != filling.cheese) return false;
        return meat == filling.meat;
    }
}
