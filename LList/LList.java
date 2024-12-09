package LList;

public class LList<T> implements ListInterface<T> {
    private Node<T> firstNode;
    private Node<T> lastNode;
    private int numberOfEntries;

    public LList() {
        initializeDataFields();
    }

    private void initializeDataFields() {
        firstNode = null;
        lastNode = null;
        numberOfEntries = 0;
    }

    public void add(T newEntry) {
        Node<T> newNode = new Node<>(newEntry);
        if (isEmpty()) {
            firstNode = newNode;
        } else {
            lastNode.setNextNode(newNode);
        }
        lastNode = newNode;
        numberOfEntries++;
    }

    public void add(int givenPosition, T newEntry) {
        if ((givenPosition >= 1) && (givenPosition <= numberOfEntries + 1)) {
            Node<T> newNode = new Node<>(newEntry);
            if (isEmpty()) {
                firstNode = newNode;
                lastNode = newNode;
            } else if (givenPosition == 1) {
                newNode.setNextNode(firstNode);
                firstNode = newNode;
            } else if (givenPosition == numberOfEntries + 1) {
                lastNode.setNextNode(newNode);
                lastNode = newNode;
            } else {
                Node<T> nodeBefore = getNodeAt(givenPosition - 1);
                Node<T> nodeAfter = nodeBefore.getNextNode();
                newNode.setNextNode(nodeAfter);
                nodeBefore.setNextNode(newNode);
            }
            numberOfEntries++;
        } else {
            throw new InvalidPositionException();
        }
    }

    public T remove(int givenPosition) {
        if (isEmpty()) {
            throw new ListEmptyException();
        }
        
        T result = null;
        if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
            if (givenPosition == 1) {
                result = firstNode.getData();
                firstNode = firstNode.getNextNode();
                if (numberOfEntries == 1) {
                    lastNode = null;
                }
            } else {
                Node<T> nodeBefore = getNodeAt(givenPosition - 1);
                Node<T> nodeToRemove = nodeBefore.getNextNode();
                result = nodeToRemove.getData();
                Node<T> nodeAfter = nodeToRemove.getNextNode();
                nodeBefore.setNextNode(nodeAfter);
                if (givenPosition == numberOfEntries) {
                    lastNode = nodeBefore;
                }
            }
            numberOfEntries--;
            return result;
        } else {
            throw new InvalidPositionException();
        }
    }

    public T replace(int givenPosition, T newEntry) {
        if (isEmpty()) {
            throw new ListEmptyException();
        }
        if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
            Node<T> desiredNode = getNodeAt(givenPosition);
            T originalEntry = desiredNode.getData();
            desiredNode.setData(newEntry);
            return originalEntry;
        } else {
            throw new InvalidPositionException();
        }
    }

    public T getEntry(int givenPosition) {
        if (isEmpty()) {
            throw new ListEmptyException();
        }
        if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
            return getNodeAt(givenPosition).getData();
        } else {
            throw new InvalidPositionException();
        }
    }

    public boolean contains(T anEntry) {
        if (isEmpty()) {
            return false;
        }
        boolean found = false;
        Node<T> currentNode = firstNode;
        
        while (!found && (currentNode != null)) {
            if (anEntry.equals(currentNode.getData())) {
                found = true;
            } else {
                currentNode = currentNode.getNextNode();
            }
        }
        return found;
    }

    public void clear() {
        initializeDataFields();
    }

    public int getLength() {
        return numberOfEntries;
    }

    public boolean isEmpty() {
        return numberOfEntries == 0;
    }

    @SuppressWarnings("unchecked")
    public T[] toArray() {
        if (isEmpty()) {
            return (T[])new Object[0];
        }
        
        T[] result = (T[])new Object[numberOfEntries];
        int index = 0;
        Node<T> currentNode = firstNode;
        
        while ((index < numberOfEntries) && (currentNode != null)) {
            result[index] = currentNode.getData();
            currentNode = currentNode.getNextNode();
            index++;
        }
        
        return result;
    }

    private Node<T> getNodeAt(int givenPosition) {
        if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
            Node<T> currentNode = firstNode;
            for (int counter = 1; counter < givenPosition; counter++) {
                currentNode = currentNode.getNextNode();
            }
            return currentNode;
        }
        return null;
    }

    public void display() {
        if (isEmpty()) {
            throw new ListEmptyException();
        }
        
        Node<T> currentNode = firstNode;
        int position = 1;
        while (currentNode != null) {
            System.out.println("Position " + position + ": " + currentNode.getData());
            currentNode = currentNode.getNextNode();
            position++;
        }
    }
    
    public int findPosition(T anEntry) {
        if (isEmpty()) {
            return -1;
        }
        Node<T> currentNode = firstNode;
        int position = 1;
        
        while (currentNode != null) {
            if (anEntry.equals(currentNode.getData())) {
                return position;
            }
            currentNode = currentNode.getNextNode();
            position++;
        }
        return -1;  // Return -1 if item not found
    }
}