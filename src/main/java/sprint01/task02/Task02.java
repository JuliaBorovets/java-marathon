package sprint01.task02;

//1. Create an instances of Employee class named 'emp1' and 'emp2'.
//2. Set not null values for 'fullName' and 'salary' properties.
//3. Create array of Employee type with name 'employees' and add two objects created before.
//4. Create variable with name 'employeesInfo' of String type.
//5. Using a loop, iterrate across array and write to variable named 'employeesInfo' info about each employee in next fommat.

public class Task02 {

    public static void main(String[] args) {
        Employee emp1 = new Employee();
        Employee emp2 = new Employee();

        emp1.fullName = "John Thomson";
        emp1.salary = 1000;

        emp2.fullName = "Bob Martin";
        emp2.salary = 2000;

        Employee[] employees = {emp1, emp2};

        String prefix = "";
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (Employee employee : employees) {
            sb.append(prefix);
            prefix = ", ";
            sb.append("{fullName: \"").append(employee.fullName).append("\", salary: ").append(employee.salary).append("}");
        }
        sb.append("]");

        String employeesInfo = sb.toString();
        System.out.println(employeesInfo);

//        StringJoiner joiner = new StringJoiner(", ", "[", "]");
//
//        for (Employee employee : employees) {
//            joiner.add("{fullName: " + employee.fullName + ", salary: " + employee.salary + "}");
//        }
//
//        String employeesInfo = joiner.toString();

    }
}

