
import java.time.LocalDateTime;

public abstract class Event implements Comparable<Event> {
    public String name;
    private LocalDateTime dateTime;

    public Event(String name, LocalDateTime dateTime) {
        this.name = name;
        this.dateTime = dateTime;
    }
    //Abstract method to get the name
    public abstract String getName();

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

    //CompareTo method to compare dates
    public int compareTo(Event o) {
        return dateTime.compareTo(o.getDateTime());
    }

}
