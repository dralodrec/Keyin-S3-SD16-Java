/**
 * Represents a triangle whose three sides are equal.
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
}
