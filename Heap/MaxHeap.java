package Heap;

import java.util.Arrays;

public final class MaxHeap<T extends Comparable<? super T>> implements MaxHeapInterface<T> {
   private T[] heap;
   private int lastIndex;
   private boolean integrityOK;
   private static final int DEFAULT_CAPACITY = 25;
   private static final int MAX_CAPACITY = 10000;

   public MaxHeap(int initialCapacity) {
      this.integrityOK = false;
      if (initialCapacity < DEFAULT_CAPACITY) {
         initialCapacity = DEFAULT_CAPACITY;
      } else {
         this.checkCapacity(initialCapacity);
      }

      @SuppressWarnings("unchecked")
      T[] tempHeap = (T[]) new Comparable[initialCapacity + 1];
      this.heap = tempHeap;
      this.lastIndex = 0;
      this.integrityOK = true;
   }

   public MaxHeap() {
      this(DEFAULT_CAPACITY);
   }

   public T getMax() {
      this.checkIntegrity();
      if (this.isEmpty()) {
         System.out.println("Heap is empty.");
         return null;
      } else {
         return this.heap[1];
      }
   }

   public boolean isEmpty() {
      return this.lastIndex < 1;
   }

   public int getSize() {
      return this.lastIndex;
   }

   public void add(T newEntry) {
      this.checkIntegrity();
      int newIndex = this.lastIndex + 1;
      int parentIndex = newIndex / 2;

      while ((parentIndex > 0) && newEntry.compareTo(this.heap[parentIndex]) > 0) {
         this.heap[newIndex] = this.heap[parentIndex];
         newIndex = parentIndex;
         parentIndex = newIndex / 2;
      }

      this.heap[newIndex] = newEntry;
      ++this.lastIndex;
      this.ensureCapacity();
   }

   public T removeMax() {
      this.checkIntegrity();
      if (this.isEmpty()) {
         System.out.println("Can't remove. Heap is empty.");
         return null;
      } else {
         T root = this.heap[1];
         this.heap[1] = this.heap[this.lastIndex];
         --this.lastIndex;
         this.reheap(1);
         return root;
      }
   }

   public void clear() {
      this.checkIntegrity();
      while (this.lastIndex > -1) {
         this.heap[this.lastIndex] = null;
         --this.lastIndex;
      }
      this.lastIndex = 0;
   }

   public void display() {
      this.checkIntegrity();
      if (this.isEmpty()) {
         System.out.println("Heap is empty.");
      } else {
         StringBuilder heapContents = new StringBuilder("Heap: ");
         for (int index = 1; index <= this.lastIndex; ++index) {
            heapContents.append(this.heap[index]).append(" ");
         }
         System.out.println(heapContents.toString().trim());
      }
   }

   private void checkCapacity(int capacity) {
      if (capacity > MAX_CAPACITY) {
         throw new IllegalStateException("Attempt to create a heap whose capacity exceeds allowed maximum.");
      }
   }

   private void checkIntegrity() {
      if (!this.integrityOK) {
         throw new SecurityException("MaxHeap object is corrupt.");
      }
   }

   private void ensureCapacity() {
      if (this.lastIndex >= this.heap.length - 1) {
         int newLength = 2 * this.heap.length;
         this.checkCapacity(newLength);
         this.heap = Arrays.copyOf(this.heap, newLength);
      }
   }

   private void reheap(int rootIndex) {
      boolean done = false;
      T orphan = this.heap[rootIndex];
      int leftChildIndex = 2 * rootIndex;

      while (!done && (leftChildIndex <= this.lastIndex)) {
         int largerChildIndex = leftChildIndex;
         int rightChildIndex = leftChildIndex + 1;

         if ((rightChildIndex <= this.lastIndex) && 
             this.heap[rightChildIndex].compareTo(this.heap[largerChildIndex]) > 0) {
            largerChildIndex = rightChildIndex;
         }

         if (orphan.compareTo(this.heap[largerChildIndex]) < 0) {
            this.heap[rootIndex] = this.heap[largerChildIndex];
            rootIndex = largerChildIndex;
            leftChildIndex = 2 * rootIndex;
         } else {
            done = true;
         }
      }
      this.heap[rootIndex] = orphan;
   }
}