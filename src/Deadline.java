import java.time.LocalDateTime;

public class Deadline extends Event implements Completable {
    private boolean completed;

// Constructor
    public Deadline(String name, LocalDateTime deadline) {
        super(name, deadline);
        completed = false;
    }

    // Implementation of the abstract getName method from the event class
    //I've to remove this method check it out later on
    public String getName(){
        return super.name;
    }

    //Implementation of complete method from completable interface
    public void complete() {
        this.completed = true;
    }

    //Implementation of is complete method from completable interface
    public boolean isComplete() {
        return this.completed;
    }



}
