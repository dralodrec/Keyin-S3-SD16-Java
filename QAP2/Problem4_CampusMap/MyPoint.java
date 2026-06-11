import java.util.Arrays;

/**
 * Represents a point in a two-dimensional coordinate plane.
 */
public class MyPoint {
    private int x;
    private int y;

    /**
     * Creates a point at the origin, (0,0).
     */
    public MyPoint() {
        this(0, 0);
    }

   
    public MyPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }


    public MyPoint(int[] xy) {
        if (xy == null || xy.length < 2) {
            throw new IllegalArgumentException("Array must contain at least two values.");
        }
        this.x = xy[0];
        this.y = xy[1];
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    /**
     * Returns the x and y values as a new array.
     */
    public int[] getXY() {
        return new int[] { x, y };
    }

    /**
     * Sets both x and y coordinates.
     */
    public void setXY(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Calculates the distance from this point to another coordinate.
     */
    public double distance(int x, int y) {
        int xDiff = this.x - x;
        int yDiff = this.y - y;
        return Math.sqrt(xDiff * xDiff + yDiff * yDiff);
    }

    /**
     * Calculates the distance from this point to another MyPoint object.
     */
    public double distance(MyPoint another) {
        if (another == null) {
            throw new IllegalArgumentException("Point cannot be null.");
        }
        return distance(another.x, another.y);
    }

    /**
     * Calculates the distance from this point to the origin.
     */
    public double distance() {
        return distance(0, 0);
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MyPoint)) {
            return false;
        }
        MyPoint other = (MyPoint) obj;
        return x == other.x && y == other.y;
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(new int[] { x, y });
    }
}
