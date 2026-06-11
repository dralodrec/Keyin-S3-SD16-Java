import java.util.Arrays;

/**
 * Test driver for the MyLine and MyPoint classes.
 */
public class TestMyLine {
    public static void main(String[] args) {
        System.out.println("Testing MyPoint:");
        MyPoint p1 = new MyPoint(1, 2);
        MyPoint p2 = new MyPoint(4, 6);
        System.out.println("p1 = " + p1);
        System.out.println("p2 = " + p2);
        System.out.printf("Distance p1 to p2 = %.2f%n", p1.distance(p2));
        System.out.printf("Distance p1 to origin = %.2f%n", p1.distance());
        p1.setXY(2, 3);
        System.out.println("p1 after setXY(2, 3) = " + p1);
        System.out.println();

        System.out.println("Testing MyLine:");
        MyLine line1 = new MyLine(0, 0, 3, 4);
        System.out.println("line1 = " + line1);
        System.out.println("Begin point = " + line1.getBegin());
        System.out.println("End point = " + line1.getEnd());
        System.out.println("Begin X = " + line1.getBeginX());
        System.out.println("Begin Y = " + line1.getBeginY());
        System.out.println("End X = " + line1.getEndX());
        System.out.println("End Y = " + line1.getEndY());
        System.out.println("Begin XY = " + Arrays.toString(line1.getBeginXY()));
        System.out.println("End XY = " + Arrays.toString(line1.getEndXY()));
        System.out.printf("Length = %.2f%n", line1.getLength());
        System.out.printf("Gradient = %.4f radians%n", line1.getGradient());
        System.out.println();

        line1.setBeginX(2);
        line1.setBeginY(2);
        line1.setEndX(8);
        line1.setEndY(10);
        System.out.println("After setting individual coordinates:");
        System.out.println("line1 = " + line1);
        System.out.printf("Length = %.2f%n", line1.getLength());
        System.out.printf("Gradient = %.4f radians%n", line1.getGradient());
        System.out.println();

        line1.setBeginXY(5, 5);
        line1.setEndXY(9, 12);
        System.out.println("After setBeginXY(5, 5) and setEndXY(9, 12):");
        System.out.println("line1 = " + line1);
        System.out.println("Begin XY = " + Arrays.toString(line1.getBeginXY()));
        System.out.println("End XY = " + Arrays.toString(line1.getEndXY()));
        System.out.printf("Length = %.2f%n", line1.getLength());
        System.out.printf("Gradient = %.4f radians%n", line1.getGradient());
        System.out.println();

        MyLine line2 = new MyLine(new MyPoint(10, 20), new MyPoint(30, 40));
        System.out.println("line2 from MyPoint objects = " + line2);
        line2.setBegin(new MyPoint(1, 1));
        line2.setEnd(new MyPoint(6, 6));
        System.out.println("line2 after setBegin and setEnd = " + line2);
        System.out.printf("line2 length = %.2f%n", line2.getLength());
    }
}
