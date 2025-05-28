public class Main {
    public static void main(String[] args) {
    BST tree = new BST ();

    tree.insert(10);
    tree.insert(5);
    tree.insert(15);
    System.out.println(tree.contains(15));
    }
}