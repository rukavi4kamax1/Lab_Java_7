package homework.enums;

import lombok.ToString;
import org.apache.log4j.Logger;

@ToString
public enum Cheese {
    MOZZARELLA(220), PARMESAN(230), BRYNZA(250);
    private static final Logger LOGGER = Logger.getLogger(Cheese.class);
    private double calories;

    Cheese(double calories) {
        this.calories = calories;
    }// конструктор із  додатковим параметром - калорійність

    Cheese() {
    }

    public static String showCheeseEnum() {// власний метод для того, щоб не використовувати конкатенацію строк
        LOGGER.info("Cheese enum: ");
        StringBuilder stringBuilder = new StringBuilder();
        for (Cheese cheese : Cheese.values()) {
            if (cheese.calories != 0) {
                stringBuilder.append(cheese)
                        .append(" calories: ")
                        .append(cheese.calories)
                        .append("; ");
            } else {
                stringBuilder.append(cheese);
            }
        }
        return stringBuilder.substring(0, stringBuilder.length() - 2);
    }
}
