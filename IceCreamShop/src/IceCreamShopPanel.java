import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class IceCreamShopPanel extends JPanel implements ActionListener
{
	// JLabels to display game intro
	private JLabel instructions;
	private JLabel earnPts;
	private JLabel losePts;
	// score display
	private JLabel scoreLabel;
	// score keeper
	private int score;

	// serve order button
	private JButton serveButton;

	// ice cream maker - user makes scoop
	private IceCreamMaker icMaker;
	
	// ice cream line - random cone gets added	
	private IceCreamLine icLine;

	public IceCreamShopPanel()
	{
		score = 0;
		icMaker = new IceCreamMaker();
		icLine = new IceCreamLine();

		setLayout(new BorderLayout());

		add(createLabelPanel(), BorderLayout.NORTH);
		add(icLine, BorderLayout.WEST);
		add(icMaker, BorderLayout.CENTER);
	}

	public JPanel createLabelPanel()
	{
		JPanel labelPanel = new JPanel(new GridLayout(5,1));
		// create a bunch of JLabels
		instructions = new JLabel("Make ice cream cones to match the next order (at the top).");
		earnPts = new JLabel( "Every correct order served earned you 10 points.");
		losePts = new JLabel("Make the wrong cone and you'll lose 5 points.");
		scoreLabel = new JLabel("Score: " + score);

		// create JButton and add action listener
		serveButton = new JButton("Serve this order");
		serveButton.addActionListener(this);

		labelPanel.add(instructions);
		labelPanel.add(earnPts);
		labelPanel.add(losePts);
		labelPanel.add(scoreLabel);
		labelPanel.add(serveButton);

		return labelPanel;
	}

	public void actionPerformed(ActionEvent e)
	{

		if ( (!icLine.getQueue().isEmpty()) && (!icMaker.getCone().getStack().isEmpty()) )
		{
			// if two flavor stacks are matched
			if (areStacksMatched())
			{
				// increase score by 10
				score += 10;
			} else
			{
				// if not match, decrease score by 5
				score -= 5;
			}
		}
		// update JLabel
		scoreLabel.setText("Score: " + score);

		// remove the order
		icLine.removeOrder();
	}

	/** Check to see whether the two cones are matched 
	 * @return true if matched
	 */
	public boolean areStacksMatched()
	{
		// check to see if the stack is being made matches the order
		IceCreamCone userCone = icMaker.getCone();
		// get the stack containing user-made flavors
		StackLL<String> userMadeStack = userCone.getStack();

		// get cone at the end of order queue, AKA the current order
		IceCreamCone currentOrder = icLine.getQueue().getLast();
		// get the stack (containing the order's flavors)
		StackLL<String> orderStack = currentOrder.getStack();

		// get first nodes in both stacks
		LinkedListNode<String> userFlavor = userMadeStack.getFirstNode();
		LinkedListNode<String> orderFlavor = orderStack.getFirstNode();

		// while both stacks are not empty
		while ((orderFlavor.getNext() != null) && (userFlavor.getNext() != null))
		{
			// get flavors from both stacks
			String flavor1 = userFlavor.getData();
			String flavor2 = orderFlavor.getData();

			// compare them: if they're not the same flavors
			if (!flavor1.equals(flavor2))
			{
				return false;
			}
			// other wise, get next nodes in both stacks to continue comparison
			else
			{
				userFlavor = userFlavor.getNext();
				orderFlavor = orderFlavor.getNext();
			}
		}
		return true;
	}
}
