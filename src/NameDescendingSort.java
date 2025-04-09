import java.util.Comparator;
import java.util.List;

public class NameDescendingSort implements SortStrategy {
    public void sort(List<Event> events) {
        events.sort(Comparator.comparing(Event::getName).reversed());
    }
}