package linkedList;
/**
 * Implementation of a basic LIFO data structure
 * 
 * @author Hugh Osborne
 * @version October 2016
 */
public class SingleLinkStack<T> implements Stack<T>
{
  private Node<T> top; // pointer to the top of the stack

  /**
   * Construct an empty stack
   */
  public SingleLinkStack() {
    top = null;
  }

  /**
   * Test whether the stack is empty
   * @return true iff the stack is empty
   */
  public boolean isEmpty() {
    return (top == null);
  }

  /**
   * Push a new element to the stack
   * <tt>top</tt> should point to the new element
   * The pointer from the new top node should point to the old top node
   */
  public void push(T value) {
    top = new Node<T>(value,top);
  }

  /**
   * Pop a value from the stack
   * @return the top value on the stack
   * @throws {\tt ListAccessError} if the stack is empty (there is nothing to pop)
   */
  public T pop() throws ListAccessError {
    if (isEmpty()) throw new ListAccessError("Pop from an empty stack");
    T value = top.getValue(); // get the top value
    top = top.getNext(); // update {\tt top} to point to next node
    return value; // return the original top value
  }
}
