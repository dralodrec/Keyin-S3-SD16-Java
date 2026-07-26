/**
 * Represents an ellipse with major axis a and minor axis b.
 */
public class Ellipse extends Shape {
    protected double a;
    protected double b;

    /**
     * Creates an ellipse. The larger value is stored in a.
     */
    public Ellipse(String name, double axis1, double axis2) {
        super(name);
        a = Math.max(axis1, axis2);
        b = Math.min(axis1, axis2);
    }

    /** @return the major axis */
    public double getA() {
        return a;
    }

    /** @return the minor axis */
    public double getB() {
        return b;
    }

    /** Calculates area using PI * a * b. */
    @Override
    public double getArea() {
        return Math.PI * a * b;
    }

    /**
     * Calculates the ellipse perimeter using the formula from the QAP.
     */
    @Override
    public double getPerimeter() {
        double difference = a - b;
        double insideRoot = 2 * (a * a + b * b)
                - (difference * difference) / 2;
        return Math.PI * Math.sqrt(insideRoot);
    }
}
