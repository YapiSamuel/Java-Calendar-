import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;

public class AddEventModal extends JDialog {
    private EventListPanel parent;

    public AddEventModal(EventListPanel parent) {
        this.parent = parent;
        setTitle("Add New Event");
        setModal(true);
        setSize(300, 400);
        setLocationRelativeTo(parent);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        add(panel);

        JTextField nameField = new JTextField(20);
        panel.add(new JLabel("Event Name:"));
        panel.add(nameField);

        JComboBox<String> eventType = new JComboBox<>(new String[]{"Deadline", "Meeting"});
        panel.add(new JLabel("Event Type:"));
        panel.add(eventType);

        JTextField dateField = new JTextField(20);
        panel.add(new JLabel("Date (YYYY-MM-DDTHH:MM):"));
        panel.add(dateField);

        JTextField endDateField = new JTextField(20);
        panel.add(new JLabel("End Date (YYYY-MM-DDTHH:MM) (for Meetings only):"));
        panel.add(endDateField);

        JTextField locationField = new JTextField(20);
        panel.add(new JLabel("Location (for Meetings only):"));
        panel.add(locationField);

        JButton addButton = new JButton("Add Event");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                LocalDateTime date = LocalDateTime.parse(dateField.getText());
                if (eventType.getSelectedItem().equals("Deadline")) {
                    parent.addEvent(new Deadline(name, date));
                } else if (eventType.getSelectedItem().equals("Meeting")) {
                    LocalDateTime endDate = LocalDateTime.parse(endDateField.getText());
                    String location = locationField.getText();
                    parent.addEvent(new Meeting(name, date, endDate, location));
                }
                dispose();
            }
        });
        panel.add(addButton);
    }
}
