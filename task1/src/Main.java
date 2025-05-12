import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj wymiary prostokąta:");
        System.out.println("Długość:");
        int x = scanner.nextInt();
        System.out.println("Szerokość:");
        int y = scanner.nextInt();

        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if (i == 0 || i == y - 1 || j == 0 || j == x - 1) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }

            }
            System.out.println();
        }

    }
}