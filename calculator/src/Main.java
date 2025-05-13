import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        while(running) {
            System.out.println("Wprowadź pierwszą liczbę:");
            double x = scanner.nextDouble();
            System.out.println("Wprowadź drugą liczbę:");
            double y = scanner.nextDouble();
            System.out.println("Wprowadź operator matematyczny:");
            char op = scanner.next().charAt(0);

            double result = switch (op) {
                case '+' -> x + y;
                case '-' -> x - y;
                case '*' -> x * y;
                case '/' -> {
                    if (y == 0) {
                        yield Double.NaN;
                    } else {
                        yield x / y;
                    }
                }
                case '%' -> x % y;
                case '^' -> Math.pow(x, y);
                default -> Double.NaN;
            };
            System.out.println("Wynik działania: " + x + " " + op + " " + y + " = " + result);
            System.out.println("Czy chcesz wykonać kolejne działanie: y/n");

            char nextOperation = scanner.next().charAt(0);

            running = nextOperation == 'y';

            System.out.println(result % 2 == 0 ? "parzysta" : "nieparzysta");


        }
    }
}