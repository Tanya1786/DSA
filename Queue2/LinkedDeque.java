package Queue2;

import javax.swing.JOptionPane;

public final class LinkedDeque<T> implements DequeInterface<T> {
    private DLNode<T> firstNode;
    private DLNode<T> lastNode;

    public LinkedDeque() {
        firstNode = null;
        lastNode = null;
    }

    @Override
    public void addToFront(T newEntry) {
        DLNode<T> newNode = new DLNode<>(null, newEntry, firstNode);

        if (isEmpty()) {
            lastNode = newNode;
        } else {
            firstNode.setPreviousNode(newNode);
        }
        firstNode = newNode;
    }

    @Override
    public void addToBack(T newEntry) {
        DLNode<T> newNode = new DLNode<>(lastNode, newEntry, null);

        if (isEmpty()) {
            firstNode = newNode;
        } else {
            lastNode.setNextNode(newNode);
        }
        lastNode = newNode;
    }

    @Override
    public T removeFront() {
        if (isEmpty()) {
            throw new EmptyQueueException("Deque is empty.");
        }

        T front = firstNode.getData();
        firstNode = firstNode.getNextNode();

        if (firstNode == null) {
            lastNode = null;
        } else {
            firstNode.setPreviousNode(null);
        }
        return front;
    }

    @Override
    public T removeBack() {
        if (isEmpty()) {
            throw new EmptyQueueException("Deque is empty.");
        }

        T back = lastNode.getData();
        lastNode = lastNode.getPreviousNode();

        if (lastNode == null) {
            firstNode = null;
        } else {
            lastNode.setNextNode(null);
        }
        return back;
    }

    @Override
    public T getFront() {
        if (isEmpty()) {
            throw new EmptyQueueException("Deque is empty.");
        }
        return firstNode.getData();
    }

    @Override
    public T getBack() {
        if (isEmpty()) {
            throw new EmptyQueueException("Deque is empty.");
        }
        return lastNode.getData();
    }

    @Override
    public boolean isEmpty() {
        return (firstNode == null) && (lastNode == null);
    }

    @Override
    public void clear() {
        firstNode = null;
        lastNode = null;
    }

    @Override
    public void display() {
        if (isEmpty()) {
            JOptionPane.showMessageDialog(null, "Deque is empty.");
            return;
        }

        StringBuilder dequeContents = new StringBuilder("Deque: ");
        DLNode<T> currentNode = firstNode;
        while (currentNode != null) {
            dequeContents.append(currentNode.getData()).append(" ");
            currentNode = currentNode.getNextNode();
        }
        JOptionPane.showMessageDialog(null, dequeContents.toString().trim());
    }
}
