import java.util.Arrays;

/**
 * Models a line segment with a beginning point and an ending point.
 * This class uses two MyPoint objects through aggregation.
 */
public class MyLine {
    private MyPoint begin;
    private MyPoint end;

    
    public MyLine(int x1, int y1, int x2, int y2) {
        this.begin = new MyPoint(x1, y1);
        this.end = new MyPoint(x2, y2);
    }

    
    public MyLine(MyPoint begin, MyPoint end) {
        if (begin == null || end == null) {
            throw new IllegalArgumentException("Begin and end points cannot be null.");
        }
        this.begin = new MyPoint(begin.getX(), begin.getY());
        this.end = new MyPoint(end.getX(), end.getY());
    }

    public MyPoint getBegin() {
        return new MyPoint(begin.getX(), begin.getY());
    }

    public void setBegin(MyPoint begin) {
        if (begin == null) {
            throw new IllegalArgumentException("Begin point cannot be null.");
        }
        this.begin = new MyPoint(begin.getX(), begin.getY());
    }

    public MyPoint getEnd() {
        return new MyPoint(end.getX(), end.getY());
    }

    public void setEnd(MyPoint end) {
        if (end == null) {
            throw new IllegalArgumentException("End point cannot be null.");
        }
        this.end = new MyPoint(end.getX(), end.getY());
    }

    public int getBeginX() {
        return begin.getX();
    }

    public void setBeginX(int x) {
        begin.setX(x);
    }

    public int getBeginY() {
        return begin.getY();
    }

    public void setBeginY(int y) {
        begin.setY(y);
    }

    public int getEndX() {
        return end.getX();
    }

    public void setEndX(int x) {
        end.setX(x);
    }

    public int getEndY() {
        return end.getY();
    }

    public void setEndY(int y) {
        end.setY(y);
    }

    public int[] getBeginXY() {
        return begin.getXY();
    }

    public void setBeginXY(int x, int y) {
        begin.setXY(x, y);
    }

    public int[] getEndXY() {
        return end.getXY();
    }

    public void setEndXY(int x, int y) {
        end.setXY(x, y);
    }

    /**
     * Calculates the line length using MyPoint's distance method.
     */
    public double getLength() {
        return begin.distance(end);
    }

    /**
     * Returns the gradient angle in radians.
     */
    public double getGradient() {
        int xDiff = end.getX() - begin.getX();
        int yDiff = end.getY() - begin.getY();
        return Math.atan2(yDiff, xDiff);
    }

    @Override
    public String toString() {
        return "MyLine[begin=" + begin + ",end=" + end + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MyLine)) {
            return false;
        }
        MyLine other = (MyLine) obj;
        return begin.equals(other.begin) && end.equals(other.end);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(new Object[] { begin, end });
    }
}
