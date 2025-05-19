package Task2;

public class Rectangle {
    private Point topLeft;
    private Point bottomRight;

    public Rectangle(Point topLeft, Point bottomRight) {
        this.topLeft = topLeft;
        this.bottomRight = bottomRight;
    }
    public double countField() {
        double width = Math.abs(bottomRight.getX() - topLeft.getX());
        double height = Math.abs(bottomRight.getY() - topLeft.getY());

        return width * height;
    }

    public double countDiagonal() {
        double xDiagonal = bottomRight.getX() - topLeft.getX();
        double yDiagonal = bottomRight.getY() - topLeft.getY();

        return Math.sqrt(xDiagonal * xDiagonal + yDiagonal + yDiagonal);

    }
}
