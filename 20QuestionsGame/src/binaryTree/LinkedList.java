package binaryTree;
/**
 * LinkedList class to build up a smarter data structure than a simple array
 * 
 * @author jhughto
 *
 * @param <T>
 * 
 */
public class LinkedList<T> {
	
	// The single instance field which holds the head node
	private LinkedListNode<T> head;
	
	/**
	 * Get data stored in head node of list.
	 **/
	public T getFirst() {
		// return the data stored in the head node
		return head.getData();
	}
	 
	/**
	 * Get the head node of the list.
	 **/
	public LinkedListNode<T> getFirstNode() {
		// return the head node
		return head;
	}
	 
	/**
	 * Get data stored in tail node of list.
	 **/
	public T getLast() {
		// We need a temporary node to store the last node
		LinkedListNode<T> node = getLastNode();
		// Return the data from that node
		return node.getData();
	}
	 
	/**
	 * Get the tail node of the list.
	 **/
	public LinkedListNode<T> getLastNode() {
		// We need a temporary node to step through our list
		LinkedListNode<T> node = head;
		// If there aren't any data at all
		if(isEmpty()) {
			// Print out an error message.
			System.err.println("getLast was called and there aren't any nodes!");
		}
		// Otherwise
		else {
			// While node isn't the tail
			while(node.getNext() != null) {
				// Use the next node
				node=node.getNext();
			}
		}
		// Return the node where node.getNext() == null.  This is the tail.
		return node;
	}
	 
	/**
	 * Insert a new node with data at the head of the list.
	 **/
	public void insertFirst( T data ) {
		// We need to make a new node to insert it
		LinkedListNode<T> node = new LinkedListNode<T>();
		// Add data to the node
		node.setData(data);
		// Invoke insertFirstNode to link up the new node
		insertFirstNode(node);
	}
	 
	/**
	 * Insert the node at the head of the list.
	 **/
	public void insertFirstNode( LinkedListNode<T> node ) {
		// Have the new node point to the old head
		node.setNext(head);
		// Set the new node as the head.
		head=node;
	}
	 
	/**
	 * Insert a new node with data after currentNode
	 **/
	public void insertAfter( LinkedListNode<T> currentNode, T data ) {
		// We need to make a new node to insert it
		LinkedListNode<T> node = new LinkedListNode<T>();
		// Add data to the node
		node.setData(data);
		// Invoke insertNodeAfter to link up the new node
		insertNodeAfter(currentNode,node);
	}
	 
	/**
	 * Insert the node after currentNode
	 **/
	public void insertNodeAfter( LinkedListNode<T> currentNode, LinkedListNode<T> node ) {
		// Have the new node point to the node after currentNode
		node.setNext(currentNode.getNext());
		// Have currentNode now point to the new node
		currentNode.setNext(node);
	}
	 
	/**
	 * Insert a new node with data at the tail of the list.
	 **/
	public void insertLast( T data ) {
		// We need to make a new node to insert it
		LinkedListNode<T> newNode = new LinkedListNode<T>();
		// Add data to the node
		newNode.setData(data);
		// Invoke insertLastNode to link up the new node
		insertLastNode(newNode);
	}
	 
	/**
	 * Insert the node at the tail of the list.
	 **/
	public void insertLastNode( LinkedListNode<T> newNode ) {
		// We need a temporary node to step through our list
		LinkedListNode<T> currentNode = head;
		// If there aren't any data
		if(isEmpty()) {
			// Make the newNode the head
			head=newNode;
		}
		// Otherwise
		else {
			// While we are not at the tail
			while(currentNode.getNext()!=null) {
				// Get the next node
				currentNode=currentNode.getNext();
			}
			// When we reach the tail, set the next node to be the new node
			currentNode.setNext(newNode);
		}
	}
	 
	/**
	 * Remove head node
	 **/
	public void deleteFirst() {
		// Make the new head the node following the old head
		head=head.getNext();
	}
	 
	/**
	 * Remove tail node
	 **/
	public void deleteLast() {
		// We need a temporary node to step through our list
		LinkedListNode<T> node = head;
		// While the next node isn't the tail, hence node.getNext().getNext()
		while(node.getNext().getNext() != null) 
			// Get the next node
			node=node.getNext();
		// Set the next node to null, making the current node (one up from the tail) the new tail
		node.setNext(null);
			
	}
	 
	/**
	 * Remove node following currentNode
	 * If no node exists (i.e., currentNode is the tail), do nothing
	 **/
	public void deleteNext( LinkedListNode<T> currentNode ) {
		// Set the currentNode to point to the one after the next node.  This will drop the one in the middle from the list
		currentNode.setNext(currentNode.getNext().getNext());
	}
	 
	/**
	 * Compute the size of this list.
	 **/
	public int size() {
		// Start our counter at zero
		int length=0;
		// We need a temporary node to step through our list
		LinkedListNode<T> node = head;
		// While we aren't at the node after the tail (a null node)
		while(node != null) {	
			// Tick up our counter
			length++;
			// Get the next node
			node=node.getNext();
		}
		// Return the length of our list
		return length;
	}
	 
	/**
	 * Check if list is empty.
	 * @return true if list contains no items.
	 **/
	public boolean isEmpty() {
		// If there's no head
		if(head==null)
			// The list is empty
			return true;
		// Otherwise
		else
			// It's not
			return false;
	}
	 
	/**
	 * Return a String representation of the list.
	 **/
	public String toString() {
		// We need a temporary node to step through our list
		LinkedListNode<T> node=head;
		// Start off with an empty string
		String representation = "";
		// If there aren't any data
		if(isEmpty())
			// Tell the user that
			representation="Nothing to see here!";
		// Otherwise
		else {
			// While we aren't at the tail
			while(node.getNext()!=null) {
				// Add the node representation plus an arrow
				representation+=(node.toString()+" -> ");
				// Get the next node
				node=node.getNext();
			}
			// When we're at the tail, we don't want the arrow, so we just add the toString() output directly
			representation+=node.toString();
		}
		// Return our string representing the whole list
		return representation;
	}

	/**
	 * Return a String representation of the list.
	 **/
	public String minimalString() {
		// We need a temporary node to step through our list
		LinkedListNode<T> node=head;
		// Start off with an empty string
		String representation = "";
		// If there aren't any data
		if(isEmpty())
			// Tell the user that
			representation="";
		// Otherwise
		else {
			// While we aren't at the tail
			while(node.getNext()!=null) {
				// Add the node representation plus an arrow
				representation+=(node.toString()+" ");
				// Get the next node
				node=node.getNext();
			}
			// When we're at the tail, we don't want the arrow, so we just add the toString() output directly
			representation+=node.toString();
		}
		// Return our string representing the whole list
		return representation;
	}
}
