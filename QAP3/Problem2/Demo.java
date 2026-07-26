/**
 * Tests the Point and MovablePoint classes.
 */
public class Demo {
    public static void main(String[] args) {
        Point point1 = new Point(2.5f, 3.5f);
        System.out.println("Point 1: " + point1);

        Point point2 = new Point();
        point2.setXY(1.0f, 2.0f);
        System.out.println("Point 2: " + point2);

        MovablePoint movingPoint = new MovablePoint(
                1.0f, 2.0f, 0.5f, 1.0f);

        System.out.println("Before move: " + movingPoint);
        movingPoint.move();
        System.out.println("After one move: " + movingPoint);
        movingPoint.move();
        System.out.println("After two moves: " + movingPoint);
    }
}
