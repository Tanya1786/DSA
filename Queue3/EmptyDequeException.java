package Queue3;

public class EmptyDequeException extends RuntimeException {
  public EmptyDequeException() {
      super();
  }

  public EmptyDequeException(String message) {
      super(message);
  }
}

