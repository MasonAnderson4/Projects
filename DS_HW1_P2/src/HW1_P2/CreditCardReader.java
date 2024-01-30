package HW1_P2;

import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;

//Authors: Mason Anderson
//Date: January 23, 2024


public class CreditCardReader {
	
	private String filename;
	
	public CreditCardReader(String filename) {
		this.filename = filename;
	}
	
	//method to read each line and store all digits or ? without anything else
	//returns: An array list with the credit card numbers as longs
	public ArrayList<String> readFile() {
		File file = new File(filename);
		ArrayList<String> numberList = new ArrayList<String>();
		
		
		try(Scanner scanner = new Scanner(file)){
			while(scanner.hasNextLine()) {
				String creditCardNumber = scanner.nextLine();
				
				creditCardNumber = creditCardNumber.replaceAll("[^\\d?]", "");
				
				numberList.add(creditCardNumber);
				
			}
		}
		catch(FileNotFoundException e) {
			System.out.print("Error: " + filename + "not found.");
		}
		
		luhnAlgorithm(numberList);
		
		return numberList;
	}
	
	//method to perform Luhn Algorithm on a string
	//parameters: an array list of the numbers as Strings
	//returns: whether the credit card number is valid or invalid
	public void luhnAlgorithm(ArrayList<String> list) {
		
		ArrayList<String> valid = new ArrayList<String>();
		ArrayList<String> invalid = new ArrayList<String>();
		
		for(int i = 0; i < list.size(); i ++) {
			int total = 0;
			String individualNumber = list.get(i);
			int questionMarkCount = 0;
			
			
			if (individualNumber.length() % 2 == 0) {
				for(int j = 0; j < individualNumber.length(); j++) {
					if(individualNumber.charAt(j) == '?') {
						questionMarkCount++;
					}
					else {
						int digit = Character.getNumericValue(individualNumber.charAt(j));
						if(j % 2 == 0 || j == 0) {
							digit *= 2;
							if(digit >= 10) {
								int firstDigit = digit/10;
								int secondDigit = digit%10;
								total += firstDigit + secondDigit;
							}
							else {
								total += digit;
							}
						}
						else {
							total += digit;
						
						}
					}
						
			}
		}
				else {
					for(int j = 0; j < individualNumber.length(); j++) {
						if(individualNumber.charAt(j) == '?') {
							questionMarkCount++;
						}
						else {
							int digit = Character.getNumericValue(individualNumber.charAt(j));
							if(j % 2 == 0 || j == 0) {
								total += digit;
							}
							else {
								digit *= 2;
								if(digit >= 10) {
									int firstDigit = digit/10;
									int secondDigit = digit%10;
									total += firstDigit + secondDigit;
								}
								else {
									total += digit;
								}
							}
						}
					}
				}
				
			if(questionMarkCount == 1) { 
				valid.add(questionMarkHandling(list.get(i),total));
			}
				 
			if(questionMarkCount > 1) {
				String invalidInput = list.get(i);
				invalid.add(invalidInput);
			}
			else if(total % 10 == 0) {
				String validInput = list.get(i);
				valid.add(validInput);
			}
			else if(total %10 != 0 && !individualNumber.contains("?")){
				String invalidInput = list.get(i);
				invalid.add(invalidInput);
			}
		}
		
		creditCardNumberSorter(valid, invalid);
		
	}
	
	//method to sort the credit card numbers in order and display them under valid or invalid
	//parameters: an ArrayList for valid numbers and an ArrayList for invalid numbers
	//returns: sorted list of valid and invalid credit card numbers
	public void creditCardNumberSorter(ArrayList<String> valid, ArrayList<String> invalid) {
		
		Collections.sort(valid);
		System.out.println("VALID");
		for(int i = 0; i < valid.size(); i++) {
			System.out.println(valid.get(i));
		}
		
		Collections.sort(invalid);
		System.out.println("\nINVALID");
		for(int i = 0; i < invalid.size(); i++) {
			System.out.println(invalid.get(i));
		}
		
	}
	
	
	//method to replace ? with proper number to be valid
	//parameters: the arraylist of credit card numbers and the total
	//returns: the corrected arraylist
	public String questionMarkHandling(String currentIndex, int total) {
		int correctNumber = 0;
		boolean result = currentIndex.contains("?");
		
		int indexOfQuestionMark = currentIndex.indexOf("?");
		
		if(result) {
			
			if(indexOfQuestionMark%2 == 0) {
				for(int j = 0; j<10; j++) {
					int digit = j*2;
					
					if(digit >= 10) {
						int firstDigit = digit/10;
						int secondDigit = digit%10;
						digit = firstDigit + secondDigit;
					}
					
					if((total+digit)%10 == 0) {
						correctNumber = j;
					}
				}
			}
			else {
				for(int j = 0; j<10; j++) {
					if((total+j)%10 == 0) {
						correctNumber = j;
					}
				}
			}
			
			String correctNumberAsString = String.valueOf(correctNumber);
			currentIndex = currentIndex.replace("?", correctNumberAsString);
			}
			
		return currentIndex;
	}
	

}
