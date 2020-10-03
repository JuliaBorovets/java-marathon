package sprint07.task05;

//Create a Stream<String> nameList(Map<String, Stream<String>> map) method of the MyUtils class to build sorted
// stream of all participants without duplication.
//Please ignore null or empty strings, extra spaces and case sensitivity.
//Throw NullPointerException if map is null.
//For example, for a given map
//{"Desktop"=[" iVan", "PeTro ", " Ira "], "Web"=["STepan", "ira ", " Andriy ", "an na"], "Spring"=["Ivan", "Anna"]}
//you should get
//["Andriy", "Anna", "Ira", "Ivan", "Petro ", "Stepan"]

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Stream;

public class MyUtils {

    public Stream<String> nameList(Map<String, Stream<String>> map) {
        if (map == null) {
            throw new NullPointerException("Map is null");
        }

        return map.values()
                .stream()
                .filter(Objects::nonNull)
                .flatMap(Function.identity())
                .filter(Objects::nonNull)
                .map(s -> s.replace(" ", ""))
                .filter(s -> !s.equals(""))
                .map(s -> s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase())
                .distinct()
                .sorted();
    }

    public static void main(String[] args) {
        Map<String, Stream<String>> map = new HashMap<>();
        map.put("Desktop", Stream.of("", ""));
        map.put("Desktop2", Stream.of(" iVan", "PeTro ", " Ira "));
        map.put("Web", Stream.of("STepan", "ira ", " Andriy ", "an na"));
        map.put("Spring", Stream.of("Ivan", "Anna"));

        new MyUtils().nameList(map).forEach(System.out::println);
    }
}
