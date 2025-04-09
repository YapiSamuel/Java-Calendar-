import java.time.LocalDateTime;

public class EventFactory {
    public static Event createEvent(String type, String name, LocalDateTime startDate, LocalDateTime endDate, String location) {
        switch (type) {
            case "Deadline":
                return new Deadline(name, startDate);
            case "Meeting":
                return new Meeting(name, startDate, endDate, location);
            default:
                throw new IllegalArgumentException("Unknown event type: " + type);
        }
    }
}
