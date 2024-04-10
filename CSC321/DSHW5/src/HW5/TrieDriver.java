package HW5;

import java.io.File;
import java.util.Scanner;

//@author: Mason Anderson
//@version: 04/03/24
// class that creates a driver to test out a trie and see if the methods work

public class TrieDriver {
	
	public static void main(String[] args) throws java.io.FileNotFoundException {
		
		Scanner input = new Scanner(new File("dictionary"));
		
		
		Trie trie = new Trie();
		while(input.hasNext()) {
			trie.add(input.next());
		}
			
		Scanner console = new Scanner(System.in);
		System.out.println("Enter a sequence (blank line to end): ");
        String word;
        do {
            word = console.nextLine().trim();
            if (!word.isEmpty()) {
                checkWord(trie, word);
                System.out.println("Enter again: ");
            }
        } while (!word.isEmpty()); 

        System.out.print("DONE");
    } 
    
	// this method tells whether a word is a word, a prefix, or neither
	// @param: the trie itself and a word to test
	private static void checkWord(Trie trie, String word) {
        if (trie.contains(word)) {
            System.out.println(word + " is a word.");
        } else if (trie.containsPrefix(word)) {
            System.out.println(word + " is not a word, but it is a prefix of a word.");
        } else {
            System.out.println(word + " is neither a word nor a prefix.");
        }
    }

}
