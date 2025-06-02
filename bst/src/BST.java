public class BST {
    private Node root;

    public void insert(int value) {
        root = insertRec(root, value);
    }

    private Node insertRec (Node node, int value) {
        if (node == null) {
            return new Node(value);
        }
        if (value < node.value) {
            node.left = insertRec(node.left, value);
        }
        else if (value > node.value) {
            node.right = insertRec(node.right, value);
        }
        return node;
    }

    public void inOrder() {
        inOrderRec(root);
        System.out.println();
    }

    public void inOrderRec(Node node) {
        if (node != null) {
            inOrderRec(node.left);
            System.out.println(node.value + " ");
            inOrderRec(node.right);
        }
    }

    public boolean contains (int value) {
        return containsRec(root, value);
    }

    public boolean containsRec (Node node, int value) {
        if (node == null) {
            return false;
        }
        if (node.value == value) {
            return true;
        }
        return node.value > value ? containsRec(node.left, value) : containsRec(node.right, value);
    }
}
