package LList;

/** An interface for the ADT list.
Entries in the list have positions that begin with 1. */
public interface ListInterface<T> {
/**
 * Adds a new entry to the end of this list.
 * @param newEntry  The object to be added as a new entry.
 * @throws ListException if the list cannot accommodate the new entry
 */
public void add(T newEntry);

/**
 * Adds a new entry at a specified position within this list.
 * @param givenPosition  An integer that specifies the desired position of the new entry.
 * @param newEntry  The object to be added as a new entry.
 * @throws InvalidPositionException if either givenPosition < 1 or givenPosition > getLength() + 1
 */
public void add(int givenPosition, T newEntry);

/**
 * Removes and returns the entry at a given position from this list.
 * @param givenPosition  An integer that indicates the position of the entry to be removed.
 * @return  A reference to the removed entry.
 * @throws InvalidPositionException if either givenPosition < 1 or givenPosition > getLength()
 * @throws ListEmptyException if the list is empty
 */
public T remove(int givenPosition);

/**
 * Replaces the entry at a given position in this list.
 * @param givenPosition  An integer that indicates the position of the entry to be replaced.
 * @param newEntry  The object that will replace the entry at the position givenPosition.
 * @return  The original entry that was replaced.
 * @throws InvalidPositionException if either givenPosition < 1 or givenPosition > getLength()
 * @throws ListEmptyException if the list is empty
 */
public T replace(int givenPosition, T newEntry);

/**
 * Retrieves the entry at a given position in this list.
 * @param givenPosition  An integer that indicates the position of the desired entry.
 * @return  A reference to the indicated entry.
 * @throws InvalidPositionException if either givenPosition < 1 or givenPosition > getLength()
 * @throws ListEmptyException if the list is empty
 */
public T getEntry(int givenPosition);

/**
 * Determines whether this list contains a given entry.
 * @param anEntry  The object that is the desired entry.
 * @return  True if the list contains anEntry, or false if not.
 */
public boolean contains(T anEntry);

/**
 * Gets the current number of entries in this list.
 * @return  The integer number of entries currently in the list.
 */
public int getLength();

/**
 * Determines whether this list is empty.
 * @return  True if the list is empty, or false if not.
 */
public boolean isEmpty();

/**
 * Retrieves all entries that are in this list in the order in which they occur.
 * @return  A newly allocated array of all the entries in the list.
 */
public T[] toArray();

/**
 * Removes all entries from this list.
 */
public void clear();

/**
 * Displays all entries in the list.
 * @throws ListEmptyException if the list is empty
 */
public void display();
}

