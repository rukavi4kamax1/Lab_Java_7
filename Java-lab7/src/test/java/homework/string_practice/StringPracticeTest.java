package homework.string_practice;

import org.junit.Assert;
import org.junit.Test;

public class StringPracticeTest {

    private StringPractice practice = new StringPractice();

    @Test
    public void strBuilderUse() {
        String[] strings = new String[]{"I" , "love", "Java"};
        String[] strings2 = new String[]{"I" , "hate", "Java"};
        Assert.assertEquals("I*love*Java*", practice.strBuilderUse(strings, "*"));
        Assert.assertEquals("I~hate~Java~", practice.strBuilderUse(strings2, "~"));
    }

    @Test
    public void strSplitUse() {
        String str = "I love Physics";
        String str2 = "I-love-Physics";
        Assert.assertArrayEquals(new String[]{"I", "love", "Physics"}, practice.strSplitUse(str, " "));
        Assert.assertArrayEquals(new String[]{"I", "love", "Physics"}, practice.strSplitUse(str2, "-"));
    }

    @Test
    public void concatDiffTypes() {
        String str = "I love Physics";
        int[] array = {1, 4, 67, 23};
        Assert.assertEquals("I love Physics146723", practice.concatDiffTypes(str, array));
    }
}