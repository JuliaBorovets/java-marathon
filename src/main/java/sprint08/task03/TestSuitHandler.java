package sprint08.task03;

import java.lang.annotation.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class TestSuitHandler {
    public static void run(Class<?> clazz) {
        TestSuite annotation = clazz.getAnnotation(TestSuite.class);

        if (annotation == null) {
            System.out.println("Class " + clazz.getName() + " isn't annotated");
        } else {

            for (String strMethod : annotation.value()) {
                try {
                    Method method = clazz.getMethod(strMethod);
                    if (method.getParameterCount() == 0 && Modifier.isPublic(method.getModifiers()) &&
                            !Modifier.isStatic(method.getModifiers())) {

                        System.out.println("\t -- Method " + clazz.getName() + '.' + method.getName() + " started --");
                        method.invoke(clazz.getDeclaredConstructor().newInstance());
                        System.out.println("\t -- Method " + clazz.getName() + '.' + method.getName() + " finished --");
                    }
                } catch (NoSuchMethodException e) {
                    System.out.println("Method with name " + strMethod + " doesn't exists or not public in class " + clazz.getName());
                } catch (IllegalAccessException | InstantiationException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        run(Class1.class);
    }
}

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface TestSuite {
    String[] value();
}

@TestSuite({"m1", "m2"})
class Class1 {


    public void m2() {
        System.out.println("Hello");
    }
}
