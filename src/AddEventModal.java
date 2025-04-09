import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.util.Objects;

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
                Event event = EventFactory.createEvent(
                        (String) eventType.getSelectedItem(),
                        name,
                        date,
                        LocalDateTime.parse(endDateField.getText()),
                        locationField.getText()
                );
                parent.addEvent(event);

                dispose();
            }
        });
                panel.add(addButton);

    }
}