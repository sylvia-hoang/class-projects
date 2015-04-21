// IO
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
 
// for integer parsing
import java.lang.NumberFormatException;
 
/* MineBoard creates a 2D array of the game board,
 * implements the bombs and initiates the game logic
 */
public class MineBoard {
	/** Instance Properties 
	 */
	// Declare the number of rows
	private int rowNumber; 
	// Declare the number of columns
	private int colNumber;
	// Declare the game board array of tiles
	private Tile[][] gameBoard;
	// Declare the number of bombs
	private int numBombs;
	
	/** Constructor
	 */
	public MineBoard()
	{
		// Initialize the number of rows and columns
		rowNumber = 8;
		colNumber = 8;
		// Initialize the number of bombs
		numBombs = 8;
		// Create a new game board
		createBoard();
		// Randomize the bombs
		randomizeBombs();
		// Update the number of adjacent tiles
		updateAdjTile();
		// Print initial game board
		printGameBoard();
		// Begin reading input from user
		readInput();
	}
	
	
	/** Instance Methods **
	 */
	public void createBoard()
	{
		// Declare the game board array to have tiles
		gameBoard = new Tile[colNumber][rowNumber];
		
		// Add tiles to the each slot of the board
		for (int i = 0; i < colNumber; i++)
		{
			for (int j = 0; j < rowNumber; j++)
			{
				gameBoard[i][j] = new Tile();
			}
		}
	}
	
	/** Randomly place the mines into the game board
	 * **/
	public void randomizeBombs()
	{
		// Declare and initialize count
		int count = 0;
		// Randomize 8 bombs into random positions of the game board
		while (count < numBombs)
		{
			// Randomize the x & y coordinates
			int x = (int)(Math.random() * colNumber);
			int y = (int)(Math.random() * rowNumber);
			// If the x-y tile is not a bomb
			if (gameBoard[x][y].checkBombStatus() == false)
			{
				// Set it to be a bomb
				gameBoard[x][y].setBombs();
				// Increment count
				count = count + 1;
			}
		}
	}
	
	/** Calculate the number that the non-mine tiles display
	 *  **/
	public void updateAdjTile()
	{
		// Loop through the 2D array
		for (int i = 0; i < colNumber; i++)
		{
			for (int j = 0; j < rowNumber; j++)
			{
				if (gameBoard[i][j].checkBombStatus())
				{	
					// Corner case 1: top left corner
					if  (i == 0 && j == 0)
					{
						gameBoard[1][0].increaseAdjBombs();
						gameBoard[1][1].increaseAdjBombs();
						gameBoard[0][1].increaseAdjBombs();
					}
					// Corner case 2: bottom left corner
					else if (i == 0 && j == rowNumber - 1) 
					{
						gameBoard[0][rowNumber - 2].increaseAdjBombs();
						gameBoard[1][rowNumber - 2].increaseAdjBombs();
						gameBoard[1][rowNumber - 1].increaseAdjBombs();
					}
					// Corner case 3: top right corner
					else if (i == colNumber - 1 && j == 0) 
					{
						gameBoard[colNumber - 2][0].increaseAdjBombs();
						gameBoard[colNumber - 2][1].increaseAdjBombs();
						gameBoard[colNumber - 1][1].increaseAdjBombs();
					}
					// Corner case 4: bottom right corner
					else if (i == colNumber - 1 && j == rowNumber - 1)
					{
						gameBoard[colNumber - 1][rowNumber - 2].increaseAdjBombs();
						gameBoard[colNumber - 2][rowNumber - 2].increaseAdjBombs();
						gameBoard[colNumber - 2][rowNumber - 1].increaseAdjBombs();
					}
					// Otherwise if it's the uppermost side of the grid
					else if (j == 0) 
					{
						gameBoard[i-1][0].increaseAdjBombs();
						gameBoard[i+1][0].increaseAdjBombs();
						gameBoard[i][1].increaseAdjBombs();
						gameBoard[i-1][1].increaseAdjBombs();
						gameBoard[i+1][1].increaseAdjBombs();
					}
					// Otherwise if it's the bottom side
					else if (j == rowNumber - 1) 
					{
						gameBoard[i-1][rowNumber - 1].increaseAdjBombs();
						gameBoard[i+1][rowNumber - 1].increaseAdjBombs();
						gameBoard[i][rowNumber - 2].increaseAdjBombs();
						gameBoard[i-1][rowNumber - 2].increaseAdjBombs();
						gameBoard[i+1][rowNumber - 2].increaseAdjBombs();
					}	
					// Otherwise if it's the left column
					else if (i == 0)
					{
						gameBoard[0][j-1].increaseAdjBombs();
						gameBoard[0][j+1].increaseAdjBombs();
						gameBoard[1][j-1].increaseAdjBombs();
						gameBoard[1][j+1].increaseAdjBombs();
						gameBoard[1][j].increaseAdjBombs();
					}	
					// Otherwise if it's the right column
					else if (i == colNumber - 1)
					{
						gameBoard[colNumber - 1][j-1].increaseAdjBombs();
						gameBoard[colNumber - 1][j+1].increaseAdjBombs();
						gameBoard[colNumber - 2][j].increaseAdjBombs();
						gameBoard[colNumber - 2][j-1].increaseAdjBombs();
						gameBoard[colNumber - 2][j+1].increaseAdjBombs();
					}	
					else 
					{
						gameBoard[i-1][j].increaseAdjBombs();
						gameBoard[i-1][j-1].increaseAdjBombs();
						gameBoard[i-1][j+1].increaseAdjBombs();
						gameBoard[i][j-1].increaseAdjBombs();
						gameBoard[i][j+1].increaseAdjBombs();
						gameBoard[i+1][j-1].increaseAdjBombs();
						gameBoard[i+1][j].increaseAdjBombs();
						gameBoard[i+1][j+1].increaseAdjBombs();
					}
				}
			}
		}
	}
	
