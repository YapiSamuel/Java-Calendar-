import java.util.Comparator;
import java.util.List;

public class DateDescendingSort implements SortStrategy {
    public void sort(List<Event> events) {
        events.sort(Comparator.comparing(Event::getDateTime).reversed());
    }
}