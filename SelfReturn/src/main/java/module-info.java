module SelfReturnHub {
    requires javafx.controls;
    requires javafx.fxml;

    exports books;
    exports com.main;
    exports data;
    exports exception.custom;
    exports util;

    opens com.main to javafx.graphics, javafx.fxml;
}
