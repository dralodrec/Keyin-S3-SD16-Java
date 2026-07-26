/**
 * Represents a point with x and y coordinates.
 */
public class Point {
    private float x;
    private float y;

    /** Creates a point at (0, 0). */
    public Point() {
        this(0.0f, 0.0f);
    }

    /**
     * Creates a point using the given coordinates.
     *
     * @param x the x-coordinate
     * @param y the y-coordinate
     */
    public Point(float x, float y) {
        this.x = x;
        this.y = y;
    }

    /** @return the x-coordinate */
    public float getX() {
        return x;
    }

    /** @param x the new x-coordinate */
    public void setX(float x) {
        this.x = x;
    }

    /** @return the y-coordinate */
    public float getY() {
        return y;
    }

    /** @param y the new y-coordinate */
    public void setY(float y) {
        this.y = y;
    }

    /** Changes both coordinates. */
    public void setXY(float x, float y) {
        this.x = x;
        this.y = y;
    }

    /** @return an array containing x and y */
    public float[] getXY() {
        return new float[] {x, y};
    }

    /** Returns the point in (x,y) format. */
    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }
}
