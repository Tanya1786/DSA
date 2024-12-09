package partAandB;

/**
 * An exception that is thrown when expression is invalid.
 */
class InvalidExpressionException extends Exception {
    /**
     * Makes a new InvalidExpressionException 
     * @param message the detail message
     */
    public InvalidExpressionException(String message) {
        super(message);
    }
}
