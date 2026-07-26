/**
 * Abstract superclass containing features shared by all shapes.
 */
public abstract class Shape {
    private String name;

    /** Creates a shape with the given name. */
    public Shape(String name) {
        this.name = name;
    }

    /** @return the shape's name */
    public String getName() {
        return name;
    }

    /** @param name the new shape name */
    public void setName(String name) {
        this.name = name;
    }

    /** @return the area of the shape */
    public abstract double getArea();

    /** @return the perimeter of the shape */
    public abstract double getPerimeter();

    /**
     * Calls the correct area and perimeter methods for the actual object.
     */
    @Override
    public String toString() {
        return String.format(
                "%s - Area: %.2f, Perimeter: %.2f",
                name, getArea(), getPerimeter());
    }
}
