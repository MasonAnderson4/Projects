package HW4;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;

/*
 * Driver class to read in text file and output schedules
 * @author Mason Anderson
 * @version 10/29/24
 */

public class ScheduleDriver {

	public static void main(String[] args) throws FileNotFoundException {
		
		ScheduleCreator schedule = new ScheduleCreator();
		
		ArrayList<ScheduleEvent> events = new ArrayList<ScheduleEvent>();
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter name of file: ");
		String fileName = input.next();
		
		Scanner console = new Scanner(new File(fileName));
		
		while(console.hasNextLine()) {
			String startTime = console.next();
			String endTime = console.next();
			String event = console.nextLine().trim();
			
			ScheduleEvent eventDetails = new ScheduleEvent(startTime, endTime, event);
			events.add(eventDetails);
		}
		
		Collections.sort(events, new SortByDuration());
		ArrayList<ScheduleEvent> shortest = schedule.buildSchedule(events);
		System.out.println("Shortest event first: \n---------------------");
		scheduleOutput(shortest);
		
		Collections.sort(events, new SortByDurationDescending());
		ArrayList<ScheduleEvent> longest = schedule.buildSchedule(events);
		System.out.println("\nLongest event first: \n--------------------");
		scheduleOutput(longest);
		
		Collections.sort(events, new SortByStartTime());
		ArrayList<ScheduleEvent> startTime = schedule.buildSchedule(events);
		System.out.println("\nEarliest start-time first: \n--------------------------");
		scheduleOutput(startTime);
		
		Collections.sort(events, new SortByEndTime());
		ArrayList<ScheduleEvent> endTime = schedule.buildSchedule(events);
		System.out.println("\nEarliest end-time first: \n------------------------");
		scheduleOutput(endTime);

	}
	
	/*
	 * this method outputs the schedule in the correct format
	 * @param the schedule as an ArrayList
	 */
	private static void scheduleOutput(ArrayList<ScheduleEvent> events) {
		for(ScheduleEvent event : events) {
			System.out.printf("%5s %5s %-20s%n", event.getStartTime(), event.getEndTime(), event.getEvent());
		}
	}
	
	

}
