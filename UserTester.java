/**
 * Tests the User class
 * 
 * @author Jett Bergthold
 */
public class UserTester {
    public static void main(String[] args) {
        try {
            // Create a user
            User user = new User("Aleksei");

            // Create some tasks
            Task task1 = new Task("Finish Java Project", "2024-10-20", Task.PriorityLevel.HIGH);
            Task task2 = new Task("Buy groceries", "2024-10-25", Task.PriorityLevel.MEDIUM);

            // Add tasks to user
            user.addTask(task1);
            user.addTask(task2);

            // Mark one task as complete
            task1.markComplete();

            // Display user tasks
            System.out.println(user.display());

            // Test task removal and display
            user.removeTask(task1);
            System.out.println(user.display());

            // Test exception handling
            Task invalidTask = new Task("", "2024-10-30", Task.PriorityLevel.LOW);
            user.addTask(invalidTask);  // This will throw an exception

        } catch (InvalidTaskException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}