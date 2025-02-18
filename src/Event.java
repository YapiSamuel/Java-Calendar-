
import java.time.LocalDateTime;

public abstract class Event implements Comparable<Event> {
    //I made the string name to public instead of private
    private String name;
    protected LocalDateTime dateTime;

    public Event(String name, LocalDateTime dateTime) {
        this.name = name;
        this.dateTime = dateTime;
    }
    //Abstract method to get the name
    public String getName(){
        return name;
    };

    //Method to get the date and time
    public LocalDateTime getDateTime() {
        return dateTime;
    }

    //Method to set the date and time
    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    //Method to set the name
    public void setName(String name) {
        this.name = name;
    }

    //should add a get name method

    //CompareTo method to compare dates
    public int compareTo(Event o) {
        return dateTime.compareTo(o.getDateTime());
    }

    public String toString() {
        return name + " at " + dateTime;
    }
}
