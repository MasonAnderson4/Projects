package A4;

import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;

/*
 * Author: Mason Anderson
 * Version: 11/28/23
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
			Collections.sort(cityStats);
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
	
	
	public String lookupByRank(int rank) {
		
		CityStats byRank;
		
		if(Math.abs(rank) >= cityStats.size() || rank == 0) {
			return "Invalid Rank.";
		}
		
		else if(rank > 0) {
			byRank = cityStats.get(rank - 1);
			return (rank) + ") " + byRank.getCity() + ", " + byRank.getState() + ": " + byRank.getCOLI();
		}
		else {
			byRank = cityStats.get(cityStats.size() + rank);
			return (cityStats.size() + rank + 1) + ") " + byRank.getCity() + ", " + byRank.getState() + ": " + byRank.getCOLI();
		}	
		
	}
	
	public void showLowest(int count) {
		
		if(count > cityStats.size() || count <= 0) {
			System.out.println("Invalid count");
			return;
		}
		for(int i = 0; i < count; i++) {
			
			CityStats stats = cityStats.get(i);
			
			System.out.println(i + ")" + stats.getCity() + ", " + stats.getState() + ": " + stats.getCOLI());
			
		}
	}
	
	public void showHighest(int count) {
		
		if(count > cityStats.size() || count <= 0) {
			System.out.println("Invalid count");
		}
		
		for(int i = 1; i <= count; i++) {
			
			CityStats stats = cityStats.get(cityStats.size() - i);
			
			System.out.println((cityStats.size() - i + 1) + ")" + stats.getCity() + ", " + stats.getState() + ": " + stats.getCOLI());
			
		}
	}

}