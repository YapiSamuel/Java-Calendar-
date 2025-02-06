import javax.swing.*;
import java.awt.BorderLayout;
import java.time.LocalDateTime;

public class EventPlanner {
    public static void main(String[] args) {

        //Create a frame
        JFrame frame = new JFrame("Event Planner");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);

        //Create the EventListPanel and add it to the frame
        EventListPanel eventListPanel = new EventListPanel();
        frame.add(eventListPanel, BorderLayout.CENTER);

        //Add default events
        addDefaultEvents(eventListPanel);

        //make the frame visible
        frame.setVisible(true);
    }

    //Method to add default events to the EventListPanel
    static void addDefaultEvents(EventListPanel events){
        Deadline deadline = new Deadline("Project Deadline", LocalDateTime.of(2025, 5, 10, 12, 0));
        Meeting meeting = new Meeting("Team Meeting", LocalDateTime.of(2025, 3, 15, 9, 0), LocalDateTime.of(2025, 3, 15, 10, 0), "Conference Room");

        events.addEvent(deadline);
        events.addEvent(meeting);
    }
}
