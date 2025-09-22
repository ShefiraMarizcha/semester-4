module org.example.bukutelepondigital {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.bukutelepondigital to javafx.fxml;
    exports org.example.bukutelepondigital;
}