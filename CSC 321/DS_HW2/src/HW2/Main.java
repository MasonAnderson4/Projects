package HW2;

import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

//@author: Mason Anderson
//@version: 02/08/2024
/*This class tests the difference in efficiency between an array queue and a linked list by having it perform add/remove/peek
 * operations with increasing list sizes that double depending on user input.
 */

public class Main {
	
	public static void main(String [] args) {
		Scanner console = new Scanner(System.in);
		
		System.out.println("(A)rray or (L)inked implementation: ");
		String implementation = console.next();
		
		while(!implementation.equalsIgnoreCase("A") && !implementation.equalsIgnoreCase("L")) {
			System.out.println("Invalid input. Please try again and insert either 'A' or 'L'.");
			implementation = console.next();
		}
		
		System.out.println("Starting queue size: ");
		int queueSize = readInteger(console);
		
		System.out.println("Doubling size until: ");
		int doubleSize = readInteger(console);
		while(doubleSize < queueSize) {
			System.out.println("Invalid input. Please try again and insert an integer greater than 0.");
			doubleSize = readInteger(console);
		}
		
		System.out.println("Number of peek/remove/add operations: ");
		int numOperations = readInteger(console);
		
		Queue<Integer> q;
		
		if(implementation.equalsIgnoreCase("A")) {
			q = new ArrayQueue<Integer>();
			timeOperations(q, queueSize, doubleSize, numOperations);
		}
		else {
			q = new LinkedList<Integer>();
			timeOperations(q, queueSize, doubleSize, numOperations);
		}
		
		
	}
	
	
	// method to insure user inputs a valid integer
	// @param a scanner object set for input
	// @return an integer that is within the acceptable parameters
	public static int readInteger(Scanner console) {
		while(true) {
			if(console.hasNextInt()) {
				int input = console.nextInt();
				if(input > 0) {
					return input;
				}
				else {
					System.out.println("Invalid input. Please try again and insert an integer greater than 0.");
				}
			}
			else {
				System.out.println("Invalid input. Please try again and insert an integer greater than 0.");
				console.next();
			}
			
		}
	}
	
	
	// method to time the operations
	// @param a queue, queue size, double until size, and number of peek/remove/add operations
	public static void timeOperations(Queue<Integer> implementation, int queueSize, int doubleSize, int numOperations) {
		StopWatch stopWatch = new StopWatch();
		while(queueSize <= doubleSize) {
			for(int i = 0; i < queueSize; i++) {
				implementation.add(1);
			}
			stopWatch.start();
			for(int i = 0; i < numOperations; i++) {
				implementation.peek();
				implementation.remove();
				implementation.add(1);
			}
			stopWatch.stop();
			System.out.println(queueSize + ": " + stopWatch.getElapsedTime());
			implementation.clear();
			queueSize *= 2;
		}

	}

}
