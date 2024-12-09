package cheatsheet.Stack;

import java.util.EmptyStackException;

public final class LinkedStack<T> implements StackInterface<T> {
    private Node<T> topNode; 

    public LinkedStack() {
        topNode = null;
    }

    @Override
    public void push(T newEntry) {
        Node<T> newNode = new Node<>(newEntry, topNode);
        topNode = newNode;
    }

    @Override
    public T pop() {
        T topData = peek();
        if (topNode != null) {
            topNode = topNode.getNextNode();
        }
        return topData;
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return topNode.getData();
    }

    @Override
    public boolean isEmpty() {
        return topNode == null;
    }

    @Override
    public void clear() {
        topNode = null;
    }
}

