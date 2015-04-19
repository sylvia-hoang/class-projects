package binaryTree;

/**
 * BinTree.java
 * CSC112 Assign 9
 * Audrey Lee
 **/
/**
 * BinTree is the interface for a basic binary tree. Actual implementation of a
 * binary tree is Assignment 9.
 * 
 * @author Audrey Lee
 **/
public interface BinTree<T>
{

	/**
	 * Get the root node for this tree.
	 * 
	 * @return root or null if tree is empty.
	 **/
	public BinTreeNode<T> getRoot();

	/**
	 * Set the root node for this tree.
	 **/
	public void setRoot(BinTreeNode<T> root);

	/**
	 * Test if the tree is empty.
	 * 
	 * @return true if tree has no data.
	 **/
	public boolean empty();

	/**
	 * Get the data of this tree using inorder traversal.
	 * 
	 * @return inorder String.
	 **/
	public LinkedList<T> inorderTraversal();

	/**
	 * Get the data of this tree using preorder traversal.
	 * 
	 * @return preorder String.
	 **/
	public LinkedList<T> preorderTraversal();

	/**
	 * Get the data of this tree using postorder traversal.
	 * 
	 * @return postorder String.
	 **/
	public LinkedList<T> postorderTraversal();

	/**
	 * Print the tree using inorder traversal.
	 * 
	 * @return TODO
	 **/
	public String inorderString();

	/**
	 * Print the tree using preorder traversal.
	 * 
	 * @return TODO
	 **/
	public String preorderString();

	/**
	 * Print the tree using postorder traversal.
	 * @return TODO
	 **/
	public String postorderString();
}
