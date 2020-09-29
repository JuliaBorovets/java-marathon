package sprint06.task03;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class App {

    static BinaryOperator<String> greetingOperator = (parameter1, parameter2) -> "Hello " + parameter1 + " " + parameter2 + "!!!";

    public static List<String> createGreetings(List<Person> people, BinaryOperator<String> binaryOperator) {
        return people.stream()
                .map(p -> binaryOperator.apply(p.name, p.surname))
                .collect(Collectors.toList());

    }

    public static void main(String[] args) {
        List<Person> initial = Arrays.asList(
                new Person("name1", "surname1"),
                new Person("name2", "surname2")
        );

        createGreetings(initial, greetingOperator)
                .forEach(System.out::println);
    }
}

class Person {
    String name;
    String surname;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }
}
