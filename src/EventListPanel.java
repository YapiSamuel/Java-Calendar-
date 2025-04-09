import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EventListPanel extends JPanel {
    //The different variable have been created in the
    private ArrayList<Event> events;  // List of events
    private JPanel controlPanel;  // Holds the controls for event display
    private JPanel displayPanel;  // Holds the EventPanels corresponding to the events
    private JScrollPane scrollPane;  // Scroll wrapper
    private JComboBox<String> sortDropDown;  // Dropdown for sorting events
    private JCheckBox filterDisplay;  // Checkbox for filtering events
    private JButton addEventButton;  // Button to open AddEventModal
    private SortStrategy sortStrategy;


    public EventListPanel() {
        setLayout(new BorderLayout()); // Ensures proper layout

        events = new ArrayList<>();  // Initialize the event list

        // The control panel (header)
        controlPanel = new JPanel();
        controlPanel.setBackground(Color.RED);
        controlPanel.setPreferredSize(new Dimension(400, 100));

        // Components of the control panel
        String[] options = { "Name Ascending", "Name Descending", "Date Ascending", "Date Descending" };
        sortDropDown = new JComboBox<>(options);
        sortDropDown.addActionListener(e -> sortEvents((String) sortDropDown.getSelectedItem()));
        controlPanel.add(sortDropDown);

        filterDisplay = new JCheckBox("Filter Completed Tasks");
        filterDisplay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateDisplay();

            }
        });
        controlPanel.add(filterDisplay);

        addEventButton = new JButton("Add Event");
        addEventButton.addActionListener(e -> openAddEventModal());
        controlPanel.add(addEventButton);

        // The display panel (Holds the events)
        displayPanel = new JPanel();
        displayPanel.setLayout(new BoxLayout(displayPanel, BoxLayout.Y_AXIS)); // Vertical layout
        displayPanel.setBackground(Color.ORANGE);

        // JScrollPane for scrolling the display panel
        scrollPane = new JScrollPane(displayPanel);
        scrollPane.setPreferredSize(new Dimension(400, 500));
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        // Add components to the main panel
        add(controlPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
    }
//once you click on the add event button it will insert the info generated into event panel and refresh it
    public void addEvent(Event event) {
        events.add(event);
        displayEvent(event);
        refreshDisplay();
    }
// create the template and shape for holding the text
    private void displayEvent(Event event) {
        EventPanel eventPanel = new EventPanel(event);
        displayPanel.add(eventPanel);
        displayPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Add some space between event panels

    }

    private void refreshDisplay() {
        displayPanel.revalidate();
        displayPanel.repaint();
    }

    private void sortEvents(String criteria) {
        switch (criteria) {
            case "Name Ascending":
                sortStrategy = new NameAscendingSort();
                break;
            case "Name Descending":
                sortStrategy = new NameDescendingSort();
                break;
            case "Date Ascending":
                sortStrategy = new DateAscendingSort();
                break;
            case "Date Descending":
                sortStrategy = new DateDescendingSort();
                break;
            default:
                return;
        }

        sortStrategy.sort(events);
        updateDisplay();
    }


    private void updateDisplay() {
        displayPanel.removeAll();  // Clear the current display
        for (Event event : events) {
            if (filterDisplay.isSelected() && event instanceof Completable && ((Completable) event).isComplete()) {
                continue;  // Skip completed events if the filter is enabled
            }
            displayEvent(event);  // Re-add the events in the new order
        }
        refreshDisplay();
    }

    private void openAddEventModal() {
        AddEventModal addEventModal = new AddEventModal(this);
        addEventModal.setVisible(true);
    }
}
