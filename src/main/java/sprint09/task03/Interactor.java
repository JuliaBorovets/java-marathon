package sprint09.task03;

/*

You need to implement the methods of the Interactor class so that output will look like this:
    Serving thread running
    Serving thread initializes the key
    key = -7
    Consuming thread received the key. key = -7
    Consuming thread changed the key. key = 33
    Serving thread resumed

The serve(...) method should initialize the x field with applied its first parameter to the second one and print the
 messages only about its own actions.

The counsume(...) method should wait until serve initializes x field and then change x by assigning it the result of
applying the method's first parameter to the second and the third ones. This method also prints the messages only about
 its own actions.

Assume that the consume(...) method should be able to execute without the serve(...) method after waiting for 3 seconds.

Use synchronized blocks (or methods), wait() and notify() methods for the implementation.
 */

import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class Interactor {

    int x;

    public synchronized void serve(UnaryOperator<Integer> uo, int initializer) throws InterruptedException {

        System.out.println("Serving thread running");

        System.out.println("Serving thread initializes the key");
        x = uo.apply(initializer);
        System.out.println("key = " + x);

        notify();
        wait();
        System.out.println("Serving thread resumed");
    }

    public synchronized void consume(BinaryOperator<Integer> bo, int operand2) throws InterruptedException {

        wait(3000);

        System.out.println("Consuming thread received the key. key = " + x);
        x = bo.apply(x, operand2);

        System.out.println("Consuming thread changed the key. key = " + x);
        notify();
    }
}

class Main {
    public static void main(String[] args) {
        ThreadExample.threadRun();
    }
}
