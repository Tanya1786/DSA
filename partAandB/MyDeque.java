package partAandB;

/**
 * An implementation of the DequeInterface using a double linked list.
 *
 * @param <T> the type of elements held in this deque
 */
public class MyDeque<T> implements DequeInterface<T> {
    private Node<T> front;
    private Node<T> back;
    private int size;

    /**
     * Initializes an empty deque.
     */
    public MyDeque() {
        front = null;
        back = null;
        size = 0;
    }

    @Override
    public void addToFront(T newEntry) {
        Node<T> newNode = new Node<>(newEntry);
        if (isEmpty()) {
            front = back = newNode;
        } else {
            newNode.next = front;
            front.previous = newNode;
            front = newNode;
        }
        size++;
    }

    @Override
    public void addToBack(T newEntry) {
        Node<T> newNode = new Node<>(newEntry);
        
        if (isEmpty()) {
            front = back = newNode;
        } else {
            newNode.previous = back;
            back.next = newNode;
            back = newNode;
        }
        size++;
    }

    @Override
    public T removeFront() {
        if (isEmpty()) {
            throw new IllegalStateException("Can't remove. Empty deque.");
        }
        T removedData = front.data;
        if (front == back) { 
            front = back = null;
        } else {
            front = front.next;
            front.previous = null;
        }
        size--;
        return removedData;
    }

    @Override
    public T removeBack() {
        if (isEmpty()) {
            throw new IllegalStateException("Can't remove. Empty deque");
        }
        T removedData = back.data;
        //if only 1 element in deque
        if (front == back) { 
            front = back = null;
        } else {
            back = back.previous;
            back.next = null;
        }
        size--;
        return removedData;
    }

    @Override
    public T getFront() {
        if (isEmpty()) {
            throw new IllegalStateException("Deque is empty");
        }
        return front.data;
    }

    @Override
    public T getBack() {
        if (isEmpty()) {
            throw new IllegalStateException("Deque is empty");
        }
        return back.data;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        front = null;
        back = null;
        size = 0;
    }
}
