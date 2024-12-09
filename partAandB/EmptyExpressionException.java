package partAandB;

/**
 * An exception that is thrown when expression is empty.
 */
class EmptyExpressionException extends Exception {   
    /**
     * Makes a new EmptyExpressionException
     * @param message the detail message
     */
    public EmptyExpressionException(String message) {
        super(message);
    }
}
