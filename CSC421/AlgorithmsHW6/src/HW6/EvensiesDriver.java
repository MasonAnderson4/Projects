package HW6;

import java.util.Scanner;

/**
 * this class is a basic driver to show the expected tokens of each method based on user input of tokens and rounds
 * @author Mason Anderson
 * @version 12/03/2024
 */

public class EvensiesDriver {
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		
		System.out.println("Enter the number of tokens: ");
		int tokens = input.nextInt();
		
		System.out.println("Enter the number of rounds: ");
		int rounds = input.nextInt();
		
		Evensies evensies = new Evensies();
		
		System.out.println("ExpectedTopDown: " + evensies.expectedTopDown(tokens, rounds));
		
		System.out.println("ExpectedBottomUp: " + evensies.expectedBottomUp(tokens, rounds));
		
		System.out.println("ExpectedCaching: " + evensies.expectedCaching(tokens, rounds));
		
		
		
	}

}
