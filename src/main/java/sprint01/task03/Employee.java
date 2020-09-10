package sprint01.task03;

// Create a new version of the Employee class that correspond next principles:
//    - All class fields must be private.
//    - Get and set methods must be used to access the class fields.
//    - The class must have a constructors with and without parameters.

public class Employee {

    private String fullName;
    private float salary;

    public Employee() {

    }

    public Employee(String fullName, float salary) {
        this.fullName = fullName;
        this.salary = salary;
    }

    public String getFullName() {
        return fullName;
    }

    public float getSalary() {
        return salary;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }
}
