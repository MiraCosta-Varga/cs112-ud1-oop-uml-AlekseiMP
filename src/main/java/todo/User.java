package src.main.java.todo;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a user with a unique task list.
 * 
 * @author Jett Bergthold
 */
public class User {
    private String username;
    private List<ListItem> taskList;

    /**
     * Creates a user with the given username
     * @param username The user's name
     */
    public User(String username) {
        this.username = username;
        this.taskList = new ArrayList<>();
    }

    /**
     * Adds a task to a user's todo list
     * @param task The task to add
     * @throws InvalidTaskException if {@code task} is missing a title
     */
    public void addTask(Task task) throws InvalidTaskException {
        if (task.getTitle() == null || task.getTitle().isEmpty()) {
            throw new InvalidTaskException("Task title cannot be null or empty.");
        }
        taskList.add(task);
    }

    /** 
     * Removes the item from the todo list
     * @param task The task to be removed
     */
    public void removeTask(Task task) {
        taskList.remove(task);
    }

    /** 
     * Get a user's todo list
     * @return The user's todo list
     */
    public List<ListItem> getTasks() {
        return taskList;
    }

    /** Display all tasks for the user */
    public String prettyTasks() {
        String ret = "";

        for (ListItem task : taskList) {
            ret += task.prettyPrint();
            ret += "\n";
        }

        return ret;

    }

    /** Display a user's todo list */
    public String display() {
        String ret = "User " + username + "'s Tasks:\n";
        ret += prettyTasks();
        return ret;
    }
}