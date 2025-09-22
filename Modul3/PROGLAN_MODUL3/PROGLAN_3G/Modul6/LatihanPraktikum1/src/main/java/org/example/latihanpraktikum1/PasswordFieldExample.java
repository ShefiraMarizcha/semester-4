package org.example.latihanpraktikum1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PasswordFieldExample {
    public static void main(String[] args) {
        // Judul JFrame
        String title = "Contoh Password Field";

        // Membuat JFrame
        JFrame frame = new JFrame(title);
        frame.setSize(400, 200); // Ukuran JFrame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout()); // Tata letak FlowLayout

        // Menambahkan Komponen Password Field
        JLabel label = new JLabel("Masukkan Kata Sandi:");
        JPasswordField passwordField = new JPasswordField(15); // Lebar kolom password field
        JButton button = new JButton("Validasi Password");
        JLabel resultLabel = new JLabel("Password akan divalidasi di sini.");

        // Menambahkan komponen ke JFrame
        frame.add(label);
        frame.add(passwordField);
        frame.add(button);
        frame.add(resultLabel);

        // Menambahkan ActionListener untuk tombol validasi
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Mengambil password dari JPasswordField
                char[] password = passwordField.getPassword();
                String passwordText = new String(password); // Mengubah char[] menjadi String

                // Validasi password
                if (passwordText.length() < 7) {
                    JOptionPane.showMessageDialog(frame, "Password tidak valid. Minimal 7 karakter.");
                } else if (!passwordText.matches(".*[A-Z].*")) {
                    JOptionPane.showMessageDialog(frame, "Password tidak valid. Harus mengandung huruf besar.");
                } else if (!passwordText.matches(".*[a-z].*")) {
                    JOptionPane.showMessageDialog(frame, "Password tidak valid. Harus mengandung huruf kecil.");
                } else if (!passwordText.matches(".*[0-9].*")) {
                    JOptionPane.showMessageDialog(frame, "Password tidak valid. Harus mengandung angka.");
                } else {
                    JOptionPane.showMessageDialog(frame, "Password Valid");
                    resultLabel.setText("Password Anda valid.");
                }
            }
        });

        // Menampilkan JFrame
        frame.setVisible(true);
    }
}
