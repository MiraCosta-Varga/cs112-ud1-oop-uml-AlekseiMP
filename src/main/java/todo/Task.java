package src.main.java.todo;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Represents an individual task
 * 
 * @author Aleksei Meritt-Powell
 */
public class Task extends ListItem {
    private boolean isComplete;

    /**
     * Inner enum to represent a task's priority level
     */
    public enum PriorityLevel {
        LOW, MEDIUM, HIGH
    }

    private PriorityLevel priority;

    /**
     * Constructs a task with the given properties
     * @param title The task's name
     * @param dueDate When the task is due
     * @param priority The task's priority level
     */
    public Task(String title, String dueDate, PriorityLevel priority) {
        super(title, LocalDate.parse(dueDate));
        this.isComplete = false;
    }

    /**
     * Constructs a task with the given properties
     * @param title The task's name
     * @param dueDate When the task is due
     * @param priority The task's priority level as either {@code "Low"}, {@code "Medium"}, or {@code "High"}
     * @throws {@link IllegalArgumentException} if {@code priority} is not one of the specified values.
     */
    public Task(String title, String dueDate, String priority) throws IllegalArgumentException {
        super(title, LocalDate.parse(dueDate));
        this.isComplete = false;
        switch (priority) {
        case "Low":
            this.priority = PriorityLevel.LOW;
        case "Medium":
            this.priority = PriorityLevel.MEDIUM;
        case "High":
            this.priority = PriorityLevel.HIGH;
        }
    }

    /** Marks the task as complete */
    public void markComplete() {
        this.isComplete = true;
    }

    /** 
     * Checks if the task is complete
     * @return {@code true} if the task is complete, otherwise {@code false}
     */
    public boolean getComplete() {
        return this.isComplete;
    }

    /**
     * Gets the priority level
     * @return The priority level, being either {@code "Low"}, {@code "Medium"}, or {@code "High"}
     */
    public String getPriority() {
        switch (this.priority) {
            default:
            case PriorityLevel.LOW:
                return "Low";
            case PriorityLevel.MEDIUM:
                return "Medium";
            case PriorityLevel.HIGH:
                return "High";
            }
    }

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