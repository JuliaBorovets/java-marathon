package sprint03.task04;


enum LineType {
    SOLID, DOTTED, DASHED, DOUBLE;
}

public class Task04 {
    public static void main(String[] args) {
        System.out.println(drawLine(LineType.DASHED));
    }

    public static String drawLine(LineType lineType) {
        return "The line is " + lineType.name().toLowerCase() + " type";
    }
}
