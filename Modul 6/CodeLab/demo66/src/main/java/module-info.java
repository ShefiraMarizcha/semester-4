module org.example.demo66 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens org.example.demo66 to javafx.fxml;
    exports org.example.demo66;
    exports com.example.demo;
    opens com.example.demo to javafx.fxml;
}