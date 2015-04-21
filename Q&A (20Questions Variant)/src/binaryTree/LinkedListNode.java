package binaryTree;
/**
 * LinkedListNode is used together with LinkedList to help build up a linked list
 * 
 * @author jhughto
 *
 * @param <T>
 */
public class LinkedListNode<T> {
	
	// The data stored in the node
	private T data;
	// The pointer to the next node in the list
	private LinkedListNode<T> next;
	
	/**
	 * Get the data stored at this node.
	 **/
	public T getData() {
		// Give the data to another class
		return data;
	}
	 
	/**
	 * Set the data stored at this node.
	 **/
	public void setData( T data ) {
		// Set the data in this node
		this.data = data;
	}
	 
	/**
	 * Get (pointer to) next node.
	 **/
	public LinkedListNode<T> getNext() {
		// return the next node after this one
		return next;
	}
	 
	/**
	 * Set the next pointer to passed node.
	 **/
	public void setNext( LinkedListNode<T> node ) {
		// Set the next node
		next = node;
	}
	 
	/**
	 * Returns a String representation of this node.
	 **/
	public String toString() {
		// Return a string representation of the data in the node
		return data.toString();
	}
}
