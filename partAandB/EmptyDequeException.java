package partAandB;

/**
 * An exception that is thrown when trying a method that requires a non empty deque on empty deque.
 */
class EmptyDequeException extends Exception {    
    /**
     * Makes a new EmptyDequeException
     * @param message the detail message
     */
    public EmptyDequeException(String message) {
        super(message);
    }
}
