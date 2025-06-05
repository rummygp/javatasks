public class Main {
    public static void main(String[] args) {
        MathOperation add = (a, b) -> a + b;
        MathOperation subtract = (a, b) -> a - b;
        MathOperation multiply = (a, b) -> a * b;
        MathOperation divide = (a, b) -> {
            if (b == 0) {
                throw new IllegalArgumentException("You can't divide by 0");
            }
            return a / b;
        };
        try {
            calculate(5, 20, add);
            calculate(5, 20, subtract);
            calculate(5, 20, multiply);
            calculate(5, 20, divide);
            calculate(5, 0, divide);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void calculate(int a, int b, MathOperation calc) {
        int result = calc.mathOp(a, b);
        System.out.println(result);
    }
}
