package binaryTree;

/**
 * DefaultBinSearchTree.java
 * CSC112 Assign 9
 * Audrey Lee
 **/
/**
 * DefaultBinSearchTree implements a basic binary search tree. The binary search
 * tree contains Comparable objects as data with the invariant that all data in
 * the left subtree of a node is less than the data at the node, and all data in
 * the right subtree is greater than or equal to the data at the node.
 * 
 * @author Audrey Lee
 **/
public class DefaultBinSearchTree<T extends Comparable<T>> extends
		DefaultBinTree<T> implements BinSearchTree<T>
{
	/**
	 * Constructor creates an empty binary search tree.
	 **/
	public DefaultBinSearchTree()
	{
		super();
	}

	/**
	 * Insert the data into the tree, maintaining the search tree invariant.
	 **/
	public void insert(T data)
	{
		// empty tree
		if (getRoot() == null)
			setRoot(new DefaultBinTreeNode<T>(data));
		else
			insert(data, getRoot());
	}

	/**
	 * Insert the data at the subtree rooted at node.
	 **/
	private void insert(T data, BinTreeNode<T> node)
	{
		int comparison = data.compareTo(node.getData());

		// <
		if (comparison < 0)
		{
			// BASE CASE: left tree is null
			if (node.getLeftChild() == null)
				node.setLeftChild(new DefaultBinTreeNode<T>(data));
			// recursive case
			else
				insert(data, node.getLeftChild());
		}
		// >=
		else
		{
			// BASE CASE: right tree is null
			if (node.getRightChild() == null)
				node.setRightChild(new DefaultBinTreeNode<T>(data));
			// recursive case
			else
				insert(data, node.getRightChild());
		}
	}

	/**
	 * Search for data in the tree, finding the node containing it, or null if
	 * the data is not present in the tree.
	 * 
	 * @return the node containing data or null if none exists.
	 **/
	public BinTreeNode<T> search(T data)
	{
		return search(data, getRoot());
	}

	/**
	 * Search for the data in the subtree rooted at node.
	 **/
	private BinTreeNode<T> search(T data, BinTreeNode<T> node)
	{
		// BASE CASE: null
		if (node == null)
			return null;

		int comparison = data.compareTo(node.getData());

		// BASE CASE: =
		if (comparison == 0)
			return node;
		// <
		if (comparison < 0)
			// recursive case
			return search(data, node.getLeftChild());
		// >
		else
			// recursive case
			return search(data, node.getRightChild());
	}

	/**
	 * Find the minimum element in the tree.
	 */
	public T minElement()
	{
		BinTreeNode<T> current = getRoot();
		
		while ( current.getLeftChild() != null )
		{
			current = current.getLeftChild();
		}
		
		return current.getData();
	}

	/**
	 * Find the maximum element in the tree.
	 */
	public T maxElement()
	{
		BinTreeNode<T> current = getRoot();
		
		while ( current.getRightChild() != null )
		{
			current = current.getRightChild();
		}
		
		return current.getData();
	}
}
