import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;

public class EventPlanner {
    public static void main(String[] args) {
        // Create the frame
        JFrame frame = new JFrame("Event Planner");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 700);

        // Create the EventListPanel and add it to the frame
        EventListPanel eventListPanel = new EventListPanel();
        frame.add(eventListPanel, BorderLayout.CENTER);

        // Add default events
        addDefaultEvents(eventListPanel);

        // Make the frame visible
        frame.setVisible(true);
    }

    public static void addDefaultEvents(EventListPanel eventListPanel) {
        Deadline deadline = new Deadline("Project Deadline", LocalDateTime.of(2025, 5, 10, 12, 0));
        Meeting meeting = new Meeting("Team Meeting", LocalDateTime.of(2025, 3, 15, 9, 0), LocalDateTime.of(2025, 3, 15, 10, 0), "Conference Room");

        eventListPanel.addEvent(deadline);
        eventListPanel.addEvent(meeting);
    }
}
