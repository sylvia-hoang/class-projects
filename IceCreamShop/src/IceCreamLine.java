import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JPanel;


public class IceCreamLine extends JPanel implements ActionListener
{
	// a queue of orders
	private QueueLL<IceCreamCone> icQueue;
	// box to display ice cream cones
	private Box iceCreamBox;
	// 2 buttons
	private JButton addRandom;
	// private JButton serveRandom;

	public IceCreamLine()
	{
		icQueue = new QueueLL<IceCreamCone>();

		setLayout(new BorderLayout());

		// ice cream box
		add(createIceCreamBox(), BorderLayout.CENTER);
		// panel with two buttons
		add(createButtonPanel(), BorderLayout.NORTH);
		refreshDisplay();
	}

	public Box createIceCreamBox()
	{
		// create a box that lays out components vertically
		iceCreamBox = Box.createVerticalBox();

		return iceCreamBox;
	}

	public JPanel createButtonPanel()
	{
		JPanel buttonPanel = new JPanel( new GridLayout(1,1) );

		// initialize buttons
		addRandom = new JButton("Add a random order!");
		//serveRandom = new JButton("Serve the next order");

		// add buttons to panel
		//buttonPanel.add(serveRandom);
		buttonPanel.add(addRandom);

		// add action listeners
		addRandom.addActionListener(this);
		//serveRandom.addActionListener(this);

		return buttonPanel;
	}

	public void actionPerformed(ActionEvent e)
	{
		JButton buttonPressed = (JButton)e.getSource();
		// when add random order button is pressed
		// add a random ice cream cone to the queue
		IceCreamCone icCone = new IceCreamCone();
		// add random scoops to the cone
		icCone.addScoops();
		// enqueue the added cone
		icQueue.enqueue(icCone);
		// refresh display
		refreshDisplay();
	}


	public void refreshDisplay()
	{
		// if the queue is not empty --> display stuff in it:
		if (!icQueue.isEmpty())
		{
			LinkedListNode<IceCreamCone> currentNode = icQueue.getFirstNode();

			// temp stack to display ice cream cones
			StackLL<IceCreamCone> tempStack = new StackLL<IceCreamCone>();

			// traverse ice cream stack 
			for (int i = 0; i < icQueue.size(); i++)
			{
				// get element in the stack
				IceCreamCone cone = currentNode.getData();
				// push elements into temp stack
				tempStack.push(cone);
				// get the next node
				currentNode = currentNode.getNext();
			}

			// get temp stack's first node
			LinkedListNode<IceCreamCone> currentTempNode = tempStack.getFirstNode();
			// traverse the temp stack
			for (int i = 0; i < tempStack.size(); i++)
			{
				// get the ice cream cone in stack
				IceCreamCone crCone = currentTempNode.getData();
				// add to the box 
				iceCreamBox.add(crCone);
				// get next in queue
				currentTempNode = currentTempNode.getNext();
			}
		}
		
		// validate and repaint container
		iceCreamBox.validate();
		this.repaint();
	}

	public QueueLL<IceCreamCone> getQueue()
	{
		return icQueue;
	}

	/** Remove an order
	 * Called when serve order button is clicked
	 * Removes that order on the queue & also the GUI component
	 */
	public void removeOrder()
	{
		if (!icQueue.isEmpty())
		{
			// remove last component from the box
			iceCreamBox.remove(icQueue.getLast());
			// dequeue a cone from the queue
			icQueue.dequeue();
		}
		refreshDisplay();
	}

}
