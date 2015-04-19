package gameGUI;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameGUIApplication 
{
	public static void main(String[] args)
	{
		// create a JFrame
		JFrame gameFrame = new JFrame("Let's play 20 questions");

		// set size
		gameFrame.setSize(750,500);

		// set normal exiting upon closing the window
		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// create game panel for restricted version
		ResGameGUIControllerView gamePanel = new ResGameGUIControllerView();

		// add game panel to frame
		gameFrame.add(gamePanel);

		// set visible to true
		gameFrame.setVisible(true);

		// create another JFrame
		JFrame gameFrame1 = new JFrame("Let's play 20 questions");

		// set size
		gameFrame1.setSize(750,500);

		// set normal exiting upon closing the window
		gameFrame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// create game panel for unrestricted version
		UnresGameGUIControllerView gamePanel1 = new UnresGameGUIControllerView();

		// add game panel to frame
		gameFrame1.add(gamePanel1);

		// set visible to true
		gameFrame1.setVisible(true);
	}
}
