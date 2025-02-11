package HW5;

//@author: Mason Anderson
//@version: 04/03/24
// this class creates a Trie with multiple methods

public class Trie {
	
	private TrieNode root;
	
	public Trie() {
		this.root = new TrieNode();
		
	}
	// this class creates nodes for the trie and has getters and setters for the children and if it is the end of a word
	private class TrieNode{
		private TrieNode[] children;
		private boolean isEndOfWord;
		
		public TrieNode(){
			this.children = new TrieNode[26];
			this.isEndOfWord = false;
		}

		public TrieNode[] getChildren() {
			return children;
		}

		public void setChildren(TrieNode[] children) {
			this.children = children;
		}

		public boolean isEndOfWord() {
			return isEndOfWord;
		}

		public void setEndOfWord(boolean isEndOfWord) {
			this.isEndOfWord = isEndOfWord;
		}
	}
	
	int wordsStored = 0;
	
	// this method adds a word to the trie
	// @param the word that wants to be added
	// @return returns true at the end of the word when it is added
	public boolean add(String word) {
		TrieNode current = this.root;
		word = word.toLowerCase();
		
		for(int i = 0; i < word.length(); i++) {
			int index = word.charAt(i) - 'a';
			
			if(current.getChildren()[index] == null) {
				TrieNode newNode = new TrieNode();
				current.getChildren()[index] = newNode;
			}
			current = current.getChildren()[index];
		}
		current.setEndOfWord(true);
		wordsStored++;
		return current.isEndOfWord();
	}
	
	// this method sees if a word is in the trie
	// @param the word being tested
	// @return either true or false depending on if the word is in the trie
	public boolean contains(String word) {
		TrieNode current = this.root;
		word = word.toLowerCase();
		
		for(int i = 0; i < word.length(); i++) {
			int index = word.charAt(i) - 'a';
			if(current.getChildren()[index] == null) {
				return false;
			}
			current = current.getChildren()[index];
		}
		if(current != null && current.isEndOfWord()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	// this method sees if a word or string is a prefix of a word
	// @param the string being tested
	// @return true or false depending on if it is a prefix or not
	public boolean containsPrefix(String pre) {
		TrieNode current = this.root;
		pre = pre.toLowerCase();
		
		for(int i = 0; i < pre.length(); i++) {
			int index = pre.charAt(i) - 'a';
			if(current.getChildren()[index] == null) {
				return false;
			}
			current = current.getChildren()[index];
		}
		return true;
	}
	
	// this method tells the size of a trie
	// @return the number of words in a trie
	public int size() {
		return wordsStored;
	}

}
