package binaryTree;
/**
 * DefaultBinTreeNode.java
 * CSC112 Assign 9
 * Audrey Lee
 **/
/**
 * DefaultBinTreeNode implements a basic binary tree node,
 * with data and pointers to left and right children.
 * @author Audrey Lee
 **/
public class DefaultBinTreeNode<T> implements BinTreeNode<T>
{
  private T data;
  private BinTreeNode<T> leftChild, rightChild;

  /**
   * Constructor creates a node with data.
   **/  
  public DefaultBinTreeNode( T data )
  {
    this.data = data;
  }

  /**
   * Get the data stored at this node.
   * @return Object data.
   **/
  public T getData()
  {
    return data;
  }


  /**
   * Get the left child.
   * @return BinTreeNode that is left child,
   * or null if no child.
   **/
  public BinTreeNode<T> getLeftChild()
  {
    return leftChild;
  }

  /**
   * Get the right child.
   * @return BinTreeNode that is right child,
   * or null if no child.
   **/
  public BinTreeNode<T> getRightChild()
  {
    return rightChild;
  }

  /**
   * Set the left child.
   **/
  public void setLeftChild( BinTreeNode<T> left )
  {
    leftChild = left;
  }

  /**
   * Set the right child.
   **/
  public void setRightChild( BinTreeNode<T> right )
  {
    rightChild = right;
  }

  /**
   * Tests if this node is a leaf (has no children).
   * @return true if leaf node.
   **/
  public boolean isLeaf()
  {
    return (leftChild == null) && (rightChild == null );
  }
}
