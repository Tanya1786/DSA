package Queue3;

public final class CircularArrayQueue<T> implements QueueInterface<T> {
    private T[] queue;
    private int frontIndex;
    private int backIndex;
    private boolean integrityOK = false;
    private static final int DEFAULT_CAPACITY = 50;
    private static final int MAX_CAPACITY = 10000;
    public CircularArrayQueue() {
        this(DEFAULT_CAPACITY);
    }

    public CircularArrayQueue(int initialCapacity) {
        checkCapacity(initialCapacity);

        @SuppressWarnings("unchecked")
        T[] tempQueue = (T[]) new Object[initialCapacity + 1]; 
        queue = tempQueue;
        frontIndex = 0;
        backIndex = initialCapacity;
        integrityOK = true;
    }

    @Override
    public void enqueue(T newEntry) {
        checkIntegrity();
        ensureCapacity();
        backIndex = (backIndex + 1) % queue.length;
        queue[backIndex] = newEntry;
    }

    @Override
    public T getFront() {
        checkIntegrity();
        if (isEmpty()) {
            throw new EmptyQueueException("Queue is empty.");
        } else {
            return queue[frontIndex];
        }
    }

    @Override
    public T dequeue() {
        checkIntegrity();
        if (isEmpty()) {
            throw new EmptyQueueException("Queue is empty.");
        } else {
            T front = queue[frontIndex];
            queue[frontIndex] = null;
            frontIndex = (frontIndex + 1) % queue.length;
            return front;
        }
    }

    @Override
    public boolean isEmpty() {
        checkIntegrity();
        return frontIndex == ((backIndex + 1) % queue.length);
    }

    private void ensureCapacity() {
        if (frontIndex == ((backIndex + 2) % queue.length)) { 
            T[] oldQueue = queue;
            int oldSize = oldQueue.length;
            int newSize = 2 * oldSize;
            checkCapacity(newSize);

            @SuppressWarnings("unchecked")
            T[] tempQueue = (T[]) new Object[newSize];
            queue = tempQueue;

            for (int index = 0; index < oldSize - 1; index++) {
                queue[index] = oldQueue[frontIndex];
                frontIndex = (frontIndex + 1) % oldSize;
            }

            frontIndex = 0;
            backIndex = oldSize - 2;
            integrityOK = true;
        }
    }

    private void checkCapacity(int capacity) {
        if (capacity > MAX_CAPACITY) {
            throw new IllegalStateException("Attempt to create a queue " +
                    "whose capacity exceeds allowed maximum.");
        }
    }

    private void checkIntegrity() {
        if (!integrityOK) {
            throw new SecurityException("CircularArrayQueue object is corrupt.");
        }
    }

    @Override
    public void clear() {
        checkIntegrity();
        while (!isEmpty()) {
            dequeue();
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Queue: ");
        int index = frontIndex;
        while (index != (backIndex + 1) % queue.length) {
            builder.append(queue[index]).append(" ");
            index = (index + 1) % queue.length;
        }
        return builder.toString().trim();
    }
}
