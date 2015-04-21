
/** Tile declares the properties of each tile in
 * a 2D Minesweeper game board
 * @author nganhoang
 *
 */
public class Tile {
	/** Instance Properties **/
	// Determines whether the tile is a bomb or not
	private boolean bombOrNot;
	
	// Determines whether the tile is flipped 
	private boolean flipOrNot;
	
	// Determines the number of adjacent bombs around a mine
	private int numAdjBombs;
	
	/** Constructor **/
	public Tile()
	{	
		// Set all tiles to be not bombs
		bombOrNot = false;
		// Set all tiles to be not flipped
		flipOrNot = false;
		//  Initialize number of adjacent bombs to 0
		numAdjBombs = 0;
	}
	
	/** Instance Methods **/
	public String displayTile()
	{
		// If the tile's not flipped
		if (flipOrNot == false)
		{
			// Return "x"
			return "x";
		}
		// Otherwise if it's flipped
		else 
		{
			// If it's a bomb 
			if (bombOrNot == true)
			{
				// Return *
				return "*";
			}
			// Otherwise if it's not a bomb
			else 
			{
				// Return the number of adjacent bombs 
				return Integer.toString(numAdjBombs);
			}
		}
	}
	
    // Checks to see if it's a bomb or not
	public boolean checkBombStatus()
	{
		return bombOrNot;
	}
	
    // Set a tile to be a bomb
	public void setBombs()
	{
		// Set the tile to be a bomb
		bombOrNot = true;
	}
	
    // Flip a tile
	public void flipTile()
	{
		flipOrNot = true;
	}
	
    // Checks to see if it's flipped or not
	public boolean isTileFlipped()
	{
		return flipOrNot;
	}

    // Increase the number of adjacent bombs by 1
	public void increaseAdjBombs()
	{
		numAdjBombs = numAdjBombs + 1;
	}
	
}
