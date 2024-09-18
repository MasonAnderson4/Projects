package HW2;

import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.List;

// This class creates a knapsack with a weight limit and allows adding items into the knapsack
// @author: Mason Anderson
// @version: 09/18/2024



public class Knapsack {
	
	private ArrayList<KnapsackItem> knapsack = new ArrayList<KnapsackItem>();
	private Set<KnapsackItem> bestSubset;
	ArrayList<Integer> bestValue;
	private int weightLimit;
	
	public Knapsack(int weight) {
		this.weightLimit = weight;
	}
	
	public int getWeightLimit() {
		return weightLimit;
	}
	
	
	public void addItem(KnapsackItem item){
		knapsack.add(item);
	}
	
	// this method finds the optimal subset and returns a set of descriptors
	// @return a set of descriptors
	public Set<KnapsackItem> findOptimalSubset(){
		bestSubset = new HashSet<KnapsackItem>();
		bestValue = new ArrayList<Integer>();
		bestValue.add(0);
		
		findOptimalSubsetRecursive(new ArrayList<KnapsackItem>(),0,0,0,bestValue);
			
		return bestSubset;
	}
	// this method is a recursive helper method to findOptimalSubset
	// @param a list of currentSubset, an index, currentWeight, currentValue, and an ArrayList of bestValue
	private void findOptimalSubsetRecursive(List<KnapsackItem> currentSubset, int index, int currentWeight, int currentValue, ArrayList<Integer> bestValue) {
		if(index == knapsack.size()) {
			if(currentWeight <= weightLimit && currentValue > bestValue.get(0)) {
				bestValue.set(0, currentValue);
				bestSubset.clear();
				for(KnapsackItem knapsackItem : currentSubset) {
					bestSubset.add(knapsackItem);
				}
			}
			
			return;
		}
		
		//include current item in subset
		currentSubset.add(knapsack.get(index));
		findOptimalSubsetRecursive(currentSubset, index + 1, 
				currentWeight + knapsack.get(index).getWeight(), currentValue + knapsack.get(index).getValue(), bestValue);
		
		//backtrack
		currentSubset.remove(currentSubset.size() - 1);
		findOptimalSubsetRecursive(currentSubset, index + 1, currentWeight, currentValue, bestValue);
	}
	
	// this method overrides toString and displays it to match the assignment description
	// @return the optimal descriptors as well as the value of those descriptors
	public String toString() {
		String descriptors = "";
		int totalValue = bestValue.get(0);
		for(KnapsackItem item : bestSubset) {
			descriptors += "\n" + item.getDescriptor();
		}
		
		return descriptors + "\n\nTotal Value: $" + totalValue;
	}


}
