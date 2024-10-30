package HW4;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
/*
 * This class creates a schedule based on specific wants such as shortest event first
 * @author Mason Anderson
 * @version 10/29/24
 */

public class ScheduleCreator {
	
	/* this method checks to see if an event is required
	 * @param the event as a ScheduleEvent object
	 * @return true if required, false otherwise
	 */
	public boolean isRequiredEvent(ScheduleEvent event) {	
		if(event.getEvent().contains("REQ")) {
			return true;
		}
		return false;
	}
	
	/*
	 * this method builds a schedule as an ArrayList, checking for conflicts and adding required events
	 * @param the list of events
	 * @return the schedule as an ArrayList
	 */
	public ArrayList<ScheduleEvent> buildSchedule(ArrayList<ScheduleEvent> events) {
		ArrayList<ScheduleEvent> schedule = new ArrayList<ScheduleEvent>();
		
		for (ScheduleEvent event : events) {
	        boolean hasConflict = false;
	       

	        if(!schedule.isEmpty()) {
	        	for (ScheduleEvent scheduledEvent : schedule) {
		            if (isScheduleConflict(scheduledEvent, event)) {
		                hasConflict = true;
		                break; 
		            }
		        }
	        }
	        if (!hasConflict) {
	            schedule.add(event);
	        }
	       
	    }
		
		for(ScheduleEvent event : events) {
			if(!schedule.contains(event) && isRequiredEvent(event)) {
				schedule.add(event);
		    }
		}

        Collections.sort(schedule, new SortByTime());

        
        for(int i = 0; i < schedule.size() - 1; i++) {
        	if(isRequiredEvent(schedule.get(i))) {
        		schedule.get(i).setEvent(schedule.get(i).getEvent().replace("REQ", "").trim());
        		if(isScheduleConflict(schedule.get(i), schedule.get(i+1))) {
        			schedule.remove(i+1);
        			i--;
        		}
        		else if(isScheduleConflict(schedule.get(i), schedule.get(i-1))) {
        			schedule.remove(i-1);
        			i--;
        		}
        	}
        }
 

        return schedule;
	}
	
	/*
	 * this method determines if two events conflict by looking at start and end times of both
	 * @param the two events being compared as ScheduleEvent objects
	 * @return true if conflict, false otherwise
	 */
	public boolean isScheduleConflict(ScheduleEvent event1, ScheduleEvent event2) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("H:mm");

	    LocalTime start1 = LocalTime.parse(event1.getStartTime(), formatter);
	    LocalTime end1 = LocalTime.parse(event1.getEndTime(), formatter);
	    LocalTime start2 = LocalTime.parse(event2.getStartTime(), formatter);
	    LocalTime end2 = LocalTime.parse(event2.getEndTime(), formatter);

	    return start1.isBefore(end2) && end1.isAfter(start2);
	}
}
