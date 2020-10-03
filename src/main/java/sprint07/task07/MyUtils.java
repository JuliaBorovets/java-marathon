package sprint07.task07;

//Create a Stream<Integer> duplicateElements(Stream<Integer> stream) method of the MyUtils class to return a
// sorted stream of duplicated elements of the input stream.
//For example, for a given elements
//[3, 2, 1, 1, 12, 3, 8, 2, 4, 2]
//you should get
//[1, 2, 3]

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MyUtils {
    public Stream<Integer> duplicateElements(Stream<Integer> stream) {
        Set<Integer> set = new HashSet<>();
        return stream
                .filter(Objects::nonNull)
                .filter(i -> !set.add(i))
                .distinct()
                .sorted();
    }

    public static void main(String[] args) {
        List<Integer> result = new MyUtils().duplicateElements(Stream.of(3, 2, 1, 1, 12, 3, 8, 2, 4, 2))
                .collect(Collectors.toList());

        System.out.println(result);
    }
}
