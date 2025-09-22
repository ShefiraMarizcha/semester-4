package org.example.bukutelepondigital;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;

public class DigitalPhoneBook {
    // Data storage (in-memory for simplicity)
    private static DefaultListModel<String> contactsList = new DefaultListModel<>();

    public static void main(String[] args) {
        new MainMenu(); // Start the main menu
    }

    // Main Menu (Menu Utama)
    static class MainMenu {
        public MainMenu() {
            JFrame frame = new JFrame("Buku Telepon Digital");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 300);
            frame.setLayout(new BorderLayout());

            JLabel appName = new JLabel("Buku Telepon Digital", JLabel.CENTER);
            appName.setFont(new Font("Arial", Font.BOLD, 24));
            frame.add(appName, BorderLayout.NORTH);

            JPanel buttonPanel = new JPanel();
            buttonPanel.setLayout(new GridLayout(2, 1));

            JButton addButton = new JButton("Tambah Kontak");
            JButton viewButton = new JButton("Lihat Kontak");
            buttonPanel.add(addButton);
            buttonPanel.add(viewButton);
            frame.add(buttonPanel, BorderLayout.CENTER);

            addButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new AddContactMenu(frame);  // Open Add Contact Menu
                }
            });

            viewButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new ViewContactsMenu(frame);  // Open View Contacts Menu
                }
            });

            frame.setVisible(true);
        }
    }

    // Add Contact Menu (Menu Tambah Kontak)
    static class AddContactMenu {
        private JTextField nameField, phoneField;
        private JFrame frame;
        private JLabel imageLabel;
        private String imagePath = null;

        public AddContactMenu(JFrame parentFrame) {
            frame = new JFrame("Tambah Kontak");
            frame.setSize(400, 300);
            frame.setLayout(new BorderLayout());

            JLabel title = new JLabel("Tambah Kontak", JLabel.CENTER);
            title.setFont(new Font("Arial", Font.BOLD, 20));
            frame.add(title, BorderLayout.NORTH);

            JPanel formPanel = new JPanel();
            formPanel.setLayout(new GridLayout(3, 2));

            JLabel nameLabel = new JLabel("Nama:");
            nameField = new JTextField(10);
            JLabel phoneLabel = new JLabel("Nomor:");
            phoneField = new JTextField(12);

            formPanel.add(nameLabel);
            formPanel.add(nameField);
            formPanel.add(phoneLabel);
            formPanel.add(phoneField);

            frame.add(formPanel, BorderLayout.CENTER);

            // Input gambar
            JPanel imagePanel = new JPanel();
            JButton selectImageButton = new JButton("Pilih Gambar");
            imageLabel = new JLabel("No image selected", JLabel.CENTER);
            imagePanel.add(selectImageButton);
            imagePanel.add(imageLabel);
            frame.add(imagePanel, BorderLayout.SOUTH);

            // Tombol pilih gambar
            selectImageButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JFileChooser fileChooser = new JFileChooser();
                    fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Image Files", "jpg", "png", "jpeg"));
                    int result = fileChooser.showOpenDialog(frame);
                    if (result == JFileChooser.APPROVE_OPTION) {
                        File selectedFile = fileChooser.getSelectedFile();
                        imagePath = selectedFile.getAbsolutePath();
                        imageLabel.setText("Gambar terpilih: " + selectedFile.getName());
                    }
                }
            });

            JPanel buttonPanel = new JPanel();
            JButton backButton = new JButton("Back");
            JButton saveButton = new JButton("Simpan");
            buttonPanel.add(backButton);
            buttonPanel.add(saveButton);
            frame.add(buttonPanel, BorderLayout.SOUTH);

            backButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    frame.dispose();
                    parentFrame.setVisible(true);  // Return to Main Menu
                }
            });

            saveButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String name = nameField.getText();
                    String phone = phoneField.getText();

                    if (isValidInput(name, phone)) {
                        String contact = name + " - " + phone;
                        if (imagePath != null) {
                            contact += " - Gambar: " + imagePath;
                        } else {
                            contact += " - Gambar: Tidak ada";
                        }
                        contactsList.addElement(contact);
                        JOptionPane.showMessageDialog(frame, "Kontak berhasil disimpan!");
                        frame.dispose();
                        new ViewContactsMenu(parentFrame);  // Show contacts list
                    } else {
                        JOptionPane.showMessageDialog(frame, "Input tidak valid! Nama hanya boleh huruf a-z dan maksimal 10 karakter. Nomor harus dimulai dengan '08' dan maksimal 12 digit.");
                    }
                }
            });

            frame.setVisible(true);
        }

        private boolean isValidInput(String name, String phone) {
            // Check if name contains only letters and is at most 10 characters long
            if (!name.matches("[a-zA-Z]{1,10}")) {
                return false;
            }

            // Check if phone starts with '08' and is at most 12 digits long
            if (!phone.matches("08\\d{10}")) {
                return false;
            }

            return true;
        }
    }

    // View Contacts Menu (Menu Lihat Kontak)
    static class ViewContactsMenu {
        public ViewContactsMenu(JFrame parentFrame) {
            JFrame frame = new JFrame("Daftar Kontak");
            frame.setSize(400, 300);
            frame.setLayout(new BorderLayout());

            JLabel title = new JLabel("Daftar Kontak", JLabel.CENTER);
            title.setFont(new Font("Arial", Font.BOLD, 20));
            frame.add(title, BorderLayout.NORTH);

            JList<String> contactList = new JList<>(contactsList);
            JScrollPane scrollPane = new JScrollPane(contactList);
            frame.add(scrollPane, BorderLayout.CENTER);

            JButton backButton = new JButton("Back");
            frame.add(backButton, BorderLayout.SOUTH);

            backButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    frame.dispose();
                    parentFrame.setVisible(true);  // Return to Main Menu
                }
            });

            contactList.addListSelectionListener(e -> {
                if (!e.getValueIsAdjusting()) {
                    String selectedContact = contactList.getSelectedValue();
                    new ModifyContactMenu(frame, selectedContact);  // Modify selected contact
                }
            });

            frame.setVisible(true);
        }
    }

    // Modify Contact Menu (Menu Modifikasi Kontak)
    static class ModifyContactMenu {
        private JTextField nameField, phoneField;
        private String originalContact;
        private JFrame frame;

        public ModifyContactMenu(JFrame parentFrame, String selectedContact) {
            frame = new JFrame("Modifikasi Kontak");
            frame.setSize(400, 300);
            frame.setLayout(new BorderLayout());

            originalContact = selectedContact;

            JLabel title = new JLabel("Modifikasi Kontak", JLabel.CENTER);
            title.setFont(new Font("Arial", Font.BOLD, 20));
            frame.add(title, BorderLayout.NORTH);

            JPanel formPanel = new JPanel();
            formPanel.setLayout(new GridLayout(3, 2));

            JLabel nameLabel = new JLabel("Nama:");
            nameField = new JTextField(10);
            JLabel phoneLabel = new JLabel("Nomor:");
            phoneField = new JTextField(12);

            String[] contactParts = selectedContact.split(" - ");
            nameField.setText(contactParts[0]);
            phoneField.setText(contactParts[1]);

            formPanel.add(nameLabel);
            formPanel.add(nameField);
            formPanel.add(phoneLabel);
            formPanel.add(phoneField);

            frame.add(formPanel, BorderLayout.CENTER);

            JPanel buttonPanel = new JPanel();
            JButton deleteButton = new JButton("Hapus");
            JButton saveButton = new JButton("Simpan");
            buttonPanel.add(deleteButton);
            buttonPanel.add(saveButton);
            frame.add(buttonPanel, BorderLayout.SOUTH);

            deleteButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    contactsList.removeElement(selectedContact);
                    JOptionPane.showMessageDialog(frame, "Kontak dihapus!");
                    frame.dispose();
                    parentFrame.setVisible(true);  // Return to contacts view
                }
            });

            saveButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String name = nameField.getText();
                    String phone = phoneField.getText();

                    if (isValidInput(name, phone)) {
                        contactsList.setElementAt(name + " - " + phone, contactsList.indexOf(selectedContact));
                        JOptionPane.showMessageDialog(frame, "Kontak berhasil disimpan!");
                        frame.dispose();
                        parentFrame.setVisible(true);  // Return to contacts view
                    } else {
                        JOptionPane.showMessageDialog(frame, "Input tidak valid! Nama hanya boleh huruf a-z dan maksimal 10 karakter. Nomor harus dimulai dengan '08' dan maksimal 12 digit.");
                    }
                }
            });

            frame.setVisible(true);
        }

        private boolean isValidInput(String name, String phone) {
            // Check if name contains only letters and is at most 10 characters long
            if (!name.matches("[a-zA-Z]{1,10}")) {
                return false;
            }

            // Check if phone starts with '08' and is at most 12 digits long
            if (!phone.matches("08\\d{10}")) {
                return false;
            }

            return true;
        }
    }
}
