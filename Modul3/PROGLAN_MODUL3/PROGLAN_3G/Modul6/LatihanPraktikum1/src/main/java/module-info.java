module org.example.latihanpraktikum1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.scripting;


    opens org.example.latihanpraktikum1 to javafx.fxml;
    exports org.example.latihanpraktikum1;
}