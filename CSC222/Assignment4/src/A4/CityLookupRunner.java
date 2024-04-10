package A4;

public class CityLookupRunner {
    public static void main(String[] args) {
        CityStats stats = new CityStats("AA", "BB", 92, 79.3, 89.9, 100, 96.8, 89.7);
        System.out.println(stats.getCOLI());
        CityLookup cityLookup = new CityLookup("COLI2010.txt");
        cityLookup.showByState("ND");
        cityLookup.showByCity("burgh");
        System.out.println(cityLookup.compareCities(65000, "Omaha", "NE", "Chicago", "IL"));
    }
}

