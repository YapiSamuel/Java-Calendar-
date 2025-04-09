import java.time.LocalDateTime;
import java.time.Duration;

public class EventTester {

    public static void main(String... args) {
        testEvent();
        testDeadline();
        testMeeting();
    }

    // Test method for the Event class
    public static void testEvent() {
        System.out.println("Testing Event class...");

        // As Event is abstract, we need a concrete subclass for testing
        Event event = new Event("Sample Event", LocalDateTime.now()) {
            @Override
            public String getName() {
                return super.getName();
            }
        };

        // Test getName()
        System.out.println("Event Name: " + event.getName());

        // Test getDateTime()
        System.out.println("Event DateTime: " + event.getDateTime());

        // Test setDateTime()
        event.setDateTime(LocalDateTime.of(2025, 12, 31, 23, 59));
        System.out.println("Updated Event DateTime: " + event.getDateTime());

        // Test setName()
        event.setName("Updated Event");
        System.out.println("Updated Event Name: " + event.getName());

        System.out.println();
    }

    // Test method for the Deadline class
    public static void testDeadline() {
        System.out.println("Testing Deadline class...");

        Deadline deadline = new Deadline("Project Deadline", LocalDateTime.of(2025, 5, 10, 12, 0));

        // Test getName()
        System.out.println("Deadline Name: " + deadline.getName());

        // Test getDateTime()
        System.out.println("Deadline DateTime: " + deadline.getDateTime());

        // Test complete() and isComplete()
        System.out.println("Is Complete: " + deadline.isComplete());
        deadline.complete();
        System.out.println("Is Complete after completion: " + deadline.isComplete());

        // Test setDateTime()
        deadline.setDateTime(LocalDateTime.of(2025, 6, 1, 10, 0));
        System.out.println("Updated Deadline DateTime: " + deadline.getDateTime());

        // Test setName()
        deadline.setName("Updated Deadline");
        System.out.println("Updated Deadline Name: " + deadline.getName());

        System.out.println();
    }

    // Test method for the Meeting class
    public static void testMeeting() {
        System.out.println("Testing Meeting class...");

        Meeting meeting = new Meeting("Team Meeting", LocalDateTime.of(2025, 3, 15, 9, 0), LocalDateTime.of(2025, 3, 15, 10, 0), "Conference Room");

        // Test getName()
        System.out.println("Meeting Name: " + meeting.getName());

        // Test getDateTime()
        System.out.println("Meeting Start DateTime: " + meeting.getDateTime());

        // Test getEndTime()
        System.out.println("Meeting End DateTime: " + meeting.getEndTime());

        // Test getLocation()
        System.out.println("Meeting Location: " + meeting.getLocation());

        // Test getDuration()
        System.out.println("Meeting Duration: " + meeting.getDuration().toMinutes() + " minutes");

        // Test complete() and isComplete()
        System.out.println("Is Complete: " + meeting.isComplete());
        meeting.complete();
        System.out.println("Is Complete after completion: " + meeting.isComplete());

        // Test setDateTime()
        meeting.setDateTime(LocalDateTime.of(2025, 4, 1, 14, 0));
        System.out.println("Updated Meeting Start DateTime: " + meeting.getDateTime());

        // Test setEndTime()
        meeting.setEndTime(LocalDateTime.of(2025, 4, 1, 15, 0));
        System.out.println("Updated Meeting End DateTime: " + meeting.getEndTime());

        // Test setLocation()
        meeting.setLocation("Updated Conference Room");
        System.out.println("Updated Meeting Location: " + meeting.getLocation());

        System.out.println();
    }
}
