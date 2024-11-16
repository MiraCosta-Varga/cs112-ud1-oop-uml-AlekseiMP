/**
 * ToDoList GUI
 *
 * @author Aleksei Meritt-Powell
 */
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToDoListGUI extends JFrame {
    private JTextField taskNameField;
    private JTextField dueDateField;
    private JComboBox<String> priorityDropdown;
    private DefaultTableModel tableModel;

    public ToDoListGUI() {
        // Set up the frame
        setTitle("To-Do List Manager");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Initialize Components
        initializeComponents();
    }

    private void initializeComponents() {
        // Input Panel
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(3, 2));

        inputPanel.add(new JLabel("Task Name:"));
        taskNameField = new JTextField();
        inputPanel.add(taskNameField);

        inputPanel.add(new JLabel("Due Date (YYYY-MM-DD):"));
        dueDateField = new JTextField();
        inputPanel.add(dueDateField);

        inputPanel.add(new JLabel("Priority:"));
        String[] priorities = {"Low", "Medium", "High"};
        priorityDropdown = new JComboBox<>(priorities);
        inputPanel.add(priorityDropdown);

        add(inputPanel, BorderLayout.NORTH);

        // Button Panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        JButton addTaskButton = new JButton("Add Task");
        JButton markCompleteButton = new JButton("Mark Complete");
        JButton removeTaskButton = new JButton("Remove Task");

        buttonPanel.add(addTaskButton);
        buttonPanel.add(markCompleteButton);
        buttonPanel.add(removeTaskButton);

        add(buttonPanel, BorderLayout.SOUTH);

        // Table for Task Display
        String[] columnNames = {"Task Name", "Due Date", "Priority", "Status"};
        tableModel = new DefaultTableModel(columnNames, 0); // No rows initially
        JTable taskTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(taskTable);

        add(scrollPane, BorderLayout.CENTER);

        // Button Actions
        addTaskButton.addActionListener(new AddTaskListener());
        markCompleteButton.addActionListener(new MarkCompleteListener(taskTable));
        removeTaskButton.addActionListener(new RemoveTaskListener(taskTable));
    }

    // Action Listener for "Add Task"
    private class AddTaskListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String taskName = taskNameField.getText();
            String dueDate = dueDateField.getText();
            String priority = (String) priorityDropdown.getSelectedItem();

            if (taskName.isEmpty() || dueDate.isEmpty()) {
                JOptionPane.showMessageDialog(ToDoListGUI.this, "Task Name and Due Date are required.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Add task to the table
            tableModel.addRow(new Object[]{taskName, dueDate, priority, "Incomplete"});
            taskNameField.setText("");
            dueDateField.setText("");
            priorityDropdown.setSelectedIndex(0);
        }
    }

    // Action Listener for "Mark Complete"
    private class MarkCompleteListener implements ActionListener {
        private JTable taskTable;

        public MarkCompleteListener(JTable taskTable) {
            this.taskTable = taskTable;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            int selectedRow = taskTable.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(ToDoListGUI.this, "Please select a task to mark complete.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            tableModel.setValueAt("Complete", selectedRow, 3); // Update "Status" column
        }
    }

    // Action Listener for "Remove Task"
    private class RemoveTaskListener implements ActionListener {
        private JTable taskTable;

        public RemoveTaskListener(JTable taskTable) {
            this.taskTable = taskTable;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            int selectedRow = taskTable.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(ToDoListGUI.this, "Please select a task to remove.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            tableModel.removeRow(selectedRow);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ToDoListGUI gui = new ToDoListGUI();
            gui.setVisible(true);
        });
    }
}
