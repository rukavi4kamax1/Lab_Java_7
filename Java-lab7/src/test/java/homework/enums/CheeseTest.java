package homework.enums;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CheeseTest {

    @Test
    public void showCheeseEnum() {
        String expected = "Cheese.MOZZARELLA(calories=220.0) calories: " +
                "220.0; Cheese.PARMESAN(calories=230.0) calories:" +
                " 230.0; Cheese.BRYNZA(calories=250.0) calories: 250.0";
        String actual = Cheese.showCheeseEnum();
        Assert.assertEquals(expected, actual);
    }
}