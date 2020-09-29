package sprint06.task06;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Predicate;

public class MyUtils {
    public static int findMaxByCondition(List<Integer> numbers, Predicate<Integer> pr) {

        return numbers.stream()
                .filter(pr)
                .max(Integer::compareTo)
                .get();
    }
}

class User {
    public final List<Integer> values = new ArrayList<Integer>();

    int getFilterdValue(BiFunction<List<Integer>, Predicate<Integer>, Integer> biFunction, Predicate<Integer> predicate) {
        return biFunction.apply(values, predicate);
    }

    int getMaxValueByCondition(Predicate<Integer> predicate) {
        return getFilterdValue(MyUtils::findMaxByCondition, predicate);
    }
}
