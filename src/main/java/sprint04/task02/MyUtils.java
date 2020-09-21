package sprint04.task02;

import java.util.*;

public class MyUtils {

    public static void main(String[] args) {

        List<Student> list1 = Arrays.asList(
                new Student(1, "Ivan"),
                new Student(2, "Petro"),
                new Student(3, "Stepan")
        );

        List<Student> list2 = Arrays.asList(
                new Student(1, "Ivan"),
                new Student(3, "Stepan"),
                new Student(4, "Andriy"),
                new Student(5, null)
        );

        Set<Student> result = new MyUtils().commonStudents(list1, list2);
        System.out.println(result);
    }

    public static class Student {
        private int id;
        private String name;

        public Student(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return "Student[" + "id=" + id + ", name='" + name + '\'' + ']';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Student)) return false;

            Student student = (Student) o;

            if (id != student.id) return false;
            return Objects.equals(name, student.name);
        }

        @Override
        public int hashCode() {
            int result = id;
            result = 31 * result + (name != null ? name.hashCode() : 0);
            return result;
        }
    }

    public Set<Student> commonStudents(List<Student> list1, List<Student> list2) {
        Set<Student> result = new HashSet<>(list1);
        result.retainAll(list2);
        return result;
    }
}
