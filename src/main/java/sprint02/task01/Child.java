package sprint02.task01;

class Child extends Person {

    private String childIDNumber;

    public Child() {
    }

    public Child(int age, String name, String healthInfo, String childIDNumber) {
        super(age, name, healthInfo);
        this.childIDNumber = childIDNumber;
    }

    public String getChildIDNumber() {
        return childIDNumber;
    }

    public void setChildIDNumber(String childIDNumber) {
        this.childIDNumber = childIDNumber;
    }
}