	// Takes input from the user, looping till the user types "Quit"
	// or gives an incorrect value.
	public void readInput()
	{
		// Wrap input stream read input from the user
		BufferedReader in = new BufferedReader( new InputStreamReader(System.in));
		// Introduce game & Prompt the user to provide input
		System.out.println("Welcome to Interactive MineSweepers! "
				+ "Please provide your guess as the coordinates of your tile "
				+ "in the format: a,b (a is the row & b is the column number "
				+ "that the tile belongs to)." + "Type Quit to quit the game.");
		// Declare userGuess variable as a string
		String userGuess;
		// Try to read a line
		// This function potentially throws an IOException
		try
		{
			do // execute
			{
				userGuess = in.readLine();
				// if the length of the user's guess is 3
				if (userGuess.length() == 3)
				{
					// Try to extract the integer coordinates from the user's guess
					try 
					{
						char XCoordinate, YCoordinate;
						int X, Y;
						// Extract the x and y coordinates
						XCoordinate = userGuess.charAt(0);
						YCoordinate = userGuess.charAt(2);					
						// Convert the coordinates into integer & conform them to array index
						X = Integer.parseInt(Character.toString(XCoordinate)) - 1;
						Y = Integer.parseInt(Character.toString(YCoordinate)) - 1;
						
						// If the coordinates are out of bounds 
						if ((X >= colNumber) || (Y >= rowNumber) || (X < 0) || (Y < 0))
						{
							System.out.println("Type again using accessible coordinates between 1 and 8");
						}
						// Otherwise if all coordinates are within bounds
						else
						{	
							// Update game display & logic
							monitorGameStatus(X,Y);
						}
					}
					// Catch parsing error, thrown when user did not enter an integer
					catch ( NumberFormatException nfe )
					{
						// inform user of error
						System.out.println( "Error: input must be integer." );
					}
				} 
			}
			while (!userGuess.equals("Quit"));
		}
		
		// catch I/O exception
		catch ( IOException ioe )
		{
			// tell exception to print its error log
			ioe.printStackTrace();
		}
	}
	
	/** Takes in x and y coordinates of a tile,
	 * determines if game's over, won or still going
	 * prints the game board to console
	 * @param x
	 * @param y
	 */
	public void monitorGameStatus(int x, int y)
	{	
		// If it's a bomb --> game over
		if (gameBoard[x][y].checkBombStatus() == true) 
		{
			// Reveal the answer
			revealAnswer();
			// Print "you lost"
			System.out.println("You lost. Game over.");
			// Print the game board
			printGameBoard();
			// Exit the game
			System.exit(0);
		}
		// Otherwise, keep going 
		else 
		{
			// Flip the tile
			gameBoard[x][y].flipTile();
			// Print the game board
			printGameBoard();
			// Call gameWon function to check if the game's won or not 
			if (gameWon()) 
			{
				// Reveal the answer
				revealAnswer();
				// Print the game board
				printGameBoard();
				// Print to console that user won
				System.out.println("Congratulations, you won!");
				// Exit the game
				System.exit(0);
			}
		}
	}
	
	/** Print the 2D game board **
	 * 
	 */
	public void printGameBoard()
	{
		// declare a variable row of type String to which we concatenate
		String row;
		// For each row of the array
		for (int i = 0; i < colNumber; i++)
		{
			// Initialize row
			row = "";
			// For each object in that row
			for (int j = 0; j < rowNumber; j++)
			{
				// Adds to the row
				row = row + " " + gameBoard[i][j].displayTile();
			}
			// Print to console the content of each row
			System.out.println(row);
		}
	}
	
	/** Reveal answer by flipping all the tiles in the board
	 * 
	 */
	public void revealAnswer()
	{
		// Flip all tiles in the game board
		for (int m = 0; m < colNumber; m++)
		{
			for (int n = 0; n < rowNumber; n++)
			{
				gameBoard[m][n].flipTile();
			}
		}
	}
	
	/** 
	 * Checks if the game is won or not
	 * @return 
	 */
	public boolean gameWon()
	{
		for (int i = 0; i < colNumber; i++)
		{
			for (int j = 0; j < rowNumber; j++)
			{
				// If the tile's not a bomb
				if (gameBoard[i][j].checkBombStatus() == false)
				{
					// Check to see if it's not a flipped tile
					if (gameBoard[i][j].isTileFlipped() == false)
					{
						// Game is not won
						return false;
					} 
				}
			}
		}
		return true;
	}
	
	/**
	    * Special main method is run when the program
	    * is executed.
	    **/
	   public static void main( String[] args )
	   {
	      // create a new instance to start the code
	      new MineBoard();
	   } // end main
}

	