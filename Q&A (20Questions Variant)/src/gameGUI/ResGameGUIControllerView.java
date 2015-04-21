package gameGUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class ResGameGUIControllerView extends JPanel implements ActionListener
{
	private JButton yesButton;
	private JButton noButton;
	private JButton restart;

	private JLabel instructions;

	private JTextArea textDisplay;

	private QAGameModel game;

	/** CONSTRUCTOR **/
	public ResGameGUIControllerView()
	{
		// initialize game
		game = new QAGameModel();

		// set layout
		setLayout(new BorderLayout());

		// game instructions
		add(instructionsLabel(), BorderLayout.NORTH);

		// text area
		add(createTextArea(), BorderLayout.CENTER);

		// two buttons
		add(createButtonPanel(), BorderLayout.SOUTH);		
	}

	/** Create text display area **/
	private JPanel createTextArea()
	{
		JPanel textArea = new JPanel();
		// text area
		textDisplay = new JTextArea();

		// set text
		textDisplay.setText(game.getCurrentNode().getData());

		// set font and font size
		textDisplay.setFont(new Font("Georgia", Font.BOLD, 20));

		// Don't let user change what's displayed
		textDisplay.setEditable(false);

		// add to text panel
		textArea.add(textDisplay);

		// Set background color for text box and panel
		textDisplay.setBackground(new Color(142,201,119));
		textArea.setBackground(new Color(142,201,119));

		return textArea;
	}

	/** Create label showing instructions to play the game (north of game board 
	 * @return panel
	 */
	private JLabel instructionsLabel()
	{
		// create instructions label
		instructions = new JLabel("<html> <p>Think of a mobile app among: Facebook, Twitter, Instagram, Snapchat,</p>"
				+ "<p>Flappy Bird, Angry Birds, Temple Run, Skype, WhatsApp, Maps, Calculator</p>"
				+ "<p>LinkedIn, YouTube, Vine, Yik Yak.</p>"
				+ "<p>Then answer yes/no questions to see if I guess it correctly! :)</p></html>");

		// set opaque and background color
		instructions.setOpaque(true);

		// set label's background color
		instructions.setBackground(Color.PINK);

		// set font for the label
		Font labelFont = new Font("Georgia", Font.ITALIC, 20);
		instructions.setFont(labelFont);

		return instructions;
	}

	/** Create panel of buttons (south of game board)
	 * @return button panel
	 */
	private JPanel createButtonPanel()
	{
		JPanel buttonPanel = new JPanel(new GridLayout(1,3));

		// create and add thumbs-up icon to yes button
		ImageIcon thumbsUp = new ImageIcon("thumbs-up.gif");
		yesButton = new JButton("Yes", thumbsUp);

		// create and add thumbs-down icon to no button
		ImageIcon thumbsDown = new ImageIcon("thumbs_down.png");
		noButton = new JButton("No", thumbsDown);

		// Restart button
		restart = new JButton("Restart Game", new ImageIcon("restart.png"));

		// add action listeners
		yesButton.addActionListener(this);
		noButton.addActionListener(this);
		restart.addActionListener(this);

		// add buttons to panel
		buttonPanel.add(yesButton);
		buttonPanel.add(noButton);
		buttonPanel.add(restart);

		buttonPanel.setBackground(new Color(227, 222, 66));

		return buttonPanel;
	}
	
	/** ACTION PERFORMED **/
	public void actionPerformed(ActionEvent e)
	{	
		// get the button pressed
		JButton buttonPressed = (JButton)e.getSource();

		// if yes button is pressed
		if (buttonPressed.equals(yesButton))
		{
			// update game
			game.chooseYes();
		}
		else if (buttonPressed.equals(noButton))
		{
			// update game
			game.chooseNo();
		}
		// else, if Restart button is pressed
		else 
		{	
			// restart game
			game.restart();
		}
		// display the questions
		displayText();
	}

	/** Display questions in the JTextArea when the game is still going
	 * 
	 */
	private void displayText()
	{
		// display the current question/answer
		textDisplay.setText(game.getCurrentNode().getData());

		// In case we reach a leaf
		if (game.getCurrentNode().isLeaf())
		{
			// displays computer's ending question
			textDisplay.append("\nAm I correct? Yay me if I am! Press Restart Game to start another round.");
		}
	}
}
