
public interface StackInterface<T> 
{
	/** Push an object into the stack 
	 * @param object
	 */
	public void push(T data);
	
	/** Pop (delete) an object from the top of the stack 
	 * 
	 */
	public void pop();
	
	/** Return the object at the very top of the stack 
	 * @return top object
	 */
	public T peek();
	
	/** Check to see if stack is empty
	 * @return true if empty
	 */
	public boolean isEmpty();
}
