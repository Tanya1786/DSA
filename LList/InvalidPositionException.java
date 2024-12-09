package LList;


class InvalidPositionException extends ListException {
    public InvalidPositionException() {
        super("The position is invalid for this operation");
    }
}