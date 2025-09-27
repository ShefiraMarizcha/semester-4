package com.example.bukutelepondigital;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewContactController {
    @FXML
    private Label nameLabel;
    @FXML
    private Label phoneLabel;

    private Contact contact; // Menyimpan kontak yang dipilih

    // Set kontak yang dipilih untuk ditampilkan
    public void setContact(Contact contact) {
        this.contact = contact;
        displayContactDetails();
    }

    // Menampilkan detail kontak
    private void displayContactDetails() {
        if (contact != null) {
            nameLabel.setText(contact.getName());
            phoneLabel.setText(String.join(", ", contact.getPhoneNumbers()));
        }
    }

    // Metode untuk kembali ke MainView (misalnya tombol Back)
    @FXML
    private void goBack(ActionEvent event) {
        // Tutup current stage (ViewContact)
        Stage stage = (Stage) nameLabel.getScene().getWindow();
        stage.close();
    }

    // Metode untuk membuka form EditContact
    @FXML
    private void editContact(ActionEvent event) {
        try {
            // Memuat tampilan EditContact.fxml
            FXMLLoader loader = new FXMLLoader(getClass().getResource("EditContact.fxml"));
            Parent root = loader.load();

            // Mendapatkan controller untuk EditContact
            EditContactController controller = loader.getController();

            // Mengirimkan data kontak yang akan diedit ke controller EditContact
            controller.setContact(contact);

            // Menampilkan stage untuk EditContact
            Stage stage = new Stage();
            stage.setTitle("Edit Contact");
            stage.setScene(new Scene(root));
            stage.showAndWait(); // Tunggu sampai form EditContact ditutup

            // Setelah edit selesai, perbarui tampilan di ViewContact
            displayContactDetails();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
