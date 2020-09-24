package sprint05.task04;

import java.util.Objects;

public class Person {
    private String firstName;
    private String lastName;
    private String idCode;

    public void setFirstName(String firstName) {
        if (firstName.matches("[A-Z][a-z- ]+")) {
            this.firstName = firstName;
        } else {
            throw new NameException("Incorrect value " + firstName + " for firstName" + " " +
                    "(should start from upper case and contains only alphabetic characters and symbols -, _); ");
        }
    }

    public void setLastName(String lastName) {
        if (lastName.matches("[A-Z][a-z- ]+")) {
            this.lastName = lastName;
        } else {
            throw new NameException("Incorrect value " + lastName + " for lastName" +
                    " (should start from upper case and contains only alphabetic characters and symbols -, _); ");
        }
    }


    public void setIdCode(String idCode) {
        if (idCode.matches("[0-9]{10}")) {
            this.idCode = idCode;
        } else {
            throw new CodeException("Incorrect value " + idCode + " for code (should contains exactly 10 digits)");
        }
    }

    public static Person buildPerson(String firstName, String lastName, String idCode) {
        Person person = new Person();
        String message = "";

        try {
            person.setFirstName(firstName);
            person.setLastName(lastName);
        } catch (NameException e) {
            message += e.getMessage();
        }

        try {
            person.setIdCode(idCode);
        } catch (CodeException e) {
            message += e.getMessage();
        }

        if (!message.isEmpty()) {
            throw new IllegalArgumentException(message);
        }

        return person;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + ": " + idCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;

        Person person = (Person) o;

        if (!Objects.equals(firstName, person.firstName)) return false;
        if (!Objects.equals(lastName, person.lastName)) return false;
        return Objects.equals(idCode, person.idCode);
    }

    @Override
    public int hashCode() {
        int result = firstName != null ? firstName.hashCode() : 0;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (idCode != null ? idCode.hashCode() : 0);
        return result;
    }
}

class NameException extends RuntimeException {
    public NameException(String name) {
        super(name);
    }
}

class CodeException extends RuntimeException {
    public CodeException(String name) {
        super(name);
    }
}
