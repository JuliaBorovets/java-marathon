package sprint01.task04;

// Create a new version of the Circle class where the draw method will be overloaded four times:
//    - The version without parameters.
//    - Using the one parameter color of String type.
//    - Using the one parameter scale of float type.
//    - Using two parameters color and scale of String and float type.

public class Circle {

    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public void draw() {
        // The version without parameters.
    }

    public void draw(String color) {
        // Using the one parameter color of String type.
    }

    public void draw(float scale) {
        // Using the one parameter scale of float type.
    }

    public void draw(String color, float scale) {
        // Using two parameters color and scale of String and float type.
    }
}
