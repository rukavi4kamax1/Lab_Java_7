package homework.string_practice;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StringPractice practice = new StringPractice();
        System.out.println("Enter an array of strings: ");
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        String[] strings = practice.strSplitUse(string, " ");
        System.out.println("After using strSplitUse(): " + Arrays.toString(strings));
        System.out.println("After using strBuilderUse(): " + practice.strBuilderUse(strings, "*"));
        int[] array = {1, 4, 67, 23};
        System.out.println("After using concatDiffTypes(): " + practice.concatDiffTypes(string, array));
    }
}
