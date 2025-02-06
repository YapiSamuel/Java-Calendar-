import java.time.Duration;
import java.time.LocalDateTime;

public class Meeting extends Event implements Completable {
    private LocalDateTime endDateTime;  // The time the meeting is over
    private String location;  // Represents the location of the meeting
    private boolean complete;  // Holds the completion status of the meeting

    // Constructor
    public Meeting(String name, LocalDateTime start, LocalDateTime end, String location) {
        super(name, start);
        this.endDateTime = end;
        this.location = location;
        this.complete = false;  // Initialize as not complete
    }

    // Implementation of the abstract getName method from Event class
    @Override
    public String getName() {
        return this.name;
    }

    // Implementation of complete method from Completable interface
    @Override
    public void complete() {
        this.complete = true;
    }

    // Implementation of isComplete method from Completable interface
    @Override
    public boolean isComplete() {
        return this.complete;
    }

    // Method to get the end time of the meeting
    public LocalDateTime getEndTime() {
        return this.endDateTime;
    }

    // Method to get the duration of the meeting
    public Duration getDuration() {
        return Duration.between(super.getDateTime(), this.endDateTime);
    }

    // Method to get the location of the meeting
    public String getLocation() {
        return this.location;
    }

    // Method to set the end time of the meeting
    public void setEndTime(LocalDateTime end) {
        this.endDateTime = end;
    }

    // Method to set the location of the meeting
    public void setLocation(String location) {
        this.location = location;
    }

    public String toString() {
        return "Meeting: " + name + " from " + dateTime + " to " + endDateTime + " at " + location;
    }
}
