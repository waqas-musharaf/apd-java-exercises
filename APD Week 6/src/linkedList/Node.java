package linkedList;

/**
 * Defines a basic linked list node
 * 
 * @author Hugh Osborne 
 * @version October 2016
 */
public class Node<T>
{
  private T value; // the value held in this node
  private Node<T> next;    // pointer to the next node

  /**
   *  Constructs a "tail" node --- a node with no following node
   * @param value the value to be contained in this node
   */
  public Node(T value) {
    this.value = value;
    next = null;
  }

  /**
   *  Constructs a "non-tail" node --- a node with following nodes
   * @param value the value to be contained in this node
   * @param next a pointer to the next node in the list
   */
  public Node(T value,Node<T> next) {
    this.value = value;
    this.next = next;
  }

  /**
   * @return the value held in this node
   */
  public T getValue() {
    return value;
  }

  /**
   * @return the next node --- and therefore the rest of the list after this node
   */
  public Node<T> getNext() {
    return next;
  }
  
  /**
   * Set the value of this node's next pointer
   * @param next the new value for the next pointer
   */
  public void setNext(Node<T> next) {
      this.next = next;
    }
}
