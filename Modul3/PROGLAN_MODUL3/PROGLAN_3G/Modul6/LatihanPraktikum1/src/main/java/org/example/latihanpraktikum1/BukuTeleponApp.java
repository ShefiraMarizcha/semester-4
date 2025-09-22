package org.example.latihanpraktikum1;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.ArrayList;

public class BukuTeleponApp extends Application {

    private ArrayList<Kontak> kontakList = new ArrayList<>();

    private Stage window;
    private Scene mainMenuScene, tambahKontakScene, lihatKontakScene;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;

        // Menu Utama
        VBox mainMenuLayout = new VBox(20);
        mainMenuLayout.setAlignment(Pos.CENTER);
        Button btnTambahKontak = new Button("Tambah Kontak");
        Button btnLihatKontak = new Button("Lihat Kontak");

        btnTambahKontak.setOnAction(e -> window.setScene(tambahKontakScene));
        btnLihatKontak.setOnAction(e -> window.setScene(lihatKontakScene));

        mainMenuLayout.getChildren().addAll(new Label("Buku Telepon Digital"), btnTambahKontak, btnLihatKontak);
        mainMenuScene = new Scene(mainMenuLayout, 400, 300);

        // Menu Tambah Kontak
        VBox tambahKontakLayout = new VBox(20);
        tambahKontakLayout.setAlignment(Pos.CENTER);

        TextField tfNama = new TextField();
        tfNama.setPromptText("Nama");
        TextField tfNomor = new TextField();
        tfNomor.setPromptText("Nomor");

        Button btnSimpan = new Button("Simpan");
        Button btnBackTambah = new Button("Back");

        btnBackTambah.setOnAction(e -> window.setScene(mainMenuScene));

        btnSimpan.setOnAction(e -> {
            String nama = tfNama.getText();
            String nomor = tfNomor.getText();

            if (!nama.matches("[a-zA-Z]{1,10}")) {
                showError("Nama hanya boleh huruf dan maksimal 10 karakter");
                return;
            }

            if (!nomor.matches("08\\d{10}")) {
                showError("Nomor harus dimulai dengan '08' dan 12 digit");
                return;
            }

            kontakList.add(new Kontak(nama, nomor));
            tfNama.clear();
            tfNomor.clear();
            showInfo("Kontak berhasil disimpan");
        });

        tambahKontakLayout.getChildren().addAll(new Label("Tambah Kontak"), tfNama, tfNomor, btnSimpan, btnBackTambah);
        tambahKontakScene = new Scene(tambahKontakLayout, 400, 300);

        // Menu Lihat Kontak
        VBox lihatKontakLayout = new VBox(10);
        lihatKontakLayout.setAlignment(Pos.CENTER);

        Button btnBackLihat = new Button("Back");
        btnBackLihat.setOnAction(e -> window.setScene(mainMenuScene));

        ListView<String> listView = new ListView<>();
        for (Kontak kontak : kontakList) {
            listView.getItems().add(kontak.getNama() + " - " + kontak.getNomor());
        }

        lihatKontakLayout.getChildren().addAll(new Label("Daftar Kontak"), listView, btnBackLihat);
        lihatKontakScene = new Scene(lihatKontakLayout, 400, 300);

        window.setTitle("Buku Telepon Digital");
        window.setScene(mainMenuScene);
        window.show();
    }

    private void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void showInfo(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Info");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public class Kontak {
        private String nama;
        private String nomor;

        public Kontak(String nama, String nomor) {
            this.nama = nama;
            this.nomor = nomor;
        }

        public String getNama() {
            return nama;
        }

        public String getNomor() {
            return nomor;
        }
    }
}
