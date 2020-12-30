package homework;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Pizza implements Eatable {
    private Dough dough;
    private Filling filling;
    private double size;
    private double price;

    public Pizza(Dough dough, Filling filling) {
        this.dough = dough;
        this.filling = filling;
    }

    @Override
    public String eat() {
        return "Hmmm...This pizza is tasty";
    }

    //Внутрішній клас - nested class(тісто)
    @Data
    public static class Dough {
        private String name;

        public Dough(String name) {
            this.name = name;
        }
    }
}
