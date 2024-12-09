package Queue2;
public class EmptyQueueException extends RuntimeException {
    public EmptyQueueException() {
        super();
    }

    public EmptyQueueException(String message) {
        super(message);
    }
}
