package HW4;

import java.time.LocalTime;
import java.time.Duration;
import java.time.format.DateTimeFormatter;

/*
 * This class creates an object for events in schedule
 * @author Mason Anderson
 * @version 10/29/24
 */

public class ScheduleEvent {
	
	private String startTime;
	private String endTime;
	private String event;
	
	public ScheduleEvent(String startTime, String endTime, String event) {
		this.startTime = startTime;
		this.endTime = endTime;
		this.event = event;
	}
	
	/*
	 * this method returns the start time of an event
	 * @return a String of the start time of event
	 */
	public String getStartTime() {
		return startTime;
	}
	
	/*
	 * this method returns the end time of an event
	 * @return a String of the end time of event
	 */
	public String getEndTime() {
		return endTime;
	}
	
	/*
	 * this method returns the name/description of the event
	 * @return a String of the event name/description
	 */
	public String getEvent() {
		return event;
	}
	
	/*
	 * this method sets the event name/description (used to replace REQ)
	 * @param the event name/description 
	 */
	public void setEvent(String event) {
		this.event = event;
	}
	
	/*
	 * this method gets the event length between the start and end times of an event
	 * @return the number of minutes between start and end time of an event as an int
	 */
	public int getEventLength() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("H:mm");
	    LocalTime start = LocalTime.parse(startTime, formatter);
	    LocalTime end = LocalTime.parse(endTime, formatter);

	    return (int) Duration.between(start, end).toMinutes();
	}
	

}
