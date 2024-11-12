package HW5;

/**
 * this class represents the range puzzle
 * @author Mason Anderson
 * @version 11/11/24
 */

public class Range extends Puzzle{
	
	public Range(String filename) throws java.io.FileNotFoundException {
		super(filename);
	}
	
	/**
	 * checks if there is a number in the same row or column
	 * @param row row of grid
	 * @param col column of grid
	 * @return true if there is a number, false otherwise
	 */
	private boolean hasNumber(int row, int col) {
		for(int i = 0; i < this.numRows(); i++) {
			try {
				Integer.parseInt(super.grid[i][col]);
				return true;
			} catch(NumberFormatException e) {
				
			}
		}
		for(int i = 0; i < this.numCols(); i++) {
			try {
				Integer.parseInt(super.grid[row][i]);
				return true;
			} catch(NumberFormatException e) {
				
			}
		}
		return false;
	}
	
	/**
	 * method checks possible white squares from a number piece
	 * @param row row of grid
	 * @param col column of grid
	 * @return int of number of possible white squares
	 */
	private int numPossibleWhiteSquares(int row, int col) {
		int possibleWhiteSquares = 0;
		
		for(int i = 0; i < this.numRows(); i++) {
			if(!super.grid[i][col].equals("▣")) {
				possibleWhiteSquares++;
			}
		}
		
		for(int i = 0; i < this.numCols(); i++) {
			if(!super.grid[row][i].equals("▣")) {
				possibleWhiteSquares++;
			}
		}
        
        return possibleWhiteSquares - 1;
	}
	
	 /**
     * Determines if there is a conflict after placing piece in (row,col).
     *   @param row the row where the piece was placed
     *   @param col the column where the piece was placed
     *   @return true if that pieces caused a conflict, else false
     */
	public boolean hasConflict(int row, int col) {
		String piece = super.grid[row][col];
		int rangeValue = 0;
		int whiteSquares = 0;
		String numPiece = "";
		int possibleSquares = 0;
		
		
		for(int i = 0; i  < this.numRows(); i++) { // seeing if there is a number in that row
			if(!super.grid[i][col].equals("-") && !super.grid[i][col].equals("▣") && !super.grid[i][col].equals("▢")) {
				rangeValue = Integer.parseInt(super.grid[i][col]);
				numPiece = super.grid[i][col];
				whiteSquares = 1;
				
				int tempCol = col - 1;
	            while (tempCol >= 0 && !super.grid[i][tempCol].equals("▣") && !super.grid[i][tempCol].equals("-")) {
	                whiteSquares++;
	                tempCol--;  // move left
	            }

	            tempCol = col + 1;
	            while (tempCol <= this.numCols() - 1 && !super.grid[i][tempCol].equals("▣") && !super.grid[i][tempCol].equals("-")) {
	                whiteSquares++;
	                tempCol++;  // move right
	            }
	            
	            int tempRow = i - 1;
	            while(tempRow >= 0 && !super.grid[tempRow][col].equals("▣") && !super.grid[tempRow][col].equals("-")) {
	            	whiteSquares++;
	            	tempRow--; // move up
	            }
	            
	            tempRow = i + 1;
	            while(tempRow <= this.numRows() - 1 && !super.grid[tempRow][col].equals("▣") && !super.grid[tempRow][col].equals("-")) {
	            	whiteSquares++;
	            	tempRow++; // move down
	            }
			}
			
			if(whiteSquares > rangeValue) {
				return true;
			}
			
			if(piece.equals("▣")  && hasNumber(row,col)) {
				for(int j = 0; j < this.numRows(); j++) {
					if(super.grid[j][col].equals(numPiece)) {
						possibleSquares = numPossibleWhiteSquares(j, col);
					}
				}
				for(int j = 0; j < this.numCols(); j++) {
					if(super.grid[row][j].equals(numPiece)) {
						possibleSquares = numPossibleWhiteSquares(row, j);
					}
				}
				if(possibleSquares < rangeValue) {
					return true;
				}
			} // couldn't quite figure out how to make it ensure possible length
		}
		if(piece.equals("▣")) { // black square in quotes
			if((col > 0 && super.grid[row][col - 1].equals(piece)) || 
			   (col < this.numCols() - 1 && super.grid[row][col + 1].equals(piece))) {
				return true; // checks if piece to left or right is also black
			}
			if((row > 0 && super.grid[row - 1][col].equals(piece)) ||
			   (row < this.numRows() - 1 && super.grid[row + 1][col].equals(piece))) {
				return true; // checks if piece above and below is also black
			}
		}
		
		return false;
	}
}
