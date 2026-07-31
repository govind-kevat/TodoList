import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class TodoList extends JFrame implements ActionListener {

    JTextField taskField;
    JButton addButton, deleteButton, clearButton;
    JList<String> taskList;
    DefaultListModel<String> model;

    TodoList() {
        setTitle("To-Do List");
        setSize(450, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel heading = new JLabel("TO-DO LIST");
        heading.setFont(new Font("Arial", Font.BOLD, 20));
        heading.setBounds(160, 15, 150, 30);
        add(heading);

        taskField = new JTextField();
        taskField.setBounds(30, 60, 250, 30);
        add(taskField);

        addButton = new JButton("Add");
        addButton.setBounds(300, 60, 100, 30);
        add(addButton);

        model = new DefaultListModel<>();
        taskList = new JList<>(model);

        JScrollPane scrollPane = new JScrollPane(taskList);
        scrollPane.setBounds(30, 110, 370, 170);
        add(scrollPane);

        deleteButton = new JButton("Delete");
        deleteButton.setBounds(70, 300, 120, 35);
        add(deleteButton);

        clearButton = new JButton("Clear All");
        clearButton.setBounds(230, 300, 120, 35);
        add(clearButton);

        addButton.addActionListener(this);
        deleteButton.addActionListener(this);
        clearButton.addActionListener(this);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == addButton) {
            String task = taskField.getText().trim();

            if (!task.isEmpty()) {
                model.addElement(task);
                taskField.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "Enter a task.");
            }
        }

        if (e.getSource() == deleteButton) {
            int index = taskList.getSelectedIndex();

            if (index != -1) {
                model.remove(index);
            } else {
                JOptionPane.showMessageDialog(this, "Select a task.");
            }
        }

        if (e.getSource() == clearButton) {
            model.clear();
        }
    }

    public static void main(String[] args) {
        new TodoList();
    }
}