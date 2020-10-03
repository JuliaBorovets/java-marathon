package sprint07.task02;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Task02 {

    public static String getDateAfterToday(int years, int months, int days) {
        return LocalDate.now()
                .plus(Period.of(years, months, days))
                .format(DateTimeFormatter.ISO_LOCAL_DATE);
    }

    public static void main(String[] args) {

        System.out.println(getDateAfterToday(2, 2, 3));
    }
}
