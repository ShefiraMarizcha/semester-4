module org.example.modul62 {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.modul62 to javafx.fxml;
    exports org.example.modul62;
}