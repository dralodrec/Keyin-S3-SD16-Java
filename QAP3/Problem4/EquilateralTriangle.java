/**
 * Represents a scalable equilateral triangle.
 */
public class EquilateralTriangle extends Triangle {

    /** Creates an equilateral triangle using one side length. */
    public EquilateralTriangle(String name, double side) {
        super(name, side, side, side);
    }

    /** @return the common side length */
    public double getSide() {
        return side1;
    }

    /** Uses the triangle scale method to change all three sides. */
    @Override
    public void scale(double factor) {
        super.scale(factor);
    }
}
