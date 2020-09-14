package sprint02.task01;

class Adult extends Person {
    private String passportNumber;

    public Adult() {
    }

    public Adult(int age, String name, String healthInfo, String passportNumber) {
        super(age, name, healthInfo);
        this.passportNumber = passportNumber;
    }

    public String getHealthStatus() {
        return getName() + " " + getHealthInfo();
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }
}
