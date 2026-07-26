/**
 * Tests scalable shapes before and after scaling.
 */
public class Demo {

    /** Calls scale on every object in a Scalable array. */
    public static void scaleShapes(Scalable[] objects, double factor) {
        for (Scalable object : objects) {
            object.scale(factor);
        }
    }

    /** Prints every shape in the array. */
    public static void printShapes(Shape[] shapes) {
        for (Shape shape : shapes) {
            System.out.println(shape);
        }
    }

    public static void main(String[] args) {
        Shape[] shapes = {
            new Ellipse("Ellipse", 6.0, 4.0),
            new Circle("Circle", 3.0),
            new Triangle("Triangle", 3.0, 4.0, 5.0),
            new EquilateralTriangle("Equilateral Triangle", 5.0)
        };

        System.out.println("Before scaling:");
        printShapes(shapes);

        double factor = 2.0;
        scaleShapes(shapes, factor);

        System.out.println("\nAfter scaling by " + factor + ":");
        printShapes(shapes);
    }
}
