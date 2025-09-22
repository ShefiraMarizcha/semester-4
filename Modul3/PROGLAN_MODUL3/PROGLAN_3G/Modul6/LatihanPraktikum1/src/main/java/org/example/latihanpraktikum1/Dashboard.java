package org.example.latihanpraktikum1;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard extends JFrame {

    private JPanel mainPanel;
    private JPanel displayPanel;
    private JTable contactTable;
    private JTextField searchField, firstNameField, lastNameField, locationField, phoneField;
    private DefaultTableModel tableModel;

    public Dashboard() {
        initComponents();
        setTitle("PHONE BOOK");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(400, 100, 900, 600);
        setVisible(true);
    }

    private void initComponents() {
        // Main Panel
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        // Title
        JLabel titleLabel = new JLabel("PHONE BOOK", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));
        mainPanel.add(titleLabel, BorderLayout.NORTH);

        // Contact Table
        String[] columns = {"FIRSTNAME", "LASTNAME", "LOCATION", "PHONE"};
        tableModel = new DefaultTableModel(columns, 0);
        contactTable = new JTable(tableModel);
        JScrollPane tableScrollPane = new JScrollPane(contactTable);
        mainPanel.add(tableScrollPane, BorderLayout.CENTER);

        // Control Panel
        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new GridLayout(2, 1));

        // Search Section
        JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        searchPanel.add(new JLabel("Search:"));
        searchField = new JTextField(20);
        searchPanel.add(searchField);
        controlPanel.add(searchPanel);

        // Detail Section
        JPanel detailPanel = new JPanel(new GridLayout(6, 2, 5, 5));

        detailPanel.add(new JLabel("First Name:"));
        firstNameField = new JTextField();
        detailPanel.add(firstNameField);

        detailPanel.add(new JLabel("Last Name:"));
        lastNameField = new JTextField();
        detailPanel.add(lastNameField);

        detailPanel.add(new JLabel("Location:"));
        locationField = new JTextField();
        detailPanel.add(locationField);

        detailPanel.add(new JLabel("Phone:"));
        phoneField = new JTextField();
        detailPanel.add(phoneField);

        JButton addButton = new JButton("Add");
        addButton.setBackground(Color.GREEN);
        addButton.addActionListener(new AddButtonListener());
        detailPanel.add(addButton);

        JButton editButton = new JButton("Edit");
        editButton.setBackground(Color.YELLOW);
        editButton.addActionListener(new EditButtonListener());
        detailPanel.add(editButton);

        JButton deleteButton = new JButton("Delete");
        deleteButton.setBackground(Color.RED);
        deleteButton.addActionListener(new DeleteButtonListener());
        detailPanel.add(deleteButton);

        JButton clearButton = new JButton("Clear");
        clearButton.setBackground(Color.CYAN);
        clearButton.addActionListener(e -> clearFields());
        detailPanel.add(clearButton);

        controlPanel.add(detailPanel);
        mainPanel.add(controlPanel, BorderLayout.SOUTH);

        add(mainPanel);
    }

    private class AddButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String firstName = firstNameField.getText();
            String lastName = lastNameField.getText();
            String location = locationField.getText();
            String phone = phoneField.getText();

            if (!firstName.isEmpty() && !phone.isEmpty()) {
                tableModel.addRow(new Object[]{firstName, lastName, location, phone});
                clearFields();
            } else {
                JOptionPane.showMessageDialog(null, "First Name and Phone are required!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private class EditButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int selectedRow = contactTable.getSelectedRow();
            if (selectedRow >= 0) {
                tableModel.setValueAt(firstNameField.getText(), selectedRow, 0);
                tableModel.setValueAt(lastNameField.getText(), selectedRow, 1);
                tableModel.setValueAt(locationField.getText(), selectedRow, 2);
                tableModel.setValueAt(phoneField.getText(), selectedRow, 3);
                clearFields();
            } else {
                JOptionPane.showMessageDialog(null, "Select a row to edit!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private class DeleteButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int selectedRow = contactTable.getSelectedRow();
            if (selectedRow >= 0) {
                tableModel.removeRow(selectedRow);
                clearFields();
            } else {
                JOptionPane.showMessageDialog(null, "Select a row to delete!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void clearFields() {
        firstNameField.setText("");
        lastNameField.setText("");
        locationField.setText("");
        phoneField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Dashboard::new);
    }
}
