public class Main {
    public static void main(String[] args) {

        int size = 8;
        System.out.print(" ");
        for (int i = 0; i < size; i++) {
            char letter = (char)('A' + i);
            System.out.print(letter + " \t");
        }
        System.out.println();
        for (int i = 0; i < size; i++) {
            System.out.print(8 - i + " ");
            for (int j = 0; j < size ; j++) {
                if ((i + j) % 2 == 0) {
                    System.out.print(" \t");
                } else {
                    System.out.print("#\t");
                }
            }
            System.out.println();
        }
    }
}