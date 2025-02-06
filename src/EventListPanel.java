import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;


public class EventListPanel extends JPanel {
    private DefaultListModel<Event> eventListModel;
    private JList<Event> eventList;

    public EventListPanel() {
        setLayout(new BorderLayout());

        // Initialize the event list model and JList
        eventListModel = new DefaultListModel<>();
        eventList = new JList<>(eventListModel);

        // Add the JList to a scroll pane
        JScrollPane scrollPane = new JScrollPane(eventList);
        add(scrollPane, BorderLayout.CENTER);
    }

    // Method to add an event to the list
    public void addEvent(Event event) {
        eventListModel.addElement(event);
    }
}
