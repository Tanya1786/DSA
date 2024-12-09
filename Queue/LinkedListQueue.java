package Queue;

public class LinkedListQueue<T> implements Queue<T> {
    private Node<T> front;
    private Node<T> rear;
    private int size;

    public LinkedListQueue() {
        front = null;
        rear = null;
        size = 0;
    }

    @Override
    public void enqueue(T element) throws QueueFullException {
        Node<T> newNode = new Node<>(element);
        if (isEmpty()) {
            front = newNode;
        } else {
            rear.setNext(newNode);
        }
        rear = newNode;
        size++;
    }

    @Override
    public T dequeue() throws QueueEmptyException {
        if (isEmpty()) {
            throw new QueueEmptyException("Queue is empty");
        }
        T element = front.getData();
        front = front.getNext();
        size--;
        if (isEmpty()) {
            rear = null;
        }
        return element;
    }

    @Override
    public T peek() throws QueueEmptyException {
        if (isEmpty()) {
            throw new QueueEmptyException("Queue is empty");
        }
        return front.getData();
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String displayQueue() {
        if (isEmpty()) {
            return "Queue is empty";
        }
        
        StringBuilder sb = new StringBuilder("Linked List Queue contents (front to rear):\n");
        Node<T> current = front;
        
        while (current != null) {
            sb.append(current.getData()).append(" ");
            current = current.getNext();
        }
        
        return sb.toString();
    }
}
