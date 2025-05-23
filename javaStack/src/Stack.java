public class Stack <T> {
    private int size;
    private Node<T> top;

    public Stack() {
        this.size = 0;
        this.top = null;
    }

    public void push(T data) {
        Node<T> node = new Node<>(data);
        node.setNext(top);
        top = node;
        size++;
    }

    public T pop() {
        if (top == null) {
            System.out.println("Stack is empty");
            return null;
        }
        T data = top.getData();
        top = top.getNext();
        size--;
        return data;
    }

    public void addFist(T data) {
        Node<T> node = new Node<>(data);
        if (top == null) {
            top = node;
            size++;
        }
        Node<T> current = top;
        while (current.getNext() != null) {
            current = current.getNext();
        }
        current.setNext(node);
        size++;
    }

    public boolean contains(T data) {
        Node<T> current = top;
        while (current != null) {
            if (current.getData().equals(data)) {
                return true;
            }
            current = current.getNext();
        }
        return false;

    }
    public boolean remove (T data) {
        if (top == null) {
            return false;
        }
        if (top.getData().equals(data)) {
            top = top.getNext();
            size--;
            return true;
        } else {
            Node<T> current = top;
            while (current.getNext() != null) {
                if (current.getNext().getData().equals(data)) {
                    current.setNext(current.getNext().getNext());
                    size--;
                    return true;
                }
                current = current.getNext();
            } return false;
        }
    }
}
