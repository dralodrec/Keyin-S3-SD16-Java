/**
 * Test driver for the MyRectangle and MyPoint classes.
 */
public class TestMyRectangle {
    public static void main(String[] args) {
        System.out.println("Testing MyRectangle:");
        MyRectangle rectangle1 = new MyRectangle(2, 10, 12, 2);
        System.out.println("rectangle1 = " + rectangle1);
        System.out.println("Top-left = " + rectangle1.getTopLeft());
        System.out.println("Bottom-right = " + rectangle1.getBottomRight());
        System.out.println("Width = " + rectangle1.getWidth());
        System.out.println("Height = " + rectangle1.getHeight());
        System.out.println("Area = " + rectangle1.getArea());
        System.out.println("Perimeter = " + rectangle1.getPerimeter());
        System.out.printf("Diagonal length = %.2f%n", rectangle1.getDiagonalLength());
        System.out.println("Center = " + rectangle1.getCenter());
        System.out.println("Contains (5,5)? " + rectangle1.contains(new MyPoint(5, 5)));
        System.out.println("Contains (20,20)? " + rectangle1.contains(new MyPoint(20, 20)));
        System.out.println();

        MyRectangle rectangle2 = new MyRectangle(new MyPoint(0, 20), new MyPoint(15, 0));
        System.out.println("rectangle2 = " + rectangle2);
        rectangle2.setTopLeft(new MyPoint(1, 18));
        rectangle2.setBottomRight(new MyPoint(11, 3));
        System.out.println("rectangle2 after setters = " + rectangle2);
        System.out.println("Top-left X = " + rectangle2.getTopLeftX());
        System.out.println("Top-left Y = " + rectangle2.getTopLeftY());
        System.out.println("Bottom-right X = " + rectangle2.getBottomRightX());
        System.out.println("Bottom-right Y = " + rectangle2.getBottomRightY());
        System.out.println("Area = " + rectangle2.getArea());
        System.out.println("Perimeter = " + rectangle2.getPerimeter());
        System.out.println("Center = " + rectangle2.getCenter());
        System.out.println();

        MyRectangle rectangle3 = new MyRectangle(1, 18, 11, 3);
        System.out.println("rectangle2 equals rectangle3? " + rectangle2.equals(rectangle3));
    }
}
