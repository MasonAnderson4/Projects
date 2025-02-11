package Q3;

import java.util.Scanner;

public class MultiplicationTable {
	public static void main(String[] args) {
		Scanner num = new Scanner(System.in);
		
		System.out.println("Enter the number for the multiplication table: ");
		int number1 = num.nextInt();
		
		System.out.println("Enter how high the table should go: ");
		int number2 = num.nextInt();
		
		System.out.printf("Multiplication table for %d up to %d:%n%n", number1,number2);
		
		for(int i = 1; i <= number2; i ++) {
			System.out.println(number1 + " X "+ i + " = " + number1*i);
		}
	}
	
	
}
