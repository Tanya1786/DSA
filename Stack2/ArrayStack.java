package Stack2;

import java.util.EmptyStackException;
import java.util.Arrays;

public class ArrayStack<T> implements StackInterface<T> {
   private T[] stack;
   private int topIndex;
   private static final int DEFAULT_CAPACITY = 10;
   
   @SuppressWarnings("unchecked")
   public ArrayStack() {
       stack = (T[])new Object[DEFAULT_CAPACITY];
       topIndex = -1;
   }

   @Override
   public void push(T newEntry) {
       if (topIndex == stack.length - 1) { // Stack is full, double the size
           stack = Arrays.copyOf(stack, 2 * stack.length);
       }
       stack[++topIndex] = newEntry;
   }

   @Override
   public T pop() {
       if (isEmpty()) {
           throw new EmptyStackException();
       }
       T top = stack[topIndex];
       stack[topIndex--] = null; // Dereference to help garbage collection
       return top;
   }

   @Override
   public T peek() {
       if (isEmpty()) {
           throw new EmptyStackException();
       }
       return stack[topIndex];
   }

   @Override
   public boolean isEmpty() {
       return topIndex < 0;
   }

   @Override
   public void clear() {
       while (!isEmpty()) {
           pop();
       }
   }
} // end ArrayStack
