/**
 * Represents a triangle with three sides.
 */
public class Triangle extends Shape {
    protected double side1;
    protected double side2;
    protected double side3;

    /** Creates a triangle after checking that its sides are valid. */
    public Triangle(String name, double side1, double side2, double side3) {
        super(name);

        if (!isValidTriangle(side1, side2, side3)) {
            System.err.println("Error: The values do not make a valid triangle.");
            System.exit(1);
        }

        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    /** Checks positive values and the triangle inequality. */
    private boolean isValidTriangle(double side1, double side2, double side3) {
        return side1 > 0 && side2 > 0 && side3 > 0
                && side1 + side2 > side3
                && side2 + side3 > side1
                && side3 + side1 > side2;
    }

    /** Calculates the area using Heron's formula. */
    @Override
    public double getArea() {
        double s = getPerimeter() / 2;
        return Math.sqrt(
                s * (s - side1) * (s - side2) * (s - side3));
    }

    /** Calculates the perimeter by adding all three sides. */
    @Override
    public double getPerimeter() {
        return side1 + side2 + side3;
    }
}
