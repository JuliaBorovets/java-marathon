package sprint01.task05;

// A Point class, which models a 2D point with x and y coordinates should contains:
//    - Two private instance variables x and y  of int type.
//    - A constructor that constructs a point with the given x and y coordinates.
//    - A method getXYPair() which returns the x and y in a 2-element int array.
//    - A method called distance(int x, int y) that returns the distance from this point to another point at the given
//    (x, y) coordinates.
//    - An overloaded distance(Point point) method that returns the distance from this point to the given Point instance.
//    - Another overloaded distance() method that returns the distance from this point to the origin (0, 0)

public class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int[] getXYPair() {
        return new int[]{x, y};
    }

    public double distance(int x, int y) {
        return Math.sqrt(Math.pow((x - this.x), 2) + Math.pow((y - this.y), 2));
    }

    public double distance(Point point) {
        return Math.sqrt(Math.pow((point.x - this.x), 2) + Math.pow((point.y - this.y), 2));
    }

    public double distance() {
        return Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2));
    }
}

