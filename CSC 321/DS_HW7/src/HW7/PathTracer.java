package HW7;

import java.util.Scanner;
import java.io.File;
import java.util.List;
import java.util.ArrayList;

// this class finds the end state of a FSM based on user input for start state and a sequence of edges
// @author Mason Anderson
// @version 04/22/24

public class PathTracer {
	
	public static void main(String args[]) throws java.io.FileNotFoundException {
		
		FiniteStateMachine fsm = new FiniteStateMachine();
		Scanner input = new Scanner(System.in);
		System.out.println("Enter FSM file: ");
		String filename = input.next();
		
		Scanner console = new Scanner(new File(filename));
		
		do {
			String start = console.next();
			String edge = console.next();
			String end = console.next();
			fsm.addEdge(start, edge, end);
			
		} while(console.hasNextLine());
		
		
		
		String startState;
		
		do {
			System.out.println("Enter a start state (* to end): ");
			startState = input.next();
			
			
			if(startState.equals("*")) {
				System.out.println("DONE");
				break;
			}
			
			input.nextLine();
			
			System.out.println("Enter a step sequence (separated with whitespace): ");
			String edges = input.nextLine();
			
			if(fsm.findEndState(startState, stringToList(edges)) == null){
				System.out.println("Illegal Sequence");
			}
			else {
				System.out.println("End State: " + fsm.findEndState(startState, stringToList(edges)));
			}
		
			System.out.println();
			
		
		} while(!startState.equals("*"));
		
		
		
		
	}
	// this method takes a string and adds all the words in the string to a list
	// @param the string of words to be added to list
	// @return an ArrayList of words
	private static List<String> stringToList(String string){
		List<String> wordList = new ArrayList<String>();
		
		String words[] = string.split(" ");
		
		for(String word : words) {
			wordList.add(word);
		}
		
		return wordList;
	}

}
