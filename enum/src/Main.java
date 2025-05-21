public class Main {
    public static void main(String[] args) {
        double price = 100;

        System.out.println(Type.CHILD.priceDiscount(price));
        System.out.println(Type.ADULT.priceDiscount(price));
        System.out.println(Type.SENIOR.priceDiscount(price));
    }
}