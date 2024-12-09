package Queue;

class QueueFullException extends Exception {
    public QueueFullException(String message) {
        super(message);
    }
}