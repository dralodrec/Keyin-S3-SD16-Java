/**
 * Models a rectangle using two MyPoint objects: top-left and bottom-right corners.
 * This class demonstrates composition because the rectangle is built from points.
 */
public class MyRectangle {
    private MyPoint topLeft;
    private MyPoint bottomRight;

    
    public MyRectangle(int topLeftX, int topLeftY, int bottomRightX, int bottomRightY) {
        this(new MyPoint(topLeftX, topLeftY), new MyPoint(bottomRightX, bottomRightY));
    }

    
    public MyRectangle(MyPoint topLeft, MyPoint bottomRight) {
        if (topLeft == null || bottomRight == null) {
            throw new IllegalArgumentException("Rectangle corners cannot be null.");
        }
        this.topLeft = new MyPoint(topLeft.getX(), topLeft.getY());
        this.bottomRight = new MyPoint(bottomRight.getX(), bottomRight.getY());
    }

    public MyPoint getTopLeft() {
        return new MyPoint(topLeft.getX(), topLeft.getY());
    }

    public void setTopLeft(MyPoint topLeft) {
        if (topLeft == null) {
            throw new IllegalArgumentException("Top-left point cannot be null.");
        }
        this.topLeft = new MyPoint(topLeft.getX(), topLeft.getY());
    }

    public MyPoint getBottomRight() {
        return new MyPoint(bottomRight.getX(), bottomRight.getY());
    }

    public void setBottomRight(MyPoint bottomRight) {
        if (bottomRight == null) {
            throw new IllegalArgumentException("Bottom-right point cannot be null.");
        }
        this.bottomRight = new MyPoint(bottomRight.getX(), bottomRight.getY());
    }

    public int getTopLeftX() {
        return topLeft.getX();
    }

    public int getTopLeftY() {
        return topLeft.getY();
    }

    public int getBottomRightX() {
        return bottomRight.getX();
    }

    public int getBottomRightY() {
        return bottomRight.getY();
    }

    /**
     * Returns the rectangle's width.
     */
    public int getWidth() {
        return Math.abs(bottomRight.getX() - topLeft.getX());
    }

    /**
     * Returns the rectangle's height.
     */
    public int getHeight() {
        return Math.abs(topLeft.getY() - bottomRight.getY());
    }

    /**
     * Returns the rectangle's area.
     */
    public int getArea() {
        return getWidth() * getHeight();
    }

    /**
     * Returns the rectangle's perimeter.
     */
    public int getPerimeter() {
        return 2 * (getWidth() + getHeight());
    }

    /**
     * Returns the diagonal length between the two corner points.
     */
    public double getDiagonalLength() {
        return topLeft.distance(bottomRight);
    }

    /**
     * Returns the center point of the rectangle.
     */
    public MyPoint getCenter() {
        int centerX = (topLeft.getX() + bottomRight.getX()) / 2;
        int centerY = (topLeft.getY() + bottomRight.getY()) / 2;
        return new MyPoint(centerX, centerY);
    }

    /**
     * Checks whether a point is inside or on the boundary of the rectangle.
     */
    public boolean contains(MyPoint point) {
        if (point == null) {
            return false;
        }

        int minX = Math.min(topLeft.getX(), bottomRight.getX());
        int maxX = Math.max(topLeft.getX(), bottomRight.getX());
        int minY = Math.min(topLeft.getY(), bottomRight.getY());
        int maxY = Math.max(topLeft.getY(), bottomRight.getY());

        return point.getX() >= minX && point.getX() <= maxX
                && point.getY() >= minY && point.getY() <= maxY;
    }

    @Override
    public String toString() {
        return "MyRectangle[topLeft=" + topLeft
                + ",bottomRight=" + bottomRight
                + ",width=" + getWidth()
                + ",height=" + getHeight() + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MyRectangle)) {
            return false;
        }
        MyRectangle other = (MyRectangle) obj;
        return topLeft.equals(other.topLeft) && bottomRight.equals(other.bottomRight);
    }

    @Override
    public int hashCode() {
        return 31 * topLeft.hashCode() + bottomRight.hashCode();
    }
}
