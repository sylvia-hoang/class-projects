import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JComponent;


public class IceCreamCone extends JComponent
{
	/****** Instance Variables *******/
	// a stack to keep track of ice cream flavors
	private StackLL<String> iceCreamStack;

	// array of flavors
	public static final String[] FLAVORS = {"Vanilla","Green tea","Peach","Mint"};

	// width and height of the component
	private int width;
	private int height;

	public IceCreamCone()
	{
		iceCreamStack = new StackLL<String>();
	}

	public void paint(Graphics g)
	{
		// paint a triangle cone first
		paintCone(g);

		// paint current scoops
		paintScoops(g);
	}

	/** Paint an ice cream cone
	 * @param g
	 */
	private void paintCone(Graphics g)
	{	
		width = getWidth();
		height = getHeight();

		// x coords for three vertices of the triangle
		int x1 = width/2;
		int x2 = x1 - 15;
		int x3 = x1 + 15;

		// y coords for two top vertices of the triangle
		int y2 = height - 60;

		// create arrays of x and y coords
		int[] xpoints = {x1, x2, x3};
		int[] ypoints = {height, y2, y2};

		// set color
		g.setColor(Color.ORANGE);
		// draw and fill triangle cone
		g.fillPolygon(xpoints, ypoints, 3);
		g.drawPolygon(xpoints, ypoints, 3);
	}

	private void paintScoops(Graphics g)
	{	
		// get the first node
		LinkedListNode<String> currentNode = iceCreamStack.getFirstNode();

		// y coord of first scoop
		int ycoord = height-70;

		// temp stack for displaying ice cream scoops
		StackLL<String> tempStack = new StackLL<String>();

		// traverse ice cream stack  
		for (int i = 0; i < iceCreamStack.size(); i++)
		{
			String flavor = currentNode.getData();
			// push elements into temp stack
			tempStack.push(flavor);
			// get the next node in the stack
			currentNode = currentNode.getNext();
		}

		LinkedListNode<String> currentTempNode = tempStack.getFirstNode();

		//traverse the temp stack till last element
		for (int j = 0; j < tempStack.size(); j++)
		{	
			// get the string from current node
			String currentFlavor = currentTempNode.getData();

			if (currentFlavor.equals("Vanilla"))
			{
				g.setColor(new Color(255, 255, 102));
			}
			else if (currentFlavor.equals("Green tea"))
			{
				g.setColor(new Color(67, 245, 162));
			}
			else if (currentFlavor.equals("Peach"))
			{
				g.setColor(Color.PINK);
			}
			else
			{
				g.setColor(new Color(100, 250, 225));
			}

			// draw the scoop
			g.fillOval(width/2-20, ycoord, 40, 40);

			// update the scoop's coordinate
			ycoord = ycoord-30;

			// move on to next node
			currentTempNode = currentTempNode.getNext();
		}
	}

	/** Takes in a string argument as the flavor
	 * Adds a scoop to the top of the cone
	 * @param flavor
	 */
	public void addScoop(String flavor)
	{
		iceCreamStack.push(flavor);
	}

	/** Takes no argument and adds a random flavor to top of the cone
	 */
	public void addScoop()
	{
		Random random = new Random();
		// choose a random flavor among 4
		String randomFlavor = FLAVORS[ random.nextInt(FLAVORS.length) ];
		// push flavor onto stack
		iceCreamStack.push(randomFlavor);
	}

	/** Remove top scoop **/
	public void removeScoop()
	{
		iceCreamStack.pop();
	}
	
	/** Add several scoops to the cone
	 *  Number of scoops range from 1 to 4 **/
	public void addScoops()
	{
		// generate random scoop number between 1 and 4, making sure 0 is not allowed
		int randomScoopNum = (int) (Math.random() * 4) + 1;
				
		// add a scoop 
		for (int i=0; i < randomScoopNum; i++)
		{
			addScoop();
		}
	}
	
	public StackLL<String> getStack()
	{
		return iceCreamStack;
	}
}
