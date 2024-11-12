package HW5;

/**
 * Class that represents a Sudoku Puzzle (with backtracking solver).
 *   @author Dave Reed (edited by: Mason Anderson)
 *   @version 11/11/24
 */
public class Sudoku extends Puzzle{
    
    /**
     * Constructs a grid with contents read in from a file.
     *   @param filename the file name containing the grid
     *   @throws java.io.FileNotFoundException 
     */
    public Sudoku(String filename) throws java.io.FileNotFoundException {	
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
        for (int n = 0; n < this.numRows(); n++) {
            if ((col != n && super.grid[row][n].equals(piece)) || 
                (row != n && super.grid[n][col].equals(piece))) {
                return true;
            }
        }
        
        int squareSide = (int)Math.sqrt(super.grid.length);
        int baseRow = squareSide * (row/squareSide);
        int baseCol = squareSide * (col/squareSide);
        
        for (int r = baseRow; r < baseRow+squareSide; r++) {
            for (int c = baseCol; c < baseCol+squareSide; c++) {
                if ((row != r || col != c) && super.grid[r][c].equals(piece)) {
                    return true;
                }
            }
        }
        return false;
    }
}
