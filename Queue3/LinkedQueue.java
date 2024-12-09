package Queue3;

public class LinkedQueue<T> implements QueueInterface<T> {
    private Node<T> frontNode; 
    private Node<T> backNode;  

    public LinkedQueue() {
        frontNode = null;
        backNode = null;
    }

    @Override
    public void enqueue(T newEntry) {
        Node<T> newNode = new Node<>(newEntry, null);
        if (isEmpty()) {
            frontNode = newNode;
        } else {
            backNode.setNextNode(newNode);
        }
        backNode = newNode;
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new EmptyQueueException("Queue is empty.");
        } else {
            T frontData = frontNode.getData();
            frontNode = frontNode.getNextNode();
            if (frontNode == null) {
                backNode = null;
            }
            return frontData;
        }
    }

    @Override
    public T getFront() {
        if (isEmpty()) {
            throw new EmptyQueueException("Queue is empty.");
        } else {
            return frontNode.getData();
        }
    }

    @Override
    public boolean isEmpty() {
        return (frontNode == null) && (backNode == null);
    }

    @Override
    public void clear() {
        frontNode = null;
        backNode = null;
    }

    public void printQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }

        StringBuilder queueContents = new StringBuilder("Queue: ");
        Node<T> currentNode = frontNode;
        while (currentNode != null) {
            queueContents.append(currentNode.getData()).append(" ");
            currentNode = currentNode.getNextNode();
        }
        System.out.println(queueContents.toString().trim());
    }
}
