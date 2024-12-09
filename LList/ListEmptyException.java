package LList;

class ListEmptyException extends ListException {
    public ListEmptyException() {
        super("The list is empty");
    }
}
