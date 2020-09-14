package sprint02.task06;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ShapeTest {

    // //[Circle [radius=2.00], Rectangle [height=2.00, width=3.00], Circle [radius=1.00],
    //// Rectangle [height=3.00, width=2.00],  Circle [radius=0.50], Rectangle [height=1.00, width=2.00]]
    ////you should get
    ////[Circle [radius=2.00], Rectangle [height=2.00, width=3.00], Rectangle [height=3.00, width=2.00]]
    @Test
    void getArea() {

        MyUtils myUtils = new MyUtils();

        List<Shape> shapes = new ArrayList<>();
        shapes.add(new Circle("circle1", 2));
        shapes.add(new Rectangle("circle2", 2, 3));
        shapes.add(new Circle("circle3", 1));
        shapes.add(new Rectangle("rectangle1", 3, 2));
        shapes.add(new Circle("circle4", 0.5));
        shapes.add(new Rectangle("rectangle2", 1, 2));

        List<Shape> result = myUtils.maxAreas(shapes);
        assertEquals(3, result.size());
        System.out.println(result);

    }
}
