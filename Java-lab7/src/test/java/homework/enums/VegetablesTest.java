package homework.enums;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class VegetablesTest {

    @Test
    public void showVegetablesEnum() {
        String expected = "Vegetables{calories=88.0} TOMATOES " +
                "calories: 88.0; Vegetables{calories=102.0} " +
                "CORNS calories: 102.0; Vegetables{calories=188.0} " +
                "OLIVES calories: 188.0; Vegetables{calories=98.0}" +
                " MUSHROOMS calories: 98.0";
        String actual = Vegetables.showVegetablesEnum();
        Assert.assertEquals(expected, actual);
    }
}