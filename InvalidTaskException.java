/**
 * Raised if an invalid task is added to a user's list
 * 
 * @author Aleksei Meritt-Powell
 */
public class InvalidTaskException extends Exception{
    public InvalidTaskException(String message) {
        super(message);
    }
}