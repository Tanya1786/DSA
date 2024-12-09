package partAandB;
/**
 * An interface that defines the operations for a deque.
 *
 * @param <T> the type of elements the deque
 */
public interface DequeInterface<T> {
     /**
     * Add a new entry to the front of the deque.
     *
     * @param newEntry the new entry to add to the front of the deque
     */
    void addToFront(T newEntry);
    /**
     * Add a new entry to the back of the deque.
     *
     * @param newEntry the new entry to add to the back of the deque
     */
    void addToBack(T newEntry);
    /**
     * Removes and returns the front entry of the deque.
     *
     * @return the front entry of the deque
     * @throws IllegalStateException if the deque is empty 
     */
    T removeFront();
    /**
     * Removes and returns the back entry of the deque.
     *
     * @return the back entry of the deque
     * @throws IllegalStateException if the deque is empty 
     */
    T removeBack();
    /**
     * Retrieves the front entry of the deque.
     *
     * @return the front entry of this deque
     * @throws IllegalStateException if the deque is empty
     */
    T getFront();
    
    /**
     * Retrieves the back entry of the deque.
     *
     * @return the back entry of the deque
     * @throws IllegalStateException if the deque is empty
     */
    T getBack();
    /**
     * Checks if the deque is empty.
     *
     * @return true if the deque is empty, or false if not
     */
    boolean isEmpty();
    
    /**
     * Removes all entries from the deque.
     */
    void clear();
}
