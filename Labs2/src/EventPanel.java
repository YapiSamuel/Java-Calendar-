import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventPanel extends JPanel {
    private Event event;
    private JButton completeButton;
    private JLabel statusLabel;

    public EventPanel(Event event) {
        this.event = event;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(Color.LIGHT_GRAY);
        setPreferredSize(new Dimension(450, 150));
        setMaximumSize(new Dimension(450, 150));

        // Add event details
        addEventDetails();

        // Add complete button if the event implements Completable
        if (event instanceof Completable) {
            completeButton = new JButton("Complete");
            completeButton.setAlignmentX(Component.CENTER_ALIGNMENT);
            completeButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    ((Completable) event).complete();
                    updateCompletionStatus();
                }
            });
            add(completeButton);
        }

        // Initialize status label
        statusLabel = new JLabel("Status: Not Completed");
        statusLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        statusLabel.setVisible(false);  // Initially hidden
        add(statusLabel);

        // Update the completion status
        updateCompletionStatus();
    }

    private void addEventDetails() {
        // Event information
        JTextArea eventInfo = new JTextArea(event.toString());
        eventInfo.setWrapStyleWord(true);
        eventInfo.setLineWrap(true);
        eventInfo.setEditable(false);
        eventInfo.setOpaque(false); // Make JTextArea background transparent
        eventInfo.setAlignmentX(Component.CENTER_ALIGNMENT); // Center align text
        add(eventInfo);

        // Separator for visual clarity
        JSeparator separator = new JSeparator(SwingConstants.HORIZONTAL);
        separator.setMaximumSize(new Dimension(350, 1));

        // Add components to the main panel
        add(separator);
    }

    private void updateCompletionStatus() {
        boolean isComplete = event instanceof Completable && ((Completable) event).isComplete();
        String statusText = isComplete ? "Completed" : "Not Completed";
        statusLabel.setText("Status: " + statusText);
        statusLabel.setVisible(isComplete);  // Show if completed, hide if not

        revalidate();
        repaint();
    }
}
