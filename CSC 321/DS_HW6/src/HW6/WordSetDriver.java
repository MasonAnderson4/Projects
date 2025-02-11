package HW6;

import java.util.Scanner;
import java.io.File;


// This driver class reads a file and uses methods from WordSet 
//@author Mason Anderson
//@version 04/09/24

public class WordSetDriver {
	
	public static void main(String args[]) throws java.io.FileNotFoundException {
		
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the file name: ");
		String filename = input.next();
		
		Scanner console = new Scanner(new File(filename));
		
		WordSet wordset = new WordSet();
		
		while(console.hasNext()) {
			wordset.add(console.next());
		}
		System.out.println(filename + " contains " + wordset.size() + " unique words.");
		System.out.println(wordset.toString());
		
	}


}
