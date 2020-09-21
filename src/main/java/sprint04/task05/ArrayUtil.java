package sprint04.task05;

public class ArrayUtil {

    public static void main(String[] args) {
        Array<Integer> set1 = new Array<>(new Integer[]{1, 2, 3, 4, 5});
        double averageValue1 = ArrayUtil.averageValue(set1);
        System.out.println(averageValue1);
        //3.0

        Array<Double> set2 = new Array<>(new Double[]{1.0, 2.0, 3.0, 4.0, 5.0});
        double averageValue2 = ArrayUtil.averageValue(set1);
        System.out.println(averageValue2);
        //3.0


    }

    public static <T extends Number> double averageValue(Array<T> input) {
        double average = 0.0;

        for (int i = 0; i < input.length(); i++) {
            average += input.get(i).doubleValue();
        }
        return average / input.length();
    }

}

class Array<T> {
    private T[] array;

    public Array(T[] array) {
        this.array = array;
    }

    public T get(int index) {
        return array[index];
    }

    public int length() {
        return array.length;
    }
}
