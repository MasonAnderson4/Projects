package HW1;

import java.util.Scanner;
import java.io.File;
import java.util.Random;
import java.util.Map;
import java.util.HashMap;

/**
 * Class that reads in and stores the contents of a text file.
 *   @author Dave Reed (edited by: Mason Anderson)
 *   @version 9/5/24
 */

public class ApproxGenerator {
    private String cleanText;
    private Random randy;
    private Map<String, String> map;
    
    /**
     * Constructs a FileProcessor object that reads in text from a file. The
     * text is processed to remove non-letters and adjacent spaces, and letters
     * are converted to uppercase.
     *   @param fileName the file containing the text
     */
    public ApproxGenerator(String fileName) throws Exception {
        this.cleanText = "";
        this.randy = new Random();
        this.map = new HashMap<String, String>();

        Scanner infile = new Scanner(new File(fileName));
        while (infile.hasNextLine()) {
            String nextLine = infile.nextLine().toUpperCase();
            for (int i = 0; i < nextLine.length(); i++) {
                char ch = nextLine.charAt(i);
                if (Character.isLetter(ch) || ch == ' ') {
                    this.cleanText += ch;
                }
            }
            this.cleanText += " ";
        }
        this.cleanText = this.cleanText.trim().replaceAll("\\s+", " ");
        infile.close();
        
    
    }

    /**
     * Generates a string of the specified order and length, matching the 
     * statistical distribution of letters and spaces as the specified file.
     *   @param order the order for the approximation
     *   @param numChars the length of the generated string
     *   @return the generated string
     */
    public String generate(int order, int numChars) {  	
    	//checks if order is longer than text file
    	if(order > this.cleanText.length() || order < 1) {
    		throw new IllegalArgumentException("Order must be less than the number of characters in the file or >= 1");	
    	}
    	// checks to see if sequence wanted is shorter than order
    	if(numChars < order) {
    		int randomStart = this.randy.nextInt(this.cleanText.length() - numChars + 1);
    		return this.cleanText.substring(randomStart, randomStart + numChars);
    	}
    	
    	// key initialization
    	int randomIndex = this.randy.nextInt(this.cleanText.length());
    	String key = this.cleanText.substring(randomIndex, randomIndex + order - 1);    	
    	String finalString = key;
    	
    	// adds all potential keys with the same length of order and their next char to a map
    	for(int i = 0; i <= this.cleanText.length() - order; i++) {
    		String orderString = this.cleanText.substring(i, i + order - 1);
    		this.map.putIfAbsent(orderString, "");
    		this.map.put(orderString, map.get(orderString) + this.cleanText.charAt(i + order-1));
    	}
    	
    	
    	while(finalString.length() < numChars) {
    		if(order == 1) {
    			int index = this.randy.nextInt(this.cleanText.length());
                finalString += this.cleanText.charAt(index);
    		}
    		else {	
    			// handles case if it reaches the end of text file
    			if(this.map.containsKey(key) && !this.map.get(key).isEmpty()) {
    				int randomChar = this.randy.nextInt(this.map.get(key).length());
           	   		char nextChar = this.map.get(key).charAt(randomChar);
          	   		finalString += nextChar;
               		key = key.substring(1) + nextChar;
    			}
    			else {
    				randomIndex = this.randy.nextInt(this.cleanText.length() - order + 1);
                    key = this.cleanText.substring(randomIndex, randomIndex + order - 1);
    			}
    		}  	
    	}
    	return finalString;   	
    }    
    
}
