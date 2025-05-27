import java.util.ArrayList;

public class Main {
    public static ArrayList<Long> list = new ArrayList<>();

    public static void main(String[] args) {
        list.add(0L);
        list.add(1L);
        System.out.println(fibonacci(100));


    }

    public static long fibonacci(int n) {
        if (n < list.size()) {
            return list.get(n);
        }
        long value = fibonacci(n - 1) + fibonacci(n - 2);
        list.add(value);
        return value;
    }
}