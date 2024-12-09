package partAandB;

/**
 * A node in the double linked list used for deque implementation.
 * @param <T> the type of elements in node
 */
class Node<T> {
    T data;
    Node<T> next;
    Node<T> previous;
    /**
     * Create a new node with the set data
     * @param data the data to store in the node
     */
    public Node(T data) {
        this.data = data;
        this.next = null;
        this.previous = null;
    }
}
