/**
 * Represents a circle, which is an ellipse with equal axes.
 */
public class Circle extends Ellipse {

    /** Creates a circle with the given radius. */
    public Circle(String name, double radius) {
        super(name, radius, radius);
    }

    /** @return the circle radius */
    public double getRadius() {
        return a;
    }

    /** Changes both ellipse axes to the same radius. */
    public void setRadius(double radius) {
        a = radius;
        b = radius;
    }
}
