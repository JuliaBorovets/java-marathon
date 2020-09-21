package sprint04.task04;

public class ArrayUtil {

    public static void main(String[] args) {
        Integer[] numbers = new Integer[3];
        int numberFromSecondPosition = ArrayUtil.<Integer>setAndReturn(numbers, 52, 1);
        System.out.println(numberFromSecondPosition);
    }

    public static <T> T setAndReturn(T[] value1, T value2, int index) {
        value1[index] = value2;
        return value1[index];
    }
}
