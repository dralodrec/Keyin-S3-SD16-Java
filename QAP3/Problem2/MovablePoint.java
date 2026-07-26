/**
 * Represents a point that can move using x-speed and y-speed.
 */
public class MovablePoint extends Point {
    private float xSpeed;
    private float ySpeed;

    /** Creates a movable point at (0, 0) with no speed. */
    public MovablePoint() {
        this(0.0f, 0.0f, 0.0f, 0.0f);
    }

    /** Creates a movable point at (0, 0) with the given speed. */
    public MovablePoint(float xSpeed, float ySpeed) {
        this(0.0f, 0.0f, xSpeed, ySpeed);
    }

    /** Creates a movable point with coordinates and speed. */
    public MovablePoint(float x, float y, float xSpeed, float ySpeed) {
        super(x, y);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    /** @return the horizontal speed */
    public float getXSpeed() {
        return xSpeed;
    }

    /** @param xSpeed the new horizontal speed */
    public void setXSpeed(float xSpeed) {
        this.xSpeed = xSpeed;
    }

    /** @return the vertical speed */
    public float getYSpeed() {
        return ySpeed;
    }

    /** @param ySpeed the new vertical speed */
    public void setYSpeed(float ySpeed) {
        this.ySpeed = ySpeed;
    }

    /** Changes both speed values. */
    public void setSpeed(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    /** @return an array containing x-speed and y-speed */
    public float[] getSpeed() {
        return new float[] {xSpeed, ySpeed};
    }

    /** Returns the point and its speed. */
    @Override
    public String toString() {
        return super.toString()
                + ",speed=(" + xSpeed + "," + ySpeed + ")";
    }

    /** Moves the point once and returns the same object. */
    public MovablePoint move() {
        // x and y are private in Point, so getters and setters are required.
        setX(getX() + xSpeed);
        setY(getY() + ySpeed);
        return this;
    }
}
