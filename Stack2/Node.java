package cheatsheet.Stack;

public class Node<T> {
  private T data; // Entry in stack
  private Node<T> next; // Link to next node

  public Node(T data, Node<T> next) {
      this.data = data;
      this.next = next;
  }

  public T getData() {
      return data;
  }

  public void setData(T data) {
      this.data = data;
  }

  public Node<T> getNextNode() {
      return next;
  }

  public void setNextNode(Node<T> next) {
      this.next = next;
  }
}
