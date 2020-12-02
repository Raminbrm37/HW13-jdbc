package HW132;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Main {
    interface Averaging{
        double average(int num1,int num2);
    }
    public static void main(String[] args) {

        Averaging averaging=(value1,value2)->(double) (value1+value2)/2;
        System.out.println(averaging.average(12,14));
        BiFunction<Integer,Integer,Double> avgFunction=(value1,value2)-> (double) ((value1 + value2) / 2);
        System.out.println(avgFunction.apply(14,12));

    }

}
