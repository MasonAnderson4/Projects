package HW5;

import java.util.Scanner;

/**
 * Simple driver for solving different puzzle types.
 *   @author Mason Anderson
 *   @version 11/11/24
 */
public class PuzzleDriver {
    public static void main(String[] args) throws java.io.FileNotFoundException {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter the puzzle type of Sudoku (S), Three in a row(T), or Range(R): ");
        String puzzleType = input.next();
        
        while(!puzzleType.equalsIgnoreCase("S") && !puzzleType.equalsIgnoreCase("T") && !puzzleType.equalsIgnoreCase("R")) {
        	  System.out.println("Enter the puzzle type of Sudoku (S), Three in a row(T), or Range(R): ");
        	  puzzleType = input.next();
        }
        
        System.out.println("Enter the puzzle file name: ");
        String filename = input.next();
        input.close();
        
        Puzzle puz;
        
        if(puzzleType.equalsIgnoreCase("S")) {
        	puz = new Sudoku(filename);
        }
        else if(puzzleType.equalsIgnoreCase("T")) {
        	puz = new ThreeInARow(filename);
        }
        else {
        	puz = new Range(filename);
        }
      

        System.out.println(puz);
        
        if (puz.solve()) {
            System.out.println("Solution found:\n" + puz);
        }
        else {
        	System.out.println("No solution possible");
        }
    }    
}

