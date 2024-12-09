package Queue2;

public class DLNode<T> {
    private T data;
    private DLNode<T> next;
    private DLNode<T> previous;

    public DLNode(DLNode<T> previousNode, T dataPortion, DLNode<T> nextNode) {
        data = dataPortion;
        next = nextNode;
        previous = previousNode;
    }

    public T getData() {
        return data;
    }

    public void setData(T newData) {
        data = newData;
    }

    public DLNode<T> getNextNode() {
        return next;
    }

    public void setNextNode(DLNode<T> nextNode) {
        next = nextNode;
    }

    public DLNode<T> getPreviousNode() {
        return previous;
    }

    public void setPreviousNode(DLNode<T> previousNode) {
        previous = previousNode;
    }
}
