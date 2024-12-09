package Stack;

public class LinkedStack<T> implements StackInterface<T> {
private Node<T> topNode;
public LinkedStack() { topNode = null;}
@Override
public void push(T newEntry) { Node<T> newNode = new Node<>(newEntry, topNode);
topNode = newNode; }
@Override
public T pop() { T top = peek(); topNode = topNode.getNextNode(); return top;}
@Override
public T peek() { if (isEmpty()) throw new EmptyStackException("Cannot peek an empty stack"); else return topNode.getData(); }
@Override
public boolean isEmpty() { return topNode == null; }

@Override
public void clear() { topNode = null;}

@Override
public void display() { if (isEmpty()) { System.out.println("Stack is empty"); return; }
StringBuilder displayText = new StringBuilder("Stack contents (top to bottom):\n");
Node<T> currentNode = topNode;
while (currentNode != null) { displayText.append(currentNode.getData()).append("\n");
currentNode = currentNode.getNextNode(); }
System.out.println(displayText.toString()); }}