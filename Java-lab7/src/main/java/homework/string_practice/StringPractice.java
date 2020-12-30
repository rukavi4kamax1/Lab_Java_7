package homework.string_practice;

public class StringPractice {
    /* Метод, який використовує StringBuilder
    з метою редагування строк не використовуючи конкатенацію
    */
    public String strBuilderUse(String[] strings, String symbol) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : strings) {
            stringBuilder.append(str).append(symbol);
        }
        return stringBuilder.toString();
    }

    /* Метод, який використовує split()
    з метою розділення строк на масив строк за вказаним символом
    */
    public String[] strSplitUse(String str, String delimiter) {
        return str.split(delimiter);
    }

    // Метод, який використовує конкатенацію строк
    public String concatDiffTypes(String str, int[] array) {
        for (int i : array) {
            str += i;
        }
        return str;
    }
}
