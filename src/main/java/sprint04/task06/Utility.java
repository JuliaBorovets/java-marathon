package sprint04.task06;

import java.util.Arrays;
import java.util.Comparator;

class Person {
    protected String name;
    protected int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Age: " + age;
    }
}

class Employee extends Person {
    private double salary;

    public Employee(String name, int age, double salary) {
        super(name, age);
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return super.toString() + ", Salary: " + salary;
    }
}

class Developer extends Employee {
    private Level level;

    public Developer(String name, int age, double salary, Level level) {
        super(name, age, salary);
        this.level = level;
    }

    public Level getLevel() {
        return level;
    }

    @Override
    public String toString() {
        return super.toString() + ", Level: " + level.name();
    }
}

enum Level {
    JUNIOR, MIDDLE, SENIOR
}

class PersonComparator implements Comparator<Person> {

    @Override
    public int compare(Person person1, Person person2) {
        if (person1.name == null || person2.name == null) {
            return 0;
        }
        int result = person1.name.compareTo(person2.name);

        return result == 0 ? Integer.compare(person1.age, person2.age) : result;
    }
}

class EmployeeComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee employee1, Employee employee2) {

        int personComparatorResult = new PersonComparator().compare(employee1, employee2);

        return personComparatorResult == 0 ?
                Double.compare(employee1.getSalary(), employee2.getSalary())
                : personComparatorResult;
    }
}

class DeveloperComparator implements Comparator<Developer> {
    @Override
    public int compare(Developer developer1, Developer developer2) {

        int personComparatorResult = new PersonComparator().compare(developer1, developer2);

        return personComparatorResult == 0 ?
                developer1.getLevel().compareTo(developer2.getLevel())
                : personComparatorResult;
    }
}

public class Utility {
    public static <T extends Person> void sortPeople(T[] people, Comparator<? super T> comparator) {
        Arrays.sort(people, comparator);
    }

    public static void main(String[] args) {
        Person[] people = {new Person("Bbb", 12), new Person("Aaa", 34), new Person("Aaa", 2)};
        sortPeople(people, new PersonComparator());
        System.out.println(Arrays.toString(people));

        Employee[] employees = {new Employee("Bbb", 12, 2000),
                new Employee("Aaa", 34, 20),
                new Employee("Aaa", 34, 50)};

        sortPeople(employees, new EmployeeComparator());
        System.out.println(Arrays.toString(employees));
    }
}
