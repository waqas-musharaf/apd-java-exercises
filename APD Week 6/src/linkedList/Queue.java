package linkedList;

/**
 * Interface for a FIFO data structure
 * 
 * @author Hugh Osborne
 * @version October 2016
 */

public interface Queue<T> extends LinearList<T>
{
    /**
     * Add a value to the queue
     */
    public void enqueue(T value);
    
    /**
     * Remove a value from the queue
     * @return the oldest value in the queue
     * @throw ListAccessError if the queue is empty
     */
    public T dequeue() throws ListAccessError;
}
