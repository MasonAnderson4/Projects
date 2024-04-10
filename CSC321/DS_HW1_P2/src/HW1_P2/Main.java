package HW1_P2;

import java.util.Scanner;

//Authors: Mason Anderson
//Date: January 21, 2024

public class Main {
	
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		System.out.println("Insert file name of credit card numbers: ");
		String fileName = console.next();
		CreditCardReader reader = new CreditCardReader(fileName);
		reader.readFile();
		console.close();
	}

}
