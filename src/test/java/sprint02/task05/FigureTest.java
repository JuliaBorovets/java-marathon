package sprint02.task05;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FigureTest {

    @Test
    void getPerimeter() {
        List<Figure> figures = new ArrayList<>();
        figures.add(new Square(4));
        figures.add(new Square(5));
        figures.add(new Rectang(2, 3));

        MyUtils myUtils = new MyUtils();

        assertEquals(46, myUtils.sumPerimeter(figures));
    }
}
