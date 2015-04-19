/**

 * BinSearchTree.java
 * CSC112 Assign 9
 * Audrey Lee
 **/
/**
 * BinSearchTree is the interface for a basic binary search tree.
 * The binary search tree contains Comparable objects as data with
 * the invariant that all data in the left subtree of a node is
 * less than the data at the node, and all data in the right subtree
 * is greater than or equal to the data at the node.
 * Actual implementation of a binary search tree is Assignment 9.
 * @author Audrey Lee
 **/

package binaryTree; 

public interface BinSearchTree<T extends Comparable<T>> extends BinTree<T>
{
  /**
   * Insert the data into the tree, maintaining the
   * search tree invariant.
   **/  
  public void insert( T data );

  /**
   * Search for data in the tree, finding the node
   * containing it, or null if the data is not present
   * in the tree.
   * @return the node containing data or null if none exists.
   **/
  public BinTreeNode<T> search( T data );
  
  /**
   * Find the minimum element in the tree.
   */
  public T minElement();

  /**
   * Find the maximum element in the tree.
   */
  public T maxElement();
}
