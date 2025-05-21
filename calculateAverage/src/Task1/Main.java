package Task1;

public class Main {
    public static void main(String[] args) {
        double[] array = {1, 2, 3, 4};

        double average = calcAverage(array);
        System.out.println("Średnia: " + average);
    }

    private static double calcAverage(double[] numbers) {

        double sum = 0;
        for (double num : numbers) {
            sum += num;
        }
        return sum / numbers.length;
    }

}
