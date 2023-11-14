package A3;

import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;

/*
 * Author: Mason Anderson
 * Version: 11/12/23
 */

public class CityLookup {
	
	private int totalCount;
	private final ArrayList<CityStats> cityStats;
	
	public CityLookup(String file) {
		
		this.totalCount = 0;
		this.cityStats = new ArrayList<>();
		
		
		try {
			Scanner scanner = new Scanner(new File(file));
			
			while(scanner.hasNextLine()) {
				double groceries = Double.parseDouble(scanner.next());
				double housing = Double.parseDouble(scanner.next());
				double utilities = Double.parseDouble(scanner.next());
				double transportation = Double.parseDouble(scanner.next());
				double health = Double.parseDouble(scanner.next());
				double miscellaneous = Double.parseDouble(scanner.next());
				String state = scanner.next();
				String city = scanner.nextLine().trim();
				
				CityStats cityCOLI = new CityStats(city, state, groceries, housing, utilities, transportation, health, miscellaneous);
				this.cityStats.add(cityCOLI);
				totalCount++;
				
			}
			
			
			
			scanner.close();
		}
		catch (FileNotFoundException e) {
			System.out.println("File not found: " + file);
		}
		
	}
	
	public int numCities() {
		return totalCount;
	}
	public void showByState(String state) {
		ArrayList<CityStats> cities = new ArrayList<>();
		
		for(CityStats stat : cityStats) {
			if(stat.getState().equalsIgnoreCase(state)) {
				cities.add(stat);
			}
		}
		
		for(CityStats stat : cities) {
			System.out.println(stat.getCity() + ", " + stat.getState() + ": " + stat.getCOLI());
		}
		
		System.out.println("Numbers of cities in " + state + ": " + cities.size());
	}
	
	public void showByCity(String city) {
		ArrayList<CityStats> cities = new ArrayList<>();
		
		for(CityStats stat : cityStats) {
			if(stat.getCity().contains(city)) {
				cities.add(stat);
			}
		}
		
		for(CityStats stat : cities) {
			System.out.println(stat.getCity() + ", " + stat.getState() + ": " + stat.getCOLI());
		}
		
		System.out.println("Number of cities that contain " + city + ": " + cities.size());
	}
	
	public double lookupCOLI(String city, String state) {
		CityStats foundCityStat = null;
		for(CityStats stat : cityStats) {
			if(stat.getCity().equalsIgnoreCase(city) && stat.getState().equalsIgnoreCase(state)) {
				foundCityStat = stat;
				break;
			}
		}
		return foundCityStat != null ? foundCityStat.getCOLI() : -999.0;
	}
	
	public double compareCities(double salary, String currentCity, String currentState, String newCity, String newState) {
		double currentCOLI = lookupCOLI(currentCity, currentState);
		double nextCOLI = lookupCOLI(newCity, newState);
		return Math.round((salary * (nextCOLI/currentCOLI)) *10.0) / 10.0;
	}
	

}
