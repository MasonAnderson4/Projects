package HW6;

import java.util.TreeSet;

// This class adds words into a tree and displays them in alphabetical order in 5 columns
// @author Mason Anderson
// @version 04/09/24

public class WordSet {
	
	private TreeSet<String> wordset;
	
	public WordSet() {
		wordset = new TreeSet<>();
	}
	
	private int wordSetSize = 0;
	private String longest = "";
	
	// this method adds a word into the wordset
	// @param the word that is going to be added
	// @return true if word added, false if word is already in wordset
	public boolean add(String word) {
		
		String cleanedWord = cleanWord(word);
		
		
		if(wordset.contains(cleanedWord) || cleanedWord.isEmpty()) {
			return false;
		}
		else {
			wordset.add(cleanedWord);
			if(cleanedWord.length() > longest.length()) {
				longest = cleanedWord;
			}
			wordSetSize++;
			return true;
		}
	}
	
	// this method cleans the word by removing any additional special characters at the beginning and end of a string
	// @param the string to be cleaned
	// @return the cleaned string
	private String cleanWord(String word) {
		word = word.toLowerCase();
		
		int start = 0;
		int end = word.length() - 1;
		
		while(start <= end && !Character.isLetterOrDigit(word.charAt(start))) {
			start++;
		}
		while(end >= start && !Character.isLetterOrDigit(word.charAt(end))) {
			end--;
		}
		
		if(start <= end) {
			return word.substring(start, end + 1);
		}
		else {
			return "";
		}
	}
	
	// this method finds the size of the wordset
	// @return the amount of words in the wordset
	public int size() {
		return wordSetSize;
	}
	
	// this method gets the longest word in the wordset
	// @return the longest word 
	public String getLongest() {
		return longest;
	}
	
	// this method displays the words in the wordset in alphabetical order and in five columns
	// @return the words in five columns
	public String toString() {
		String result = "";
		int words = 0;
		int longestWord = getLongest().length();
		for(String word : wordset) {
			words++;
			int spaceNeeded = longestWord + 1 - word.length();
			result += (word + " ".repeat(spaceNeeded));
			if(words %5 == 0) {
				result += "\n";
			}
		}
		return result;
	}

}
