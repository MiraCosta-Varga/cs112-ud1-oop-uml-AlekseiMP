import java.util.ArrayList;
import java.util.List;
/**
 * Represents a user with a unique task list.
 * 
 * @author Jett Bergthold
 */
public class User {
    private String username;
    private List<Task> taskList;

    // Constructor
    public User(String username) {
        this.username = username;
        this.taskList = new ArrayList<>();
    }

    // Method to add a task
    public void addTask(Task task) throws InvalidTaskException {
        if (task.getTitle() == null || task.getTitle().isEmpty()) {
            throw new InvalidTaskException("Task title cannot be null or empty.");
        }
        taskList.add(task);
    }

    // Method to remove a task
    public void removeTask(Task task) {
        taskList.remove(task);
    }

    // Get all tasks
    public List<Task> getTasks() {
        return taskList;
    }

    // Display all tasks for the user
    public String prettyTasks() {
        String ret = "";

        for (Task task : taskList) {
            ret += task.prettyPrint();
            ret += "\n";
        }

        return ret;

    }

    public String display() {
        String ret = "User " + username + "'s Tasks:\n";
        ret += prettyTasks();
        return ret;
    }
}