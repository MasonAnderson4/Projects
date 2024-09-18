package HW2;

import java.util.Scanner;
import java.io.File;

// This driver reads in a file and uses methods from Knapsack and KnapsackItem classes
//@author: Mason Anderson
//@version: 09/18/2024


public class KnapsackDriver {
	
	public static void main(String[] args) throws Exception {
		
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter the knapscak weight limit: ");
		int weightLimit = input.nextInt();
		Knapsack knapsack = new Knapsack(weightLimit);
		
		System.out.println("Enter the items file: ");
		String filename = input.next();
		
		Scanner console = new Scanner(new File(filename));
		
		while(console.hasNextLine()) {
			String valueAsString = console.next();
			int value = Integer.valueOf(valueAsString);
			String weightAsString = console.next();
			int weight = Integer.valueOf(weightAsString);
			String descriptor = console.nextLine();
			KnapsackItem knapsackItem = new KnapsackItem(value, weight, descriptor);
			knapsack.addItem(knapsackItem);
		}
		console.close();
		
		knapsack.findOptimalSubset();
		System.out.println(knapsack.toString());
		
	}

}
