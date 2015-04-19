package binaryTree;
/**
 * BinTreeNode.java
 * CSC112 Assign 9
 * Audrey Lee
 **/
/**
 * BinTreeNode is the interface for a basic binary tree node,
 * with data and pointers to left and right children.
 * Actual implementation of a binary tree node is Assignment 9.
 * @author Audrey Lee
 **/
public interface BinTreeNode<T>
{

  /**
   * Get the data stored at this node.
   * @return Object data.
   **/
  public T getData();

  
  /**
   * Get the left child.
   * @return BinTreeNode that is left child,
   * or null if no child.
   **/
  public BinTreeNode<T> getLeftChild();

  /**
   * Get the right child.
   * @return BinTreeNode that is right child,
   * or null if no child.
   **/
  public BinTreeNode<T> getRightChild();

  /**
   * Set the left child.
   **/
  public void setLeftChild( BinTreeNode<T> left );

  /**
   * Set the right child.
   **/
  public void setRightChild( BinTreeNode<T> right );

  /**
   * Tests if this node is a leaf (has no children).
   * @return true if leaf node.
   **/
  public boolean isLeaf();

}
