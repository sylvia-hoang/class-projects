
public class StackLL<T> implements StackInterface<T>
{
	// head and tail nodes
	private LinkedListNode<T> head;
	// size of the list
	private int size;

	public StackLL()
	{
		// initialize the head and tail nodes
		head = new LinkedListNode<T>();
		// new list is empty
		size = 0;
	}

	/**
	 * Return the number of nodes in this list.
	 **/
	public int size()
	{
		return size;
	}
	
	/**
	 * Get data stored in the top node of the stack
	 **/
	public T peek()
	{
		return head.getData();
	}

	/**
	 * Get the head node of the stack.
	 **/
	public LinkedListNode<T> getFirstNode()
	{
		return head;
	}
	
	/**
	 * Insert a new node with data at the head of the stack.
	 * @param data
	 **/
	public void push( T data )
	{
		// create new node
		LinkedListNode<T> newNode = new LinkedListNode<T>();

		// store param data in new node
		newNode.setData(data);

		// create new temp head node
		LinkedListNode<T> newTempHead = head;

		// point this node to current head
		newNode.setNext(newTempHead);

		// make head equal to this node
		head = newNode;

		// increase list size
		size ++;
	}

	/**
	 * Remove top object of the stack
	 **/
	public void pop()
	{
		// if the list is not empty
		if (!isEmpty())
		{
			// get node after head
			LinkedListNode<T> afterHead = head.getNext();

			// get node after the node after head 
			LinkedListNode<T> afterAfterHead = afterHead.getNext();

			// set head node equal to the afterHead node
			head = afterHead;

			// point head node to the next node
			head.setNext(afterAfterHead);

			// decrement list size
			size--;
		}
	}

	/**
	 * Check if list is empty.
	 * @return true if list contains no items.
	 **/
	public boolean isEmpty()
	{
		if (size <= 0)
		{
			return true;
		}
		else { return false; }
	}
}
