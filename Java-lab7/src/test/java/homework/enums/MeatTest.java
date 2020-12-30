package homework.enums;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MeatTest {

    @Test
    public void showMeatEnum() {
        String expected = "Meat.CHICKEN(calories=150.0) calories: 150.0; " +
                "Meat.SAUSAGES(calories=0.0";
        String actual = Meat.showMeatEnum();
        Assert.assertEquals(expected, actual);
    }
}