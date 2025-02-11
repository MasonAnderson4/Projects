package HW7;

import java.io.File;
import java.util.Scanner;

// this class displays the shortest path of an FSM based on user input of a start and end state
//@author Mason Anderson
//@version 04/22/24

public class PathFinder {

	public static void main(String[] args) throws java.io.FileNotFoundException {
		
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
			
			System.out.println("Enter the end state: ");
			String endState = input.next();
			
			if(fsm.findPath(startState, endState) == null) {
				System.out.println("NO SUCH PATH");
			}
			else {
				System.out.println("State path: " + fsm.findPath(startState, endState));
				System.out.println("Edge labels: " + fsm.findEdges(fsm.findPath(startState, endState)));
			}
			
		
			System.out.println();
			
		
		} while(!startState.equals("*"));

	}

}
