// LinkedListNode.java
// Audrey St. John

/** 
 * LinkedListNode class represents a single node in a linked list.
 * @author Audrey St. John
 **/
public class LinkedListNode<T>
{
	private T data; // the data held in this node
	private LinkedListNode<T> next; // the next node in the list
	
	/** 
	 * Constructor creates a new node with the given data.
	 **/
	public LinkedListNode( T data )
	{
		this.data = data;
		next = null;
	}
	
	/** 
	 * Constructor creates a new node with null data.
	 **/
	public LinkedListNode()
	{
		data = null;
		next = null;
	}

	/**
	 * Get the data stored at this node.
	 **/
	public T getData()
	{
		return data;
	}

	/**
	 * Set the data stored at this node.
	 **/
	public void setData( T data )
	{ 
		this.data = data;
	}

	/**
	 * Get (pointer to) next node.
	 **/
	public LinkedListNode<T> getNext()
	{
		return next;
	}

	/**
	 * Set the next pointer to passed node.
	 **/
	public void setNext( LinkedListNode<T> node )
	{
		next = node;
	}
	
	/**
	 * Returns a String representation of this node.
	 **/
	public String toString() 
	{
		if ( data == null )
			return "null";
		else	
			return data.toString();
	}
}