package sprint05.task01;

public class Task01 {
    public static void main(String[] args) {
        System.out.println(Operation.trySquareRectangle(1, -2));
    }
}

class Operation {
    public static int squareRectangle(int a, int b) throws IllegalArgumentException {
        if (a <= 0 || b <= 0) {
            throw new IllegalArgumentException("both arguments should be more than zero");
        }

        return a * b;
    }

    public static int trySquareRectangle(int a, int b) {

        try {
            return squareRectangle(a, b);
        } catch (IllegalArgumentException e) {
            e.getMessage();
            return -1;
        }

    }
}

