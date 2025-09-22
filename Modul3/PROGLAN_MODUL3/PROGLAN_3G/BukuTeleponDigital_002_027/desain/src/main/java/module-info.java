module org.example.desain {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.desain to javafx.fxml;
    exports org.example.desain;
}