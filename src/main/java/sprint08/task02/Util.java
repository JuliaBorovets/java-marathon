package sprint08.task02;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

//This annotation can be applied to class when we execute static method review(String className) of class Util and
// the result of this method will be printed Class <ClassName> was reviewed <date in format yyyy-mm-dd> by <reviewer>
// to standard output (console).

public class Util {
    static void review(String className) {
        try {

            Class<?> clazz = Class.forName(className);

            if (clazz.isAnnotationPresent(Review.class)) {

                String date = clazz.getAnnotation(Review.class).date().equals("today")
                        ? LocalDate.now().format(DateTimeFormatter.ofPattern("YYYY-MM-dd"))
                        : LocalDate.parse(clazz.getAnnotation(Review.class).date()).format(DateTimeFormatter.ofPattern("YYYY-MM-dd"));

                String reviewer = clazz.getAnnotation(Review.class).reviewer();

                System.out.println("Class " + className + "was reviewed " + date + " by " + reviewer + ".");
            } else {
                System.out.println("Class " + className + " isn't marked as Reviewed");
            }

        } catch (ClassNotFoundException e) {
            System.out.println("Class " + className + " was not found");
        }
    }

    public static void main(String[] args) {
        Test1 test1 = new Test1();
        System.out.println(test1.getClass());
        review(test1.getClass().getName());
    }
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface Review {
    String reviewer();

    String date() default "today";
}

@Review(reviewer = "reviewer1")
class Test1 {

}

class Test2 {

}
