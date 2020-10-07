package sprint08.task01;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.stream.Collectors;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface CamelCase {

}

public class CheckCamelCase {
    public final static String CAMELCASE_PATTERN = "^[a-z]+[a-zA-Z0-9]*$";

    public static void main(String[] args) throws InterruptedException {
        System.out.println(checkAndPrint(Class1.class));
        System.out.println(checkAndPrint(Class2.class));
        // checkAndPrint(ClassForAnnot.class);
    }


    public static boolean checkAndPrint(Class clazz) {

        Method[] methods = clazz.getMethods();

        String result = Arrays.stream(methods)
                .filter(i -> i.isAnnotationPresent(CamelCase.class) && !i.getName().matches(CAMELCASE_PATTERN))
                .map(i -> "method " + clazz.getName() + "." + i.getName() +
                        " doesn't satisfy camelCase naming convention")
                .collect(Collectors.joining("\n"));

        if (!result.isEmpty()) {
            System.out.println(result);
            return false;
        }

        return true;
    }

}

class ClassForAnnot {
    @CamelCase
    public static void example() {
    }

    @CamelCase
    public void Example() {
    }

    public static void _main(String args[]) {
    }
}

class Class1 {
    @CamelCase
    public void correct() {
    }

    @CamelCase
    public void InCorrect() {
    }

    @CamelCase
    public void JustMethod() {
    }
}

class Class2 {
    @CamelCase
    public void correct() {
    }

    @CamelCase
    public void oneMoreCorrect() {
    }
}
