package com.main;

import data.User;
import exception.custom.IllegalAdminAccess;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.regex.Pattern;

public class SelfReturnHub extends Application {
    private LibrarySystem librarySystem = new LibrarySystem();

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Self Return Hub");


        // Title
        Label titleLabel = new Label("Self Return Hub");
        titleLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");

        // Login Screen
        Label userLabel = new Label("Username :");
        userLabel.setStyle("-fx-font-size: 16px;");
        TextField userField = new TextField();
        Label passLabel = new Label("Password :");
        passLabel.setStyle("-fx-font-size: 16px;");
        PasswordField passField = new PasswordField();
        Button loginButton = new Button("Login");
        loginButton.setStyle("-fx-font-size: 16px;");
        Label loginMessage = new Label();
        loginMessage.setStyle("-fx-font-size: 14px;");

        GridPane loginGrid = new GridPane();
        loginGrid.setPadding(new Insets(10, 10, 10, 10));
        loginGrid.setVgap(8);
        loginGrid.setHgap(10);
        loginGrid.add(userLabel, 0, 0);
        loginGrid.add(userField, 1, 0);
        loginGrid.add(passLabel, 0, 1);
        loginGrid.add(passField, 1, 1);
        loginGrid.add(loginButton, 1, 2);
        loginGrid.add(loginMessage, 1, 3);

        VBox loginLayout = new VBox(10, titleLabel, loginGrid);
        loginLayout.setPadding(new Insets(20, 20, 20, 20));

        Scene loginScene = new Scene(loginLayout, 1360, 720);

        // Main Application Screen
        Label bookIdLabel = new Label("Masukkan ID Buku untuk Pengembalian:");
        bookIdLabel.setStyle("-fx-font-size: 16px;");
        TextField bookIdField = new TextField();
        Button returnButton = new Button("Kembalikan Buku");
        returnButton.setStyle("-fx-font-size: 16px;");
        Label resultLabel = new Label();
        resultLabel.setStyle("-fx-font-size: 14px;");
        Label borrowedBooksLabel = new Label("Daftar Buku yang Dipinjam:");
        borrowedBooksLabel.setStyle("-fx-font-size: 16px;");
        ListView<String> borrowedBooksList = new ListView<>();
        Label returnedBooksLabel = new Label("Daftar Buku yang Dikembalikan:");
        returnedBooksLabel.setStyle("-fx-font-size: 16px;");
        ListView<String> returnedBooksList = new ListView<>();

        returnButton.setOnAction(e -> {
            String bookId = bookIdField.getText();
            if (bookId.isEmpty()) {
                resultLabel.setText("ID Buku tidak boleh kosong.");
                resultLabel.setStyle("-fx-text-fill: red;");
            } else {
                boolean isReturned = librarySystem.returnBook(bookId);
                if (isReturned) {
                    resultLabel.setText("Buku dengan ID " + bookId + " berhasil dikembalikan.");
                    resultLabel.setStyle("-fx-text-fill: green;");
                    borrowedBooksList.getItems().remove(bookId);
                    returnedBooksList.getItems().add(bookId);
                } else {
                    resultLabel.setText("Gagal mengembalikan buku. ID Buku tidak ditemukan.");
                    resultLabel.setStyle("-fx-text-fill: red;");
                }
            }
        });

        VBox mainLayout = new VBox(10, bookIdLabel, bookIdField, returnButton, resultLabel, borrowedBooksLabel, borrowedBooksList, returnedBooksLabel, returnedBooksList);
        mainLayout.setPadding(new Insets(20, 20, 20, 20));

        Scene mainScene = new Scene(mainLayout, 400, 400);

        // Handle Login Button Action
        loginButton.setOnAction(e -> {
            String username = userField.getText();
            String password = passField.getText();
            try {
                if (validateLogin(username, password)) {
                    primaryStage.setScene(mainScene);
                    updateBookLists(borrowedBooksList, returnedBooksList);
                }
            } catch (IllegalAdminAccess ex) {
                loginMessage.setText(ex.getMessage());
                loginMessage.setStyle("-fx-text-fill: red; -fx-font-size: 14px;");
            }
        });

        primaryStage.setScene(loginScene);
        primaryStage.show();
    }

    private boolean validateLogin(String username, String password) throws IllegalAdminAccess {
        if (!Pattern.matches("\\d{15}", username) || !Pattern.matches("\\d{8}", password)) {
            throw new IllegalAdminAccess("Access Denied: Invalid username or password format.");
        }
        // Any user with valid username and password format can log in
        return true;
    }

    private void updateBookLists(ListView<String> borrowedBooksList, ListView<String> returnedBooksList) {
        borrowedBooksList.getItems().clear();
        borrowedBooksList.getItems().addAll(librarySystem.getBorrowedBooks().keySet());
        returnedBooksList.getItems().clear();
        returnedBooksList.getItems().addAll(librarySystem.getReturnedBooks().keySet());
    }

    public static void main(String[] args) {
        launch(args);
    }
}
