/**
 * Represents a scalable ellipse.
 */
public class Ellipse extends Shape {
    protected double a;
    protected double b;

    /** Creates an ellipse and stores the larger axis in a. */
    public Ellipse(String name, double axis1, double axis2) {
        super(name);
        a = Math.max(axis1, axis2);
        b = Math.min(axis1, axis2);
    }

    /** Calculates area using PI * a * b. */
    @Override
    public double getArea() {
        return Math.PI * a * b;
    }

    /** Calculates the ellipse perimeter using the QAP formula. */
    @Override
    public double getPerimeter() {
        double difference = a - b;
        double insideRoot = 2 * (a * a + b * b)
                - (difference * difference) / 2;
        return Math.PI * Math.sqrt(insideRoot);
    }

    /** Multiplies both axes by the scale factor. */
    @Override
    public void scale(double factor) {
        checkScaleFactor(factor);
        a *= factor;
        b *= factor;
    }

    /** Prevents zero or negative shape sizes. */
    protected void checkScaleFactor(double factor) {
        if (factor <= 0) {
            throw new IllegalArgumentException(
                    "Scale factor must be greater than zero.");
        }
    }
}
