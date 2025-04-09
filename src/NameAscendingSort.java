import java.util.Comparator;
import java.util.List;

public class NameAscendingSort implements SortStrategy {
    public void sort(List<Event> events) {
        events.sort(Comparator.comparing(Event::getName));
    }
}
