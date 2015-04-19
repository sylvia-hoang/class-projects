package gameGUI;
import binaryTree.*;

public class QAGameModel 
{
	/**** Instance Methods ****/
	private BinTree<String> gameBinTree;
	private BinTreeNode<String> currentNode;
	private BinTreeNode<String> previousNode;

	/**** Constructor ****/
	public QAGameModel()
	{
		// read in xml file and parse it as a binary tree
		// yes answers are left children, while no are right
		gameBinTree = CommutativeExpressionReader.readCommutativeExpr("QuestionAnswer.xml");

		// set current node and previous node to be the root
		currentNode = gameBinTree.getRoot();
		previousNode = gameBinTree.getRoot();
	}

	/** Update current node and previous node as yes is chosen
	 * 
	 */
	public void chooseYes()
	{
		if (!currentNode.isLeaf())
		{
			// store current node in a temporary node
			BinTreeNode<String> tempCurrNode = currentNode;

			// get the left node
			currentNode = currentNode.getLeftChild();

			// set previous node
			previousNode = tempCurrNode;
		}
	}

	/** Update current node and previous node as no is chosen
	 * 
	 */
	public void chooseNo()
	{
		if (!currentNode.isLeaf())
		{
			// store current node in a temporary node
			BinTreeNode<String> tempCurrNode = currentNode;

			// get the right node
			currentNode = currentNode.getRightChild();

			// set previous node
			previousNode = tempCurrNode;
		}
	}

	/** Given user's answer and question input, update binary tree that maintains game
	 * @param answer
	 * @param question
	 */
	public void updateGameTree(String answer, String question)
	{
		BinTreeNode<String> questionNode = new DefaultBinTreeNode<String>(question);
		BinTreeNode<String> answerNode = new DefaultBinTreeNode<String>(answer);

		// if previous node's left child is the current node
		if (previousNode.getLeftChild().equals(currentNode))
		{
			// get current node's data
			String computerAnswer = currentNode.getData();

			// set question to be the data of currentNode
			previousNode.setLeftChild(questionNode);

			// set old answer to the left
			questionNode.setLeftChild(new DefaultBinTreeNode<String>(computerAnswer));

			// set new answer to the right
			questionNode.setRightChild(answerNode);
		}
		// otherwise, if previous node's right child is the current node
		else
		{
			// get current node's data
			String computerAnswer = currentNode.getData();

			// set question to be the data of currentNode
			previousNode.setRightChild(questionNode);

			// set old answer to the right
			questionNode.setRightChild(new DefaultBinTreeNode<String>(computerAnswer));

			// set new answer to the left		
			questionNode.setLeftChild(answerNode);				
		}
		
		// BONUS: Save modified tree to the XML file for further plays
		CommutativeExpressionWriter.writeCommutativeExpr(gameBinTree, "QuestionAnswers.xml");
	}


	public BinTreeNode<String> getCurrentNode()
	{
		return currentNode;
	}

	/** Restart game **/
	public void restart()
	{
		currentNode = gameBinTree.getRoot();
	}
}
