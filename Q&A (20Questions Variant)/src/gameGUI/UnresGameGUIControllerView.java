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
import javax.swing.JTextField;

public class UnresGameGUIControllerView extends JPanel implements ActionListener
{
	private JButton yesButton;
	private JButton noButton;
	private JButton restart;
	private JButton refresh;

	private JLabel instructions;
	private JLabel typeAnswer;
	private JLabel typeQuestion;

	private JTextArea textDisplay;

	private JTextField answerField;
	private JTextField questionField;

	private QAGameModel game;
	private String userA;
	private String userQ;

	/** CONSTRUCTOR **/
	public UnresGameGUIControllerView()
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
		add(createBtnAndTxtFieldPanel(), BorderLayout.SOUTH);		
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

		// Set background color for textbox and panel
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
		instructions = new JLabel("<html> <p>Think of a currently popular mobile app, both installed and built-in.</p> "
				+ "<p>Then answer yes/no questions to see if I guess it correctly! </p></html>");

		// set opaque and background color
		instructions.setOpaque(true);

		// set label's background color
		instructions.setBackground(Color.PINK);

		// set font for the label
		Font labelFont = new Font("Georgia", Font.ITALIC, 20);
		instructions.setFont(labelFont);

		return instructions;
	}

	/** Create panel of buttons and text fields 
	 * @return panel
	 */
	private JPanel createBtnAndTxtFieldPanel()
	{
		JPanel mainPanel = new JPanel(new BorderLayout());

		JPanel txtFieldPanel = new JPanel(new GridLayout(2,2));

		// initialize text field
		answerField = new JTextField();

		// create a JLabel that tells user to type in the answer field
		typeAnswer = new JLabel("Tell us which app you just thought of: ");

		// Question field
		questionField = new JTextField();

		// JLabel to prompt user to type in question
		typeQuestion = new JLabel("Tell us the question that distinguishes your answer:");

		// add all to the panel
		txtFieldPanel.add(typeAnswer);
		txtFieldPanel.add(answerField);
		txtFieldPanel.add(typeQuestion);
		txtFieldPanel.add(questionField);

		txtFieldPanel.setBackground(new Color(227, 222, 66));

		// add button panel to main panel
		mainPanel.add(createButtonPanel(), BorderLayout.SOUTH);

		// add panel of text fields to main panel
		mainPanel.add(txtFieldPanel, BorderLayout.CENTER);

		return mainPanel;
	}

	/** Create panel of buttons (south of game board)
	 * @return button panel
	 */
	private JPanel createButtonPanel()
	{
		JPanel buttonPanel = new JPanel(new GridLayout(1,4));

		// create and add thumbs-up icon to yes button
		ImageIcon thumbsUp = new ImageIcon("thumbs-up.gif");
		yesButton = new JButton("Yes", thumbsUp);

		// create and add thumbs-down icon to no button
		ImageIcon thumbsDown = new ImageIcon("thumbs_down.png");
		noButton = new JButton("No", thumbsDown);

		// Restart button
		restart = new JButton("Restart Game", new ImageIcon("restart.png"));

		// Refresh button
		refresh = new JButton("Update Game", new ImageIcon("reboot.png"));

		// add action listeners
		yesButton.addActionListener(this);
		noButton.addActionListener(this);
		restart.addActionListener(this);
		refresh.addActionListener(this);

		// add buttons to panel
		buttonPanel.add(yesButton);
		buttonPanel.add(noButton);
		buttonPanel.add(refresh);
		buttonPanel.add(restart);
		
		buttonPanel.setBackground(new Color(245, 111, 22));

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

			// display the questions
			displayText();
		}
		else if (buttonPressed.equals(noButton))
		{
			// update game
			game.chooseNo();

			// display the questions
			displayText();
		}
		// if Update button is pressed
		else if (buttonPressed.equals(refresh))
		{
			// execute update process only if current node is a leaf
			if (game.getCurrentNode().isLeaf())
			{
				// try get user's thing from the input field
				try 
				{
					// throw an error if user tries to input empty string
					if ( (answerField.getText().isEmpty()) || (questionField.getText().isEmpty()) ) 
						throw new IllegalArgumentException("Input is wrong");
					// otherwise, get input and update game tree
					else 
					{
						// get the user's answer
						userA = answerField.getText();

						// get the user's question
						userQ = questionField.getText();

						// inform user that game has been updated
						textDisplay.append("\nGame updated. Thanks for your input!");

						// Update the game tree taxonomy
						game.updateGameTree(userA, userQ);

					}
				} // catch the error
				catch (IllegalArgumentException iae) 
				{
					// prompt user to type something
					textDisplay.append("\n Input is empty! Please type something.");
				}
			} else
			{
				textDisplay.append("\nPlease update only at the end of the game.");;
			}
		}
		// else, if Restart button is pressed
		else 
		{	
			// restart game
			game.restart();

			// display 1st question again
			displayText();
		}
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
			textDisplay.append("\nAm I correct? You can press Restart Game to play this again if I am."
					+ "\nOtherwise, please type below which app you were thinking of!"
					+ "\nThen type in the question that distinguishes your answer and my guess"
					+ "\nYour question should still lead to my guess via Yes/No, depends on what "
					+ "\nthe previous question did.");
		}
	}
}
