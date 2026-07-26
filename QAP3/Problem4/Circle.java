/**
 * Represents a scalable circle.
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

    /** Uses the ellipse scale method to change the radius. */
    @Override
    public void scale(double factor) {
        super.scale(factor);
    }
}
