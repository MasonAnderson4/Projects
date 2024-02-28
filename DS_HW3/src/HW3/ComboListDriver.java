package HW3;

// Driver class for ComboList class to time get operation of ComboList and ArrayList and LinkedList
// @author Mason Anderson
// @version 2/22/2024

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedList;

public class ComboListDriver {
	
	public static void main(String [] args) {
		ComboList<Integer> clist = new ComboList<Integer>(10);
		ArrayList<Integer> alist = new ArrayList<Integer>();
		LinkedList<Integer> lList = new LinkedList<Integer>();
		Scanner console = new Scanner(System.in);
		
		System.out.println("Insert the starting list size: ");
		int initialSize = readInteger(console);
		
		System.out.println("Doubling list size until: ");
		int finalSize = readInteger(console);
		
		
		timeOperations(alist, initialSize, finalSize, "ArrayList");
		timeOperations(lList, initialSize, finalSize, "LinkedList");
		
		System.out.println("ComboList");
		StopWatch stopWatch = new StopWatch();
		while(initialSize <= finalSize) {
			for(int i = 0; i < initialSize; i++) {
				clist.add(i);
				
			}
			stopWatch.start();
			for(int i = 0; i < clist.size(); i++) {
				clist.get(i);
			}
			stopWatch.stop();
			System.out.println(initialSize + ": " + stopWatch.getElapsedTime());
			clist.clear();;
			initialSize *= 2;
		}	
		
		
	}
	
	// method to ensure the user inserts a valid integer
	// @param the scanner object
	// @return the integer
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
	
	// Method to time both ArrayList and LinkedList
	// @param the list wanted, the initial size of list, and final size of list
	public static void timeOperations(List<Integer> implementation, int initialSize, int finalSize, String listType) {
		StopWatch stopWatch = new StopWatch();
		System.out.println(listType);
		while(initialSize <= finalSize) {
			for(int i = 0; i < initialSize; i++) {
				implementation.add(i);
			}
			stopWatch.start();
			for(int i = 0; i < initialSize; i++) {
				implementation.get(i);
			}
			stopWatch.stop();
			System.out.println(initialSize + ": " + stopWatch.getElapsedTime());
			implementation.clear();
			initialSize *= 2;
		}

	}
}
