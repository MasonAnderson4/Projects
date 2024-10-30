package HW4;

import java.util.Comparator;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/*
 * this class compares ScheduleEvent objects based on times, lengths, start times, and end times
 * @author Mason Anderson
 * @version 10/29/24
 */

// Shortest event first
class SortByDuration implements Comparator<ScheduleEvent> {
	/*
	 * this method compares ScheduleEvent objects event lengths
	 * @param the ScheduleEvent objects
	 * @return 0 if both events have the same length, 
     *         < 0 if a has a shorter duration than b,
     *         > 0 if a has a longer duration than b
	 */
    public int compare(ScheduleEvent a, ScheduleEvent b) {
        return Integer.compare(a.getEventLength(), b.getEventLength());
    }
}

// Longest event first
class SortByDurationDescending implements Comparator<ScheduleEvent> {
	/*
	 * this method compares ScheduleEvent objects by event length in descending order
	 * @param the ScheduleEvent objects
	 * @return 0 if both events have the same length,
     *         < 0 if a has a longer duration than b,
     *         > 0 if a has a shorter duration than b
	 */
    public int compare(ScheduleEvent a, ScheduleEvent b) {
        return Integer.compare(b.getEventLength(), a.getEventLength());
    }
}

// Earliest start time first
class SortByStartTime implements Comparator<ScheduleEvent> {
	/*
	 * this method compares ScheduleEvent objects by their start times
	 * @param the ScheduleEvent objects
	 * @return 0 if both events start at the same time,
     *         < 0 if a starts earlier than b,
     *         > 0 if a starts later than b
	 */
    public int compare(ScheduleEvent a, ScheduleEvent b) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("H:mm");
        LocalTime timeA = LocalTime.parse(a.getStartTime(), formatter);
        LocalTime timeB = LocalTime.parse(b.getStartTime(), formatter);
        return timeA.compareTo(timeB);
    }
}

// Earliest end time first
class SortByEndTime implements Comparator<ScheduleEvent> {
	/*
	 * this method compares ScheduleEvent objects by their end times
	 * @param the ScheduleEvent objects
	 * @return 0 if both events end at the same time,
     *         < 0 if a ends earlier than b,
     *         > 0 if a ends later than b
	 */
    public int compare(ScheduleEvent a, ScheduleEvent b) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("H:mm");
        LocalTime timeA = LocalTime.parse(a.getEndTime(), formatter);
        LocalTime timeB = LocalTime.parse(b.getEndTime(), formatter);
        return timeA.compareTo(timeB);
    }
}

class SortByTime implements Comparator<ScheduleEvent>{
	/*
	 * this method compares ScheduleEvent objects start times
	 * @param the ScheduleEvent objects
	 * @return 0 if same start time,
	 *         < 0 if a starts before b,
	 *         > 0 if a starts after b
	 */
	public int compare(ScheduleEvent a, ScheduleEvent b) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("H:mm");
		
		LocalTime timeA = LocalTime.parse(a.getStartTime(), formatter);
	    LocalTime timeB = LocalTime.parse(b.getStartTime(), formatter);
	    
		return timeA.compareTo(timeB);
	}
}

