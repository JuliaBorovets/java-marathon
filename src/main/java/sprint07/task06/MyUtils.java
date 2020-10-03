package sprint07.task06;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.function.Predicate.not;


//Create a Map<String, Stream<String>> phoneNumbers(List<Stream<String>> list) method of the MyUtils class to
// build a Map of all phone numbers.
//The key of Map is code of network and value contains sorted list of phones.
//Remove all spaces, brakets and dashes from phone numbers.

public class MyUtils {
    public Map<String, Stream<String>> phoneNumbers(List<Stream<String>> list) {

        if (list == null) {
            return null;
        }

        return list.stream()
                .filter(Objects::nonNull)
                .flatMap(Function.identity())
                .filter(Objects::nonNull)
                .map(j -> j.replaceAll("[-() ]", ""))
                .sorted()
                .distinct()
                .filter(not(String::isEmpty))
                .map(s -> {
                    if (s.length() == 7) {
                        return "loc".concat(s);
                    } else if (s.length() < 7) {
                        return "err".concat(s);
                    }
                    return s;
                })
                .collect(Collectors.toMap(
                        s -> s.substring(0, 3),
                        s -> Stream.of(s.substring(3)),
                        Stream::concat));
    }

    public static void main(String[] args) {

        List<Stream<String>> givenList = Arrays.asList(
                Stream.of("093 987 65 43", "(050)1234567", "12-345"),
                Stream.of("067-21-436-57", "050-2345678", "0939182736", "224-19-28"),
                Stream.of("(093)-11-22-334", "044 435-62-18", "721-73-45"));

        Map<String, Stream<String>> mustBe = new HashMap<>();
        mustBe.put("050", Stream.of("1234567", "2345678", null)); // +
        mustBe.put("067", Stream.of("2143657")); //  +
        mustBe.put("093", Stream.of("1122334", "9182736", "9876543")); // +
        mustBe.put("044", Stream.of("4356218")); // +
        mustBe.put("loc", Stream.of("2241928", "7217345")); // +
        mustBe.put("err", Stream.of("12345"));// +

        Map<String, Stream<String>> result = new MyUtils().phoneNumbers(givenList);
        result.forEach((key, value) -> {
            System.out.print(key + " : ");
            System.out.println(value.collect(Collectors.joining(" , ")));
        });
    }
}
