import java.time.LocalDate;

public abstract class ListItem {
    protected String title;
    protected LocalDate date;

    // Constructor to initialize title
    public ListItem(String title, LocalDate date) {
        this.title = title;
        this.date = date;
    }

    // Abstract method used by subclasses
    public abstract void display();
    public abstract String prettyPrint();
    public abstract String toString();

    // Getter for title
    public String getTitle() {
        return title;
    }
}