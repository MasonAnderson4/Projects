package A3;

/*
 * Author: Mason Anderson
 * Version: 10/23/23
 */

public class CityStats {
	
	private String city;
	private String state;
	private double groceries;
	private double housing;
	private double utilities;
	private double transportation;
	private double health;
	private double miscellaneous;
	
	public CityStats(String city, String state, double groceries, double housing, double utilities, double transportation, 
			double health, double miscellaneous) {
		this.city = city;
		this.state = state;
		this.groceries = groceries;
		this.housing = housing;
		this.utilities = utilities;
		this.transportation = transportation;
		this.health = health;
		this.miscellaneous = miscellaneous;
	}

	public String getCity() {
		return this.city;
	}

	public String getState() {
		return this.state;
	}

	public double getGroceries() {
		return this.groceries;
	}

	public double getHousing() {
		return this.housing;
	}

	public double getUtilities() {
		return this.utilities;
	}

	public double getTransportation() {
		return this.transportation;
	}

	public double getHealth() {
		return this.health;
	}

	public double getMiscellaneous() {
		return this.miscellaneous;
	}
	
	public double getCOLI() {
		double COLI = (0.13*this.groceries) + (0.29*this.housing) + (0.10*this.utilities) + (0.12*this.transportation) 
				+ (0.04*this.health) + (0.32*this.miscellaneous);
		return Math.round(COLI * 10.0)/10.0;
	}
	
	public static void main(String[] args) {
		CityStats obj = new CityStats("AA", "BB", 92, 79.3, 89.9, 100, 96.8, 89.7);
		System.out.println(obj.getCOLI());
	}

}
