package linkedList;
/**
 * Interface for a LIFO data structure
 * 
 * @author Hugh Osborne
 * @version October 2016
 */

public interface Stack<T> extends LinearList<T>
{
    /**
     * Push a value to the top of the stack
     */
    public void push(T value);
    
    /**
     * Pop and return a value from the top of the stack
     * @return the topmost value on the stack
     * @throw ListAccessError if the stack is empty
     */
    public T pop() throws ListAccessError;
}
