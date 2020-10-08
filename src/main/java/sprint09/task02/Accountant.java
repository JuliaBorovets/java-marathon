package sprint09.task02;

/*
Suppose, you have class from task #1 ParallelCalculator that is able to execute an operation in separate thread.
It uses an implementation of Runnable interface for this.

You need to create Accountant class with a static sum(...) method that takes two parameters of type int and returns
their sum. Use ParallelCalculator for this. The sum(...) method doesn't throw any checked exceptions.

The sum must be evaluated in a separate thread  (please, do not call run() method of ParallelCalculator. Use start()
method on object of type Thread).
Using Thread.sleep() method is unwelcomed in this task.
 */

import sprint09.task01.ParallelCalculator;

import java.util.function.BinaryOperator;

public class Accountant {
    public static int sum(int x, int y) {

        BinaryOperator<Integer> binaryOperator = Integer::sum;
        ParallelCalculator calculator = new ParallelCalculator(binaryOperator, x, y);

        Thread thread = new Thread(calculator);

        thread.start();

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return calculator.result;

    }
}

class Main {
    public static void main(String[] args) {
        System.out.println(Accountant.sum(2, 3));
    }
}
