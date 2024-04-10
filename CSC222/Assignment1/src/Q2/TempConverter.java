package Q2;

import java.util.Scanner;

public class TempConverter {
	public static void main(String[] args) {
		Scanner choiceObj = new Scanner(System.in);
		boolean y_n = true;
		
		while (y_n) {
			System.out.println("Temperature Converter" + "\n1. Convert Celsius to Fahrenheit");
			System.out.println("2. Convert Fahrenheit to Celsius" + "\n3. Exit");
			
			System.out.println("Enter your choice: ");
			int choice = choiceObj.nextInt();
			
			if(choice == 1) {
				System.out.println("Enter temperature in Celsius: ");
				double celsius = choiceObj.nextDouble();
				double fahrenheit = celsius*(9.0/5.0)+32;
				System.out.printf("Temperature in Fahrenheit: %.1f %n", fahrenheit);
			}
			
			else if(choice == 2) {
				System.out.println("Enter temperature in Fahrenheit: ");
				double fahrenheit = choiceObj.nextDouble();
				double celsius = ((fahrenheit-32)*(5.0/9.0));
				System.out.printf("Temperature in Celsius: %.1f %n", celsius);
			}
			
			else if (choice == 3) {
				System.out.println("Goodbye!");
				y_n = false;
			}
			
			if (y_n) {
				System.out.println("Do you want to perform another conversion? (y/n): ");
				String letter = choiceObj.next();
				if (!(letter.equalsIgnoreCase("y"))) {
					System.out.println("Goodbye");
					y_n = false;
				}
			}
			
		}
		
		}

	}

