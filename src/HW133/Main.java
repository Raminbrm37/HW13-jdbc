package HW133;

import java.util.function.Predicate;

public class Main {
    interface equalDetection{
        boolean detect(String value);
    }
    public static void main(String[] args) {
        Predicate<String> predicateString=(value)->value.charAt(0)==value.charAt(value.length()-1);
        System.out.println(predicateString.test("ramin"));
        System.out.println(predicateString.test("rar"));
        equalDetection equalDetection=(value)->value.charAt(0)==value.charAt(value.length()-1);
        System.out.println(equalDetection.detect("ali"));
        System.out.println(equalDetection.detect("ada"));
    }
}
