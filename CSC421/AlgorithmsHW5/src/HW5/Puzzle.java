package HW5;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * generalized puzzle solver class
 * @author Mason Anderson
 * @version 11/11/2024
 */
public abstract class Puzzle {
	protected String[][] grid;
    private ArrayList<String> values;
    private int numCol;
    private int numRow;
    
    /**
     * Constructs a grid with contents read in from a file.
     *   @param filename the file name containing the grid
     *   @throws java.io.FileNotFoundException 
     */
    public Puzzle(String filename) throws java.io.FileNotFoundException {	
        Scanner infile = new Scanner(new File(filename));  
        
        values = new ArrayList<String>();
        String valuesAsOne = infile.nextLine();
        String [] valuesSplit = valuesAsOne.split(" ");
        for(String value : valuesSplit) {
        	this.values.add(value);
        }
        
        this.numCol = infile.nextInt();
        this.numRow = infile.nextInt();
        this.grid = new String[numCol][numRow];

        for (int r = 0; r < numRow; r++) {
            for (int c = 0; c < numCol; c++) {
            	this.grid[r][c] = infile.next();
            }
        }
    }
    /**
     * Determines the number of rows in grid.
     *   @return the number of rows (height)
     */
    public int numRows() {
    	return this.numRow;
    }
    /**
     * Determines the number of columns in grid
     * @return the number of columns (width)
     */
    public int numCols() {
    	return this.numCol;
    }
    /**
     * Converts the grid to a String for printing.
     *   @return the String representation of the grid
     */
    public String toString() {
        String output = "";
        for (int r = 0; r < this.numRows(); r++) {
            for (int c = 0; c < this.numCols(); c++) {
                output += grid[r][c] + " ";
            }
            output += "\n";
        }
        return output;
    }
    /**
     * Fills the puzzle grid using recursive backtracking.
     *   @return true if grid has been filled, else false
     */
    public boolean solve() {
        return this.solve(0, 0);
    }
    private boolean solve(int row, int col) {
        if (row == this.numRows()) {                      // HAVE FILLED ALL THE ROWS, SO DONE
            return true;
        }
        else if (col == this.numCols()) {                 // HAVE FILLED THIS ROW, SO WRAP
            return this.solve(row+1, 0);
        }
        else if (!this.grid[row][col].equals("-")) {  // SPOT IS ALREADY FILLED, SO MOVE ON
            return this.solve(row, col+1);
        }
        else {                                        // NEED TO FILL SPOT
            for (String value : values) {
                this.grid[row][col] = ""+value;
                if (!this.hasConflict(row, col) && this.solve(row, col+1)) {
                    return true;
                }
                this.grid[row][col] = "-";   
            }
            return false;
        }
    }
    /**
     * abstract method to check for conflicts
     * @param row row number to check in grid
     * @param col column number to check in grid
     * @return true if conflict, false otherwise
     */
    public abstract boolean hasConflict(int row, int col);
}
