/**
 * Tests the Shape inheritance hierarchy using a Shape array.
 */
public class Demo {
    public static void main(String[] args) {
        Shape[] shapes = {
            new Ellipse("Ellipse", 6.0, 4.0),
            new Circle("Circle", 3.0),
            new Triangle("Triangle", 3.0, 4.0, 5.0),
            new EquilateralTriangle("Equilateral Triangle", 5.0)
        };

        for (Shape shape : shapes) {
            System.out.println(shape);
        }
    }
}
