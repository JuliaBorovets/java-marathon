package sprint06.task05;

import java.util.Set;
import java.util.function.Predicate;

public class MyUtils {
    public static Predicate<Integer> getPredicateFromSet(Set<Predicate<Integer>> predicateSet) {
        return predicateSet.stream()
                .reduce(Predicate::and)
                .get();
    }
}
