package sprint06.task01;

//Implement a static method getCount(...) that takes an array of integers as the first parameter.
// The second parameter is a functional interface that works with integers and defines a some condition.
//
//The method should return the count of elements in the array that satisfy the condition defined by the second argument.

import java.util.Arrays;
import java.util.function.Predicate;

public class MyUtils {

    public static int getCount(int[] array, Predicate<Integer> predicate) {
        return (int) Arrays.stream(array)
                .boxed()
                .filter(predicate)
                .count();
    }

    public static void main(String[] args) {
        Predicate<Integer> predicate = i -> i != 2;
        int[] array = {1, 2, 3};
        System.out.println(getCount(array, predicate));
    }
}
