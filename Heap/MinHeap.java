package Heap;

import java.util.Scanner;

public final class MinHeap<T extends Comparable<? super T>> implements MinHeapInterface<T> {
    private T[] heap;
    private int lastIndex;
    private boolean integrityOK = false;
    private static final int DEFAULT_CAPACITY = 25;
    private static final int MAX_CAPACITY = 10000;

    public MinHeap(int initialCapacity) {
        if (initialCapacity < DEFAULT_CAPACITY) {
            initialCapacity = DEFAULT_CAPACITY;
        } else {
            checkCapacity(initialCapacity);
        }
        @SuppressWarnings("unchecked")
        T[] tempHeap = (T[]) new Comparable[initialCapacity + 1];
        heap = tempHeap;
        lastIndex = 0;
        integrityOK = true;
    }

    public MinHeap() {
        this(DEFAULT_CAPACITY);
    }

    @Override
    public T getMin() {
        checkIntegrity();
        if (isEmpty()) {
            System.out.println("Heap is empty.");
            return null;
        } else {
            return heap[1];
        }
    }

    @Override
    public boolean isEmpty() {
        return lastIndex < 1;
    }

    @Override
    public int getSize() {
        return lastIndex;
    }

    @Override
    public void add(T newEntry) {
        checkIntegrity();
        int newIndex = lastIndex + 1;
        int parentIndex = newIndex / 2;
        while ((parentIndex > 0) && newEntry.compareTo(heap[parentIndex]) < 0) {
            heap[newIndex] = heap[parentIndex];
            newIndex = parentIndex;
            parentIndex = newIndex / 2;
        }
        heap[newIndex] = newEntry;
        lastIndex++;
        ensureCapacity();
    }

    @Override
    public T removeMin() {
        checkIntegrity();
        if (isEmpty()) {
            System.out.println("Can't remove. Heap is empty.");
            return null;
        } else {
            T root = heap[1];
            heap[1] = heap[lastIndex];
            lastIndex--;
            reheap(1);
            return root;
        }
    }

    @Override
    public void clear() {
        checkIntegrity();
        while (lastIndex > -1) {
            heap[lastIndex] = null;
            lastIndex--;
        }
        lastIndex = 0;
    }

    @Override
    public void display() {
        checkIntegrity();
        if (isEmpty()) {
            System.out.println("Heap is empty.");
            return;
        }

        System.out.print("Heap: ");
        for (int index = 1; index <= lastIndex; index++) {
            System.out.print(heap[index] + " ");
        }
        System.out.println();
    }

    private void checkCapacity(int capacity) {
        if (capacity > MAX_CAPACITY) {
            throw new IllegalStateException("Attempt to create a heap whose capacity exceeds allowed maximum.");
        }
    }

    private void checkIntegrity() {
        if (!integrityOK) {
            throw new SecurityException("MinHeap object is corrupt.");
        }
    }

    private void ensureCapacity() {
        if (lastIndex >= heap.length - 1) {
            int newLength = 2 * heap.length;
            checkCapacity(newLength);
            heap = java.util.Arrays.copyOf(heap, newLength);
        }
    }

    private void reheap(int rootIndex) {
        boolean done = false;
        T orphan = heap[rootIndex];
        int leftChildIndex = 2 * rootIndex;

        while (!done && (leftChildIndex <= lastIndex)) {
            int smallerChildIndex = leftChildIndex;
            int rightChildIndex = leftChildIndex + 1;

            if ((rightChildIndex <= lastIndex) && heap[rightChildIndex].compareTo(heap[smallerChildIndex]) < 0) {
                smallerChildIndex = rightChildIndex;
            }

            if (orphan.compareTo(heap[smallerChildIndex]) > 0) {
                heap[rootIndex] = heap[smallerChildIndex];
                rootIndex = smallerChildIndex;
                leftChildIndex = 2 * rootIndex;
            } else {
                done = true;
            }
        }
        heap[rootIndex] = orphan;
    }
}