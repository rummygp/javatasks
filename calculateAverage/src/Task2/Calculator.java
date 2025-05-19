package Task2;

public class Calculator {
    public static void main(String[] args) {
        Point topLeft = new Point(-2, 3);
        Point bottomRight = new Point(4, -5);

        Rectangle rectangle = new Rectangle(topLeft, bottomRight);

        System.out.println("Pole prostokąta: " + rectangle.countField());
        System.out.println("Przekątna prostokąta: " + rectangle.countDiagonal());
    }
}
