import java.awt.BorderLayout;
import java.io.*;
import javax.swing.*;

public class ToDoList extends JFrame {
    private JTextField taskField;
    private DefaultListModel<String> taskListModel;
    private JList<String> taskList;

    private static String filePath = "tasks.txt";

    public ToDoList() {
        setTitle("To-Do List");
        setSize(600, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Input Panel
        JPanel inputPanel = new JPanel();
        taskField = new JTextField(20);
        JButton addButton = new JButton("Add Task");
        inputPanel.add(new JLabel("Task:"));
        inputPanel.add(taskField);
        inputPanel.add(addButton);

        // Task List
        taskListModel = new DefaultListModel<>();
        taskList = new JList<>(taskListModel);
        JScrollPane scrollPane = new JScrollPane(taskList);

        // Remove buttons
        JButton clearButton = new JButton("Clear All Tasks");
        JButton removeButton = new JButton("Remove Selected Task");

        // Remove panel
        JPanel removePanel = new JPanel();
        removePanel.add(removeButton);
        removePanel.add(clearButton);

        // Add componenets to frame
        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(removePanel, BorderLayout.SOUTH);

        // Load tasks from file
        loadTasksFromFile();

        // Event Listeners
        addButton.addActionListener(e -> {
            String task = taskField.getText().trim();
            if (!task.isEmpty()) {
                taskListModel.addElement(task);
                taskField.setText("");
                saveTasksToFile();
            }
        });

        clearButton.addActionListener(e -> {
            taskListModel.clear();
            saveTasksToFile();
        });

        removeButton.addActionListener(e -> {
            int selectedIndex = taskList.getSelectedIndex();
            if (selectedIndex != -1) {
                taskListModel.remove(selectedIndex);
                saveTasksToFile();
            }
        });
    }

    private void loadTasksFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                taskListModel.addElement(line);
            }
        } catch (IOException e) {
            System.out.println("No saved tasks found or failed to load.");
        }

    }

    private void saveTasksToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (int i = 0; i < taskListModel.size(); i++) {
                writer.write(taskListModel.getElementAt(i));
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Failed to save tasks: "+e.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ToDoList().setVisible(true));
    }
}