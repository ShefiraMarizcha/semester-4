import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class LoginForm {
    private static Map<String, String> users = new HashMap<>();

    public static void main(String[] args) {
        // Adding a sample user to the users map
        users.put("adit", "password");

        // Create the login frame
        JFrame loginFrame = new JFrame("Form Login");
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginFrame.setSize(300, 200);

        // Create the login panel
        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(new BoxLayout(loginPanel, BoxLayout.Y_AXIS));
        loginFrame.add(loginPanel);
        placeComponents(loginPanel);

        // Display the frame
        loginFrame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {
        // Create user label
        JLabel userLabel = new JLabel("User Name:");
        userLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        panel.add(userLabel);

        // Create user text field
        JTextField userText = new JTextField(20);
        userText.setMaximumSize(userText.getPreferredSize());
        userText.setAlignmentX(JTextField.CENTER_ALIGNMENT);
        panel.add(userText);

        // Create password label
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        panel.add(passwordLabel);

        // Create password text field
        JPasswordField passwordText = new JPasswordField(20);
        passwordText.setMaximumSize(passwordText.getPreferredSize());
        passwordText.setAlignmentX(JPasswordField.CENTER_ALIGNMENT);
        panel.add(passwordText);

        // Create login button
        JButton loginButton = new JButton("Sign in");
        loginButton.setAlignmentX(JButton.CENTER_ALIGNMENT);
        panel.add(loginButton);

        // Create message label
        JLabel messageLabel = new JLabel();
        messageLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        panel.add(messageLabel);

        // Add action listener to the login button
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userName = userText.getText();
                String password = new String(passwordText.getPassword());

                if (users.containsKey(userName) && users.get(userName).equals(password)) {
                    // If login is successful, open a new frame
                    JFrame welcomeFrame = new JFrame("Form 2");
                    welcomeFrame.setSize(300, 200);
                    JPanel welcomePanel = new JPanel();
                    welcomePanel.setLayout(new BoxLayout(welcomePanel, BoxLayout.Y_AXIS));
                    welcomeFrame.add(welcomePanel);
                    placeWelcomeComponents(welcomePanel, userName);
                    welcomeFrame.setVisible(true);

                    // Close the login frame
                    JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(panel);
                    topFrame.dispose();
                } else {
                    // If login fails, show error message
                    messageLabel.setText("Password Atau Username Salah");
                }
            }
        });
    }

    private static void placeWelcomeComponents(JPanel panel, String userName) {
        // Create welcome label
        JLabel welcomeLabel = new JLabel("Halo " + userName);
        welcomeLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        panel.add(welcomeLabel);

        // Create back button
        JButton backButton = new JButton("Kembali");
        backButton.setAlignmentX(JButton.CENTER_ALIGNMENT);
        panel.add(backButton);

        // Add action listener to the back button
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Close the welcome frame
                JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(panel);
                topFrame.dispose();

                // Reopen the login frame
                JFrame loginFrame = new JFrame("Form Login");
                loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                loginFrame.setSize(300, 200);
                JPanel loginPanel = new JPanel();
                loginPanel.setLayout(new BoxLayout(loginPanel, BoxLayout.Y_AXIS));
                loginFrame.add(loginPanel);
                placeComponents(loginPanel);
                loginFrame.setVisible(true);
            }
        });
    }
}
