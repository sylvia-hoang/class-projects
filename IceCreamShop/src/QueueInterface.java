
public interface QueueInterface<T> 
{
	/** Add an object to top of the queue **/
	public void enqueue(T data);
	
	/** Remove an object at end of the queue **/
	public void dequeue();
	
	/** Get the object at the front **/
	public T getFront();
	
	/**
	 * Check if list is empty.
	 * @return true if list contains no items.
	 **/
	public boolean isEmpty();
}
