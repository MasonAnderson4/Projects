package HW5;

/**
 * this class represents the three in a row puzzle
 * @author Mason Anderson
 * @version 11/11/2024
 */
public class ThreeInARow extends Puzzle{
	
	public ThreeInARow(String filename) throws java.io.FileNotFoundException {
		super(filename);
	}
	
	 /**
     * Determines if there is a conflict after placing piece in (row,col).
     *   @param row the row where the piece was placed
     *   @param col the column where the piece was placed
     *   @return true if that pieces caused a conflict, else false
     */
	public boolean hasConflict(int row, int col) {
		String piece = super.grid[row][col];
		int maxOfColor = this.numRows()/2;
		int numOfColorRow = 0;
		int numOfColorCol = 0;
        
        if(col > 1 && super.grid[row][col - 2].equals(piece) && super.grid[row][col - 1].equals(piece)) {
        	return true; // checks if the two squares to the left of the piece are the same as piece if they exist
        }
        
        if(col < this.numCols() - 2 && super.grid[row][col + 2].equals(piece) && super.grid[row][col + 1].equals(piece)) {
        	return true; // checks if the two squares to the right of the piece are the same as piece if they exist
        }
        
        if(row > 1 && super.grid[row - 2][col].equals(piece) && super.grid[row - 1][col].equals(piece)) {
        	return true; // checks if the two squares above the piece are the same as piece if they exist
        }
        
        if(row < this.numRows() - 2 && super.grid[row + 2][col].equals(piece) && super.grid[row + 1][col].equals(piece)) {
        	return true; // checks if the two squares below the piece are the same as piece if they exist
        }
        
        if((col > 0 && super.grid[row][col - 1].equals(piece)) &&
           (col < this.numCols() - 1 && super.grid[row][col+1].equals(piece))) {
        	return true; // checks if square to left and right are the same as piece trying to enter
        }
        
        if((row > 0 && super.grid[row - 1][col].equals(piece)) && 
           (row < this.numRows() - 1 && super.grid[row + 1][col].equals(piece))) {
        	return true; // checks if square above and below are the same as piece trying to enter
        }
        
        for(int i = 0; i < this.numCols(); i++) {
        	if(super.grid[i][col].equals(piece)) {
        		numOfColorCol++;
        	}
        }
        if(numOfColorCol > maxOfColor) {
        	return true; // checks to see if there is the max number of the color of piece in a column
        }
        
        for(int i = 0; i < this.numRows(); i++) {
        	if(super.grid[row][i].equals(piece)) {
        		numOfColorRow++;
        	}
        }
        if(numOfColorRow > maxOfColor) {
        	return true; // checks to see if there is the max number of the color of piece in a row
        }
        
		return false;
	}
}

