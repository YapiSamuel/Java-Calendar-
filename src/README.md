The two patterns I decided to implement are factory and strategy pattern
1. Factory pattern 

**Purpose:** it aims to centralize the logic for creating different types of "Event" object (Deadline, Meeting) in one class rather than writing "if-else" logic all over the GUI. 

**The Implementation**
Step 1: Create the  EventFactory class.

Step 2: Replace the "if-else" of AddEventModal class by the following block of code: 

Event event = EventFactory.createEvent(

(String) eventType.getSelectedItem(),

name,

date,

LocalDateTime.parse(endDateField.getText()),

locationField.getText()

);

parent.addEvent(event);

2. Strategy Pattern

**Purpose:** Instead of putting all the sorting logic in one big switch in the EventListPanel, we define a strategy interface for sorting and plug in the different strategies dynamically.

**The Implementation:**

Step 1: Create the SortStrategy interface. 

Step 2: implement concrete strategies (the different sorting classes).

Step 3: Now replace the switch logic in EventListPanel.