import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
/**
 * Represents an individual task
 * 
 * @author Aleksei Meritt-Powell
 */
public class Task extends ListItem {
    private boolean isComplete;

    // Inner enum class to represent priority levels
    public enum PriorityLevel {
        LOW, MEDIUM, HIGH
    }

    private PriorityLevel priority;

    // Constructor
    public Task(String title, String dueDate, PriorityLevel priority) {
        super(title, LocalDate.parse(dueDate));
        this.priority = priority;
        this.isComplete = false;
    }

    /** Marks the task as complete */
    public void markComplete() {
        this.isComplete = true;
    }

    /** Checks if the task is complete */
    public boolean isComplete() {
        return this.isComplete;
    }

    // Override abstract display method
    @Override
    public void display() {
        System.out.println("Task: " + super.title);
        System.out.println("Due Date: " + super.date);
        System.out.println("Priority: " + this.priority);
        System.out.println("Status: " + (isComplete ? "Complete" : "Incomplete"));
    }

    @Override
    public String prettyPrint() {
        String ret = "[";
        ret += this.isComplete ? "x" : " ";
        ret += "] ";

        String pattern = "MM-dd-yyyy";
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern(pattern);
        ret += fmt.format(date);
        ret += ": ";

        ret += title;

        return ret;
    }

    // toString() method for debugging and printing
    @Override
    public String toString() {
        return "Task[title=" + title + ", dueDate=" + super.date +
                ", priority=" + priority + ", isComplete=" + isComplete + "]";
    }
}