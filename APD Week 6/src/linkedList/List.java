package linkedList;

/**
 * Interface for a random access data structure
 * 
 * @author Hugh Osborne
 * @version October 2016
 */

public interface List<T> extends LinearList<T>
{
    /**
     * Add a new value to the list at position index
     * @throw ListAccessError if index is an invalid index
     */
    public void add(int index,T value) throws ListAccessError;
    
    /**
     * Remove a value from the list
     * @return the value removed
     * @throw ListAccessError if index is an invalid index
     */
    public T remove(int index) throws ListAccessError;
    
    /**
     * Get a value from the list (do not remove it)
     * @return the value indexed
     * @throw ListAccessError if index is an invalid index
     */
    public T get(int index) throws ListAccessError;
}
