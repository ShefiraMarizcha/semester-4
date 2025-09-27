package com.example.bukutelepondigital;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.SQLException;
import java.util.List;

public class EditContactController {
    @FXML
    private TextField nameField;
    @FXML
    private TextField phoneField;
    @FXML
    private TextField photoPathField;

    private Contact contact;

    // Set kontak yang akan diedit
    public void setContact(Contact contact) {
        this.contact = contact;
        displayContactDetails();
    }

    // Menampilkan detail kontak yang akan diedit
    private void displayContactDetails() {
        if (contact != null) {
            nameField.setText(contact.getName());
            phoneField.setText(String.join(", ", contact.getPhoneNumbers())); // Menampilkan nomor telepon
            photoPathField.setText(contact.getPhotoPath()); // Menampilkan path foto
        }
    }

    // Tombol untuk menyimpan perubahan
    @FXML
    private void saveChanges(ActionEvent event) {
        // Ambil data yang diubah dari field
        contact.setName(nameField.getText());
        contact.setPhoneNumbers(List.of(phoneField.getText())); // Ubah sesuai format list nomor telepon
        contact.setPhotoPath(photoPathField.getText());

        // Perbarui data di database atau model
        ContactDAO contactDAO = new ContactDAO();
        try {
            contactDAO.updateContact(contact);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        // Tutup jendela edit
        Stage stage = (Stage) nameField.getScene().getWindow();
        stage.close();
    }
}
