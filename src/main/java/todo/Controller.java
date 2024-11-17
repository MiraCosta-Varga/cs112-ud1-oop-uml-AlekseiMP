package src.main.java.todo;

import javafx.application.Platform;
// import javafx.beans.property.BooleanProperty;
// import javafx.beans.property.SimpleBooleanProperty;
// import javafx.beans.property.SimpleStringProperty;
// import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;

public class Controller {
    @FXML
    TextField nameField;

    @FXML
    TextField dateField;

    @FXML
    ComboBox<String> priorityChooser;

    @FXML
    TableView<Task> taskTable;

    // I'm still figuring out how FXML works with these objects,
    // so I am just creating a sample object that will later be
    // replaced with ListItem
    // public class Task {
    //     private StringProperty name = new SimpleStringProperty();
    //     private StringProperty date = new SimpleStringProperty();
    //     private StringProperty priority = new SimpleStringProperty();
    //     private BooleanProperty complete = new SimpleBooleanProperty();

    //     public Task(String name, String date, String priority, boolean complete) {
    //         this.name.set(name);
    //         this.date.set(date);
    //         this.priority.set(priority);
    //         this.complete.set(complete);
    //     }

    //     public String getName() {
    //         return this.name.get();
    //     }

    //     public String getDate() {
    //         return this.date.get();
    //     }

    //     public String getPriority() {
    //         return this.priority.get();
    //     }

    //     public boolean getComplete() {
    //         return this.complete.get();
    //     }
    // }

    @FXML
    public void addTask(ActionEvent ev) {
        // Adds a task on the "Add task" button press
        // Uses the data from the input fields, clearing them in the process

        ev.consume();
        String name = nameField.getText();
        String date = dateField.getText();
        String priority = priorityChooser.getValue();

        nameField.clear();
        dateField.clear();
        priorityChooser.setValue(null);

        Task newTask = new Task(name, date, priority);
        taskTable.getItems().add(newTask);
    }

    public void initialize() {
        // Initialize the table to read the proper values
        var columns = taskTable.getColumns();

        TableColumn<Task, ?> nameColumn = columns.get(0);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Task, ?> dateColumn = columns.get(1);
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));

        TableColumn<Task, ?> priorityColumn = columns.get(2);
        priorityColumn.setCellValueFactory(new PropertyValueFactory<>("priority"));

        TableColumn<Task, ?> completeColumn = columns.get(3);
        completeColumn.setCellValueFactory(new PropertyValueFactory<>("complete"));
        completeColumn.setCellFactory(tc -> new CheckBoxTableCell<>());
    }

    @FXML
    public void handleExit() {
        Platform.exit();
    }
}