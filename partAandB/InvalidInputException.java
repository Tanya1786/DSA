package partAandB;

/**
 * An exception that is thrown when an invalid input is inserted.
 */
class InvalidInputException extends Exception {
    /**
     * Makes a new InvalidInputException 
     * @param message the detail message
     */
    public InvalidInputException(String message) {
        super(message);
    }
}
