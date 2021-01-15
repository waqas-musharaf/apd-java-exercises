package linkedList;

/**
 * Implements nodes for doubly linked lists
 * 
 * @author Hugh Osborne 
 * @version October 2016
 */
public class DoubleLinkNode<T> extends Node<T>
{
    private DoubleLinkNode<T> previous; // pointer to previous node in list
    
    /**
     * Construct a "singleton" node - one with no predecessors or successors
     * @param value the value to be stored in this node
     */
    public DoubleLinkNode(T value) {
        super(value);
        previous = null;
    }
    
    /**
     * Construct a "head" node - one with successors but no predecessors
     * @param value the value to be stored in this node
     * @param next a pointer to the first following node
     */
    public DoubleLinkNode(T value,DoubleLinkNode<T> next) {
        super(value,next);
        previous = null;
    }
    
    /**
     * Construct a "tail" node - one with predecessors but no successors
     * @param value the value to be stored in this node
     * @param previous a pointer to the first preceding node
     */
    public DoubleLinkNode(DoubleLinkNode<T> previous,T value) {
        super(value);
        this.previous = previous;
    }
    
    /**
     * Construct an "internal" node - one with both predecessors and successors
     * @param value the value to be stored in this node
     * @param next a pointer to the first preceding node
     * @param previous a pointer to the first preceding node
     */
    public DoubleLinkNode(DoubleLinkNode<T> previous,T value,DoubleLinkNode<T> next) {
        super(value,next);
        this.previous = previous;
    }
    
    /**
     * @return the previous node --- and therefore the rest of the list before this node
     */
    public DoubleLinkNode<T> getPrevious() {
        return previous;
    }
    
    /**
     * Set the value of this node's previous pointer
     * @param previous the new value for the previous pointer
     */
    public void setPrevious(DoubleLinkNode<T> previous) {
        this.previous = previous;
    }
}
