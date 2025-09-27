package com.example.bukutelepondigital;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class MainController {

    @FXML
    private TextField searchField; // Untuk mencari kontak

    @FXML
    private ListView<Contact> contactListView; // Menampilkan daftar kontak

    @FXML
    private Button addButton; // Tombol untuk menambahkan kontak baru

    private ObservableList<Contact> contacts = FXCollections.observableArrayList(); // List untuk menyimpan data kontak

    private ContactDAO contactDAO = new ContactDAO(); // Objek untuk mengakses database

    // Inisialisasi data dan event handler
    public void initialize() {
        // Muat data kontak dari database
        loadContacts();

        // Filter daftar kontak berdasarkan input di search bar
        searchField.textProperty().addListener((observable, oldValue, newValue) -> filterContacts(newValue));

        // Handle klik dua kali untuk menampilkan detail kontak
        contactListView.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2) { // Klik dua kali
                showContactDetails();
            }
        });
    }

    // Metode untuk memuat kontak dari database
    public void loadContacts() {
        try {
            contacts.clear();
            contacts.addAll(contactDAO.getAllContacts());
            contactListView.setItems(contacts);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Metode untuk menyaring daftar kontak berdasarkan nama
    private void filterContacts(String query) {
        if (query == null || query.isEmpty()) {
            contactListView.setItems(contacts);
            return;
        }

        ObservableList<Contact> filteredContacts = FXCollections.observableArrayList();
        for (Contact contact : contacts) {
            if (contact.getName().toLowerCase().contains(query.toLowerCase())) {
                filteredContacts.add(contact);
            }
        }
        contactListView.setItems(filteredContacts);
    }

    // Metode untuk membuka form tambah kontak
    @FXML
    public void openAddContact(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AddContact.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setTitle("Add Contact");
            stage.setScene(new Scene(root));
            stage.showAndWait(); // Tunggu sampai form ditutup

            // Perbarui daftar kontak setelah form ditutup
            loadContacts();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Metode untuk membuka detail kontak
    private void showContactDetails() {
        // Ambil kontak yang dipilih
        Contact selectedContact = contactListView.getSelectionModel().getSelectedItem();

        if (selectedContact == null) {
            return; // Jika tidak ada kontak yang dipilih, keluar
        }

        // Lakukan sesuatu dengan kontak yang dipilih
        try {
            // Muat tampilan untuk melihat detail kontak
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ViewContact.fxml"));
            Parent root = loader.load();

            // Kirim data kontak ke controller ViewContactController
            ViewContactController controller = loader.getController();
            controller.setContact(selectedContact); // Mengirim kontak yang dipilih ke controller

            // Tampilkan jendela detail kontak
            Stage stage = new Stage();
            stage.setTitle("Contact Details");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
