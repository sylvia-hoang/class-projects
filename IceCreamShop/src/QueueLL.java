
public class QueueLL<T> implements QueueInterface<T>
{
	// head 
	private LinkedListNode<T> head;
	private LinkedListNode<T> tail;

	/**
	 * Constructor creates an empty linked list.
	 **/
	public QueueLL() 
	{
		head = null;
		tail = null;
	}
	
	/**
	 * Get data stored in head node of list.
	 **/
	public T getFront()
	{
		if ( getFirstNode() == null )
			return null;
		else
			return getFirstNode().getData();
	}

	/**
	 * Get the head node of the list.
	 **/
	public LinkedListNode<T> getFirstNode()
	{
		return head;
	}

	/**
	 * Get data stored in tail node of list.
	 **/
	public T getLast()
	{
		if ( getLastNode() == null )
			return null;
		else
			return getLastNode().getData();
	}

	/**
	 * Get the tail node of the list.
	 **/
	public LinkedListNode<T> getLastNode()
	{
		return tail;
	}

	/**
	 * Insert a new node with data at the tail of the list.
	 **/
	public void enqueue( T data )
	{
		insertLastNode( new LinkedListNode<T>( data ) );
	}

	/**
	 * Insert the node at the tail of the list.
	 **/
	public void insertLastNode( LinkedListNode<T> node )
	{
		// if the list is empty
		if ( isEmpty() )
		{
			// this is both the head and tail
			head = node;
			tail = node;
		}
		else
		{
			// first make the current tail point at this one
			tail.setNext( node );
		
			// now, make this the tail
			tail = node;
		}
	}


	/**
	 * Remove tail node
	 **/
	public void dequeue()
	{
		// if the list only has one element
		if ( head == tail )
		{
			// delete it by setting both to null
			head = null;
			tail = null;
		}
		// now, if the list is not empty
		else if ( !isEmpty() )
		{
			// find the second to last node (the new tail)
			LinkedListNode<T> currentNode = head;
			
			// until we find the node whose next is the tail
			while ( currentNode.getNext() != tail )
			{
				// go to next node
				currentNode = currentNode.getNext();
			}
			
			// currentNode should be second to last
			// delete the node after
			deleteNext( currentNode );
		}
	}

	/**
	 * Remove node following currentNode
	 * If no node exists (i.e., currentNode is the tail), do nothing
	 **/
	public void deleteNext( LinkedListNode<T> currentNode )
	{
		// if this is not the tail
		if ( currentNode != tail )
		{	
			// if next node is the tail, this one becomes the new tail
			if ( currentNode.getNext() == tail )
				tail = currentNode;
		
			// remove the next node by setting this node's next to be 
			// the next node's next
			currentNode.setNext( currentNode.getNext().getNext() );
		}
	}

	/**
	 * Compute the size of this list.
	 **/
	public int size()
	{
		// iterate over the list
		LinkedListNode<T> currentNode = head;
		
		int size = 0;
		
		while ( currentNode != null )
		{
			// count this node
			size++;
			
			// go to next node
			currentNode = currentNode.getNext();
		}
		
		return size;
	}

	/**
	 * Check if list is empty.
	 * @return true if list contains no items.
	 **/
	public boolean isEmpty()
	{
		// the list is empty if the head is null
		return head == null;
	}
}

