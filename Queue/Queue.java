package Queue;

public interface Queue<T> {
 void enqueue(T element) throws QueueFullException;
 T dequeue() throws QueueEmptyException;
 T peek() throws QueueEmptyException;
 boolean isEmpty();
 boolean isFull();
 int size();
 String displayQueue();
}
