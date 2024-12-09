package cheatsheet.Queue;

public class EmptyDequeException extends RuntimeException {
  public EmptyDequeException() {
      super();
  }

  public EmptyDequeException(String message) {
      super(message);
  }
}

