package Stack;

public interface StackInterface<T> {  void push(T newEntry);  T pop() throws EmptyStackException;
   T peek() throws EmptyStackException; boolean isEmpty(); void clear(); void display();}