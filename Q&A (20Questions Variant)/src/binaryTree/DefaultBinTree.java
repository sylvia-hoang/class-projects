package binaryTree;

/**
 * DefaultBinTree.java
 * Audrey St. John
 **/
/**
 * DefaultBinTree implements a basic binary tree.
 * 
 * @author Audrey Lee
 **/
public class DefaultBinTree<T> implements BinTree<T>
{

	private BinTreeNode<T> root;

	/**
	 * Constructor creates an empty binary tree.
	 **/
	public DefaultBinTree()
	{
		root = null;
	}

	/**
	 * Get the root node for this tree.
	 * 
	 * @return root or null if tree is empty.
	 **/
	public BinTreeNode<T> getRoot()
	{
		return root;
	}

	/**
	 * Set the root node for this tree.
	 **/
	public void setRoot(BinTreeNode<T> root)
	{
		this.root = root;
	}

	/**
	 * Test if the tree is empty.
	 * 
	 * @return true if tree has no data.
	 **/
	public boolean empty()
	{
		return root == null;
	}

	/**
	 * Get the data of this tree using inorder traversal.
	 * 
	 * @return inorder String.
	 **/
	public LinkedList<T> inorderTraversal()
	{
		LinkedList<T> traversal = new LinkedList<T>(); 
		inorderTraversal(root, traversal );
		return traversal;
	}

	/**
	 * Recursive function for getting the inorder traversal starting at this
	 * node.
	 * 
	 * @return String for inorder traversal.
	 **/
	private void inorderTraversal(BinTreeNode<T> node, LinkedList<T> traversal)
	{
		// Base case: null
		if (node == null)
			return;
		// Base case: leaf
		else if (node.isLeaf())
			traversal.insertLast( node.getData() );
		// recursive case
		else
		{
			inorderTraversal(node.getLeftChild(), traversal );
			traversal.insertLast( node.getData() );
			inorderTraversal(node.getRightChild(), traversal );
		}
	}

	/**
	 * Get the data of this tree using preorder traversal.
	 * 
	 * @return preorder String.
	 **/
	public LinkedList<T> preorderTraversal()
	{
		LinkedList<T> traversal = new LinkedList<T>(); 
		preorderTraversal(root, traversal );
		return traversal;
	}

	/**
	 * Recursive function for getting the preorder traversal starting at this
	 * node.
	 * 
	 * @return String for inorder traversal.
	 **/
	private void preorderTraversal(BinTreeNode<T> node, LinkedList<T> traversal)
	{
		// Base case: null
		if (node == null)
			return;
		// Base case: leaf
		else if (node.isLeaf())
			traversal.insertLast( node.getData() );
		// recursive case
		else
		{
			traversal.insertLast( node.getData() );
			preorderTraversal(node.getLeftChild(), traversal );
			preorderTraversal(node.getRightChild(), traversal );
		}
	}

	/**
	 * Get the data of this tree using postorder traversal.
	 * 
	 * @return postorder String.
	 **/
	public LinkedList<T> postorderTraversal()
	{
		LinkedList<T> traversal = new LinkedList<T>(); 
		postorderTraversal(root, traversal );
		return traversal;
	}

	/**
	 * Recursive function for getting the postorder traversal starting at this
	 * node.
	 **/
	private void postorderTraversal(BinTreeNode<T> node, LinkedList<T> traversal)
	{
		// Base case: null
		if (node == null)
			return;
		// Base case: leaf
		else if (node.isLeaf())
			traversal.insertLast( node.getData() );
		// recursive case
		else
		{
			postorderTraversal(node.getLeftChild(), traversal );
			postorderTraversal(node.getRightChild(), traversal );
			traversal.insertLast( node.getData() );
		}
	}

	/**
	 * Print the tree using inorder traversal.
	 **/
	public String inorderString()
	{
		return inorderTraversal().minimalString();
	}

	/**
	 * Print the tree using preorder traversal.
	 **/
	public String preorderString()
	{
		return preorderTraversal().minimalString();
	}

	/**
	 * Print the tree using postorder traversal.
	 **/
	public String postorderString()
	{
		return postorderTraversal().minimalString();
	}

}
