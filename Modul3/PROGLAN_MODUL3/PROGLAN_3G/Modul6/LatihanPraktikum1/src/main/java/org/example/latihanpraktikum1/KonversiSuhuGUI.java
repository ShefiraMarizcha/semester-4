package org.example.latihanpraktikum1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class KonversiSuhuGUI extends JFrame {

    // Komponen GUI
    private final JTextField inputField;
    private final JTextField outputField;
    private final JComboBox<String> fromTemperature;
    private final JComboBox<String> toTemperature;
    private final JButton convertButton;
    private final JButton clearButton;

    public KonversiSuhuGUI() {
        // Pengaturan frame
        setTitle("Kalkulator Konversi Suhu");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5, 2, 10, 10));
        getContentPane().setBackground(Color.BLACK);  // Set background frame to black

        // Inisialisasi komponen
        JLabel inputLabel = new JLabel("Masukkan Suhu:");
        inputLabel.setForeground(Color.WHITE); // Set label text color to white
        inputField = new JTextField();

        JLabel fromLabel = new JLabel("Dari Suhu:");
        fromLabel.setForeground(Color.WHITE); // Set label text color to white
        fromTemperature = new JComboBox<>(new String[]{
                "Celcius", "Fahrenheit", "Kelvin"
        });

        JLabel toLabel = new JLabel("Ke Suhu:");
        toLabel.setForeground(Color.WHITE); // Set label text color to white
        toTemperature = new JComboBox<>(new String[]{
                "Celcius", "Fahrenheit", "Kelvin"
        });

        JLabel outputLabel = new JLabel("Hasil Konversi:");
        outputLabel.setForeground(Color.WHITE); // Set label text color to white
        outputField = new JTextField();
        outputField.setEditable(false);

        convertButton = new JButton("Konversi");
        clearButton = new JButton("Clear");

        // Set button background and text color
        convertButton.setBackground(Color.GRAY);
        convertButton.setForeground(Color.WHITE);
        clearButton.setBackground(Color.GRAY);
        clearButton.setForeground(Color.WHITE);

        // Tambahkan action listener
        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performConversion();
            }
        });

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearFields();
            }
        });

        // Tambahkan komponen ke frame
        add(inputLabel);
        add(inputField);
        add(fromLabel);
        add(fromTemperature);
        add(toLabel);
        add(toTemperature);
        add(outputLabel);
        add(outputField);
        add(convertButton);
        add(clearButton);

        // Tampilkan frame
        setVisible(true);
    }

    private void performConversion() {
        String inputText = inputField.getText().trim();

        // Validasi input
        if (inputText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Input suhu tidak boleh kosong!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Pastikan suhu asal dan suhu tujuan tidak sama
        if (fromTemperature.getSelectedItem().equals(toTemperature.getSelectedItem())) {
            // Jika sama, pilih suhu tujuan secara acak
            changeToRandomTemperature();
        }

        try {
            double inputValue = Double.parseDouble(inputText);
            String from = (String) fromTemperature.getSelectedItem();
            String to = (String) toTemperature.getSelectedItem();
            double result = 0;

            // Proses konversi berdasarkan suhu asal dan suhu tujuan
            if (from.equals("Celcius") && to.equals("Fahrenheit")) {
                result = inputValue * 1.8 + 32;
            } else if (from.equals("Fahrenheit") && to.equals("Celcius")) {
                result = (inputValue - 32) / 1.8;
            } else if (from.equals("Celcius") && to.equals("Kelvin")) {
                result = inputValue + 273.15;
            } else if (from.equals("Kelvin") && to.equals("Celcius")) {
                result = inputValue - 273.15;
            } else if (from.equals("Fahrenheit") && to.equals("Kelvin")) {
                result = (inputValue - 32) / 1.8 + 273.15;
            } else if (from.equals("Kelvin") && to.equals("Fahrenheit")) {
                result = (inputValue - 273.15) * 1.8 + 32;
            }

            outputField.setText(String.format("%.2f", result));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Input harus berupa angka yang valid!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void changeToRandomTemperature() {
        // Pilih suhu tujuan secara acak
        String[] temperatures = {"Celcius", "Fahrenheit", "Kelvin"};
        Random rand = new Random();
        String randomTemp;
        do {
            randomTemp = temperatures[rand.nextInt(3)];
        } while (randomTemp.equals(fromTemperature.getSelectedItem()));  // Pastikan suhu tujuan tidak sama dengan suhu asal
        toTemperature.setSelectedItem(randomTemp);
    }

    private void clearFields() {
        inputField.setText("");
        outputField.setText("");
        fromTemperature.setSelectedIndex(0);
        toTemperature.setSelectedIndex(0);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(KonversiSuhuGUI::new);
    }
}
