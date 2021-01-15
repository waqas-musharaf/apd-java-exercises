package linkedList;

/**
 * Interface for SinglyLinkedList, implementing the List<T> interface
 * This list can store an infinite (unknown) number of items. Each item in the list is identified by its index
 * 
 * @author Waqas Musharaf
 * @version November 2016
 */

public class SinglyLinkedList<T> implements List<T> {
private Node<T> first;

	/**
 	* Checks to see if the list is empty
 	*/
	public boolean isEmpty() {
		return this.first == null;
	}
	
	/**
    * Adds a new value to the list at position index
    * @throws ListAccessError if index is an invalid index
    */
	public void add(int index, T val) throws ListAccessError {
		if(index < 0) {
			throw new IllegalArgumentException("Index cannot be less than zero.");
		}
		
		if(index == 0){  
			Node<T> newNode = new Node<T>(val, this.first);
			this.first = newNode;	
		} else {
			Node<T> lastNode, thisNode;
			lastNode = this.getNodeAtIndex(index - 1);
			try {
				thisNode = lastNode.getNext();
			} catch(NullPointerException e) {
				throw new ListAccessError("Cannot add node at index " + index + " as node at previous index does not exist.");
			}
			
			Node<T> newNode = new Node<T>(val, thisNode);
			lastNode.setNext(newNode);
		}
	} 
	
	/**
    * Removes a value from the list
    * @return the value removed
    * @throws ListAccessError if index is an invalid index
    */
	public T remove(int index) throws ListAccessError {
		if(index < 0) {
			throw new IllegalArgumentException("Index cannot be less than zero.");
		}
		
		if(index == 0) {
			T temp;
			try {
				temp = this.first.getValue();
			} catch(NullPointerException e) {
				throw new ListAccessError("Cannot remove index " + index + " as index is non-existent.");
			}
			this.first = this.first.getNext();
			return temp;
		} else {
			Node<T> lastNode, thisNode;
			try {
				lastNode = this.getNodeAtIndex(index - 1);
				thisNode = lastNode.getNext();
			} catch(ListAccessError | NullPointerException e) {
				throw new ListAccessError("Cannot remove node at index " + index + " as index is non-existent.");
			}
			
			Node<T> nextNode = thisNode != null ? thisNode.getNext() : null;
			lastNode.setNext(nextNode);
			return thisNode.getValue();
		}
	}
	
	/**
    * Gets a value from the list (does not remove it)
    * @return the value indexed
    * @throws ListAccessError if index is an invalid index
    */
	public T get(int index) throws ListAccessError {	
		if(index < 0) {
			throw new IllegalArgumentException("Index cannot be less than zero.");
		} else {
			return this.getNodeAtIndex(index).getValue();
		}
	}

	/**
	* Gets node value from a specified index
	* @param index int:	Specified index
	* @return Node<T>:	Node at specified index
	* @throws ListAccessError: Thrown if there is no node at the specified index
	*/
	private Node<T> getNodeAtIndex(int index) throws ListAccessError {
		if(index < 0) {
			throw new  IllegalArgumentException("Index cannot be less than zero.");
		}
		
		if(index == 0) {
			if(this.first == null) {
				throw new ListAccessError("Invalid index, there is no node at index zero."); 
			} else {
				return this.first;
			}
		}
		
		Node<T> tempNode = this.first;
		for(int i = 1; i <= index; i++) {
			try {
				tempNode = tempNode.getNext();
			} catch(NullPointerException e) {
				throw new ListAccessError("Invalid index, there is no node at index " + i + ".");
			}
		}
		
		if(tempNode == null) {
			throw new ListAccessError("Invalid index, there is no node at index " + index + ".");
		} else {
			return tempNode;
		}
	}
}