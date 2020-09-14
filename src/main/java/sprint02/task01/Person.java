package sprint02.task01;
// We know that adult  doesn't have childIDNumber.
// Child doesn't have passportNumber.
// Create a public constructor in each class to initialize all their fields (make the first parameter of type int).

class Person {

    int age;
    String name;
    String healthInfo;

    public Person() {
    }

    public Person(int age, String name, String healthInfo) {
        this.age = age;
        this.name = name;
        this.healthInfo = healthInfo;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHealthInfo() {
        return healthInfo;
    }

    public void setHealthInfo(String healthInfo) {
        this.healthInfo = healthInfo;
    }

    String getHealthStatus() {
        return name + " " + healthInfo;
    }
}

