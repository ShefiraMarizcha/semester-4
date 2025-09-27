package main;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

    public class LibrarySystem extends Application {
        @Override
        public void start(Stage primaryStage) {
            primaryStage.setTitle("Library System");

            Button adminButton = new Button("Login as Admin");
            adminButton.setOnAction(e -> showAdminLogin());

            Button studentButton = new Button("Login as Student");
            studentButton.setOnAction(e -> showStudentLogin());

            VBox layout = new VBox(10);
            layout.getChildren().addAll(adminButton, studentButton);

            Scene scene = new Scene(layout, 300, 200);
            primaryStage.setScene(scene);
            primaryStage.show();
        }

        private void showAdminLogin() {
            // Implement the admin login UI here
        }

        private void showStudentLogin() {
            // Implement the student login UI here
        }

        public static void main(String[] args) {
            launch(args);
        }
    }


