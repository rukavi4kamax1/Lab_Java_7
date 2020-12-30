package homework.enums;

import org.apache.log4j.Logger;

public enum Vegetables {
    TOMATOES(88), CORNS(102), OLIVES(188), MUSHROOMS(98);
    private static final Logger LOGGER = Logger.getLogger(Vegetables.class);

    private double calories;

    Vegetables(double calories) {
        this.calories = calories;
    }// конструктор із  додатковим параметром - калорійність

    Vegetables() {
    }

    @Override
    public String toString() {
        return "Vegetables{" +
                "calories=" + calories +
                "} " + super.toString();
    }

    public static String showVegetablesEnum() {// власний метод для того, щоб не використовувати конкатенацію строк
        LOGGER.info("Vegetables enum: ");
        StringBuilder stringBuilder = new StringBuilder();
        for (Vegetables vegetable : Vegetables.values()) {
            if (vegetable.calories != 0) {
                stringBuilder.append(vegetable)
                        .append(" calories: ")
                        .append(vegetable.calories)
                        .append("; ");
            } else {
                stringBuilder.append(vegetable);
            }
        }
        return stringBuilder.substring(0, stringBuilder.length() - 2);
    }
}
