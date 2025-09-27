module org.example.tugas_6 {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.tugas_6 to javafx.fxml;
    exports org.example.tugas_6;
}