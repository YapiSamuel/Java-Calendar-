import java.time.LocalDateTime;

public class Deadline extends Event implements Completable {
    private boolean completed;

// Constructor
    public Deadline(String name, LocalDateTime deadline) {
        super(name, deadline);
        this.completed = false;
    }


    //Implementation of complete method from completable interface
    public void complete() {
        this.completed = true;
    }

    //Implementation of is complete method from completable interface
    public boolean isComplete() {
        return this.completed;
    }

    public String toString() {
        return "Deadline: " + super.getName() + "\n at " + dateTime;
    }


}
