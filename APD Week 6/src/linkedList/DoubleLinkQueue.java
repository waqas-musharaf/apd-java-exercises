package linkedList;

/**
 * Implementation of a basic queue class using doubly linked lists.
 * 
 * @author Hugh Osborne 
 * @version October 2016
 */
public class DoubleLinkQueue<T> extends SingleLinkStack<T> implements Queue<T>
{
    DoubleLinkNode<T> head, tail; // pointer to first and last entry in the queue
    
    /**
     * Add a new value to the queue
     */
    public void enqueue(T value) {
        if (isEmpty()) { // if the queue is empty
            head = new DoubleLinkNode<T>(value); // create a new node, which will be the head of the queue
            tail = head; // and which will also be the tail
        } else {
            DoubleLinkNode<T> oldHead = head; // make a note of the current head node
            head = new DoubleLinkNode<T>(value,oldHead); // create a new head, holding the required value. Its next pointer points to the old head
            oldHead.setPrevious(head); // set previous pointer of the old head to point to the new head
        }
    }
    
    /**
     * Remove the oldest value from the queue
     * @return the oldest value in the queue
     * @throw ListAccessError if the queue is empty
     */
    public T dequeue() throws ListAccessError {
        if (isEmpty()) {
            throw new ListAccessError("Dequeue from an empty queue");
        }
        T result = tail.getValue(); // get the last value in the queue
        tail = tail.getPrevious(); // move tail to previous node
        if (tail != null) {
            tail.setNext(null); // and ensure that pointer to "removed" node is set to null
        } else {
            head = null; // if tail is now null the queue is empty, so set head to null as well
        }
        return result;
    }
    
    public boolean isEmpty() {
        return (head == null);
    }
}
