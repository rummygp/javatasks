public class Main {
    public static void main(String[] args) {
        Stack <Integer> stack = new Stack<>();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println(stack.pop());
        System.out.println(stack.remove(10));
        System.out.println(stack.contains(30));
        System.out.println(stack.contains(20));
        System.out.println(stack.contains(10));
    }
}