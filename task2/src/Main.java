import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj wielkość piramidy:");
        int size = scanner.nextInt();

        for (int i = size; i > 0; i--) {
            for (int j = i; j > 0; j--) {
                System.out.print(" ");
            }
            for (int k = 2 * (size - i) + 1; k > 0; k--){
                System.out.print("*");
            }
            System.out.println();
        }

    }
}