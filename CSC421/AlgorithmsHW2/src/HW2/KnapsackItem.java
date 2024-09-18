package HW2;

// This class creates a knapsack item with a value, weight, and descriptor
//@author: Mason Anderson
//@version: 09/18/2024

public class KnapsackItem {
	
	private int value;
	private int weight;
	private String descriptor;
	
	// constructor that creates knapsack item
	// @param value, weight, and descriptor
	public KnapsackItem(int value, int weight, String descriptor) {
		this.value = value;
		this.weight = weight;
		this.descriptor = descriptor;
	}


	public int getValue() {
		return value;
	}


	public int getWeight() {
		return weight;
	}


	public String getDescriptor() {
		return descriptor;
	}

}
