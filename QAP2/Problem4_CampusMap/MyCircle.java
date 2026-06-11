/**
 * Models a circle using a center point and a radius.
 * In the campus map, circles represent roundabouts or fountains.
 */
public class MyCircle {
    private MyPoint center;
    private double radius;

   
    public MyCircle(int x, int y, double radius) {
        this(new MyPoint(x, y), radius);
    }

    
    public MyCircle(MyPoint center, double radius) {
        if (center == null) {
            throw new IllegalArgumentException("Center point cannot be null.");
        }
        if (radius < 0) {
            throw new IllegalArgumentException("Radius cannot be negative.");
        }
        this.center = new MyPoint(center.getX(), center.getY());
        this.radius = radius;
    }

    public MyPoint getCenter() {
        return new MyPoint(center.getX(), center.getY());
    }

    public void setCenter(MyPoint center) {
        if (center == null) {
            throw new IllegalArgumentException("Center point cannot be null.");
        }
        this.center = new MyPoint(center.getX(), center.getY());
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        if (radius < 0) {
            throw new IllegalArgumentException("Radius cannot be negative.");
        }
        this.radius = radius;
    }

    /**
     * Returns the circle's area.
     */
    public double getArea() {
        return Math.PI * radius * radius;
    }

    /**
     * Returns the circle's circumference.
     */
    public double getCircumference() {
        return 2 * Math.PI * radius;
    }

    /**
     * Checks whether a point is inside or on the circle.
     */
    public boolean contains(MyPoint point) {
        if (point == null) {
            return false;
        }
        return center.distance(point) <= radius;
    }

    @Override
    public String toString() {
        return "MyCircle[center=" + center + ",radius=" + radius + "]";
    }
}
