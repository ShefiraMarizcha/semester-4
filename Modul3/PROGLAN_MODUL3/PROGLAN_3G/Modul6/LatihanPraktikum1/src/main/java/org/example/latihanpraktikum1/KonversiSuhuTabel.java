package org.example.latihanpraktikum1;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class KonversiSuhuTabel extends JFrame {

    private final JTextField inputField;
    private final JComboBox<String> fromTemperature;
    private final JComboBox<String> toTemperature;
    private final JButton convertButton;
    private final JButton clearButton;

    private final JTable resultTable;
    private final DefaultTableModel tableModel;

    public KonversiSuhuTabel() {
        // Pengaturan frame
        setTitle("Konversi Suhu dengan Tabel");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Panel input
        JPanel inputPanel = new JPanel(new GridLayout(5, 2, 10, 10));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        inputPanel.setBackground(Color.GRAY);

        JLabel inputLabel = new JLabel("Masukkan Suhu:");
        inputLabel.setForeground(Color.WHITE);
        inputField = new JTextField();

        JLabel fromLabel = new JLabel("Dari Suhu:");
        fromLabel.setForeground(Color.WHITE);
        fromTemperature = new JComboBox<>(new String[]{"Celcius", "Fahrenheit", "Kelvin"});

        JLabel toLabel = new JLabel("Ke Suhu:");
        toLabel.setForeground(Color.WHITE);
        toTemperature = new JComboBox<>(new String[]{"Celcius", "Fahrenheit", "Kelvin"});

        convertButton = new JButton("Konversi");
        clearButton = new JButton("Clear");

        convertButton.setBackground(Color.GRAY);
        convertButton.setForeground(Color.WHITE);
        clearButton.setBackground(Color.GRAY);
        clearButton.setForeground(Color.WHITE);

        // Tambahkan komponen ke input panel
        inputPanel.add(inputLabel);
        inputPanel.add(inputField);
        inputPanel.add(fromLabel);
        inputPanel.add(fromTemperature);
        inputPanel.add(toLabel);
        inputPanel.add(toTemperature);
        inputPanel.add(new JLabel());
        inputPanel.add(new JLabel());
        inputPanel.add(convertButton);
        inputPanel.add(clearButton);

        add(inputPanel, BorderLayout.NORTH);

        // Tabel hasil konversi
        tableModel = new DefaultTableModel(new String[]{"Input Suhu", "Dari Suhu", "Ke Suhu", "Hasil Konversi"}, 0);
        resultTable = new JTable(tableModel);

        JScrollPane scrollPane = new JScrollPane(resultTable);
        add(scrollPane, BorderLayout.CENTER);

        // Action listeners
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

        setVisible(true);
    }

    private void performConversion() {
        String inputText = inputField.getText().trim();

        if (inputText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Input suhu tidak boleh kosong!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (fromTemperature.getSelectedItem().equals(toTemperature.getSelectedItem())) {
            changeToRandomTemperature();
            JOptionPane.showMessageDialog(this, "Suhu tujuan tidak boleh sama dengan suhu asal, diganti secara acak!", "Informasi", JOptionPane.INFORMATION_MESSAGE);
        }

        try {
            double inputValue = Double.parseDouble(inputText);
            String from = (String) fromTemperature.getSelectedItem();
            String to = (String) toTemperature.getSelectedItem();
            double result = 0;

            // Validasi duplikat
            if (isDuplicateEntry(inputValue, from, to)) {
                JOptionPane.showMessageDialog(this, "Data yang sama sudah ada di tabel!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Logika konversi
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

            // Tambahkan hasil ke tabel
            tableModel.addRow(new Object[]{inputValue, from, to, String.format("%.2f", result)});
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Input harus berupa angka yang valid!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private boolean isDuplicateEntry(double inputValue, String from, String to) {
        // Periksa setiap baris dalam tabel
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            double tableValue = Double.parseDouble(tableModel.getValueAt(i, 0).toString());
            String tableFrom = tableModel.getValueAt(i, 1).toString();
            String tableTo = tableModel.getValueAt(i, 2).toString();

            if (tableValue == inputValue && tableFrom.equals(from) && tableTo.equals(to)) {
                return true; // Duplikat ditemukan
            }
        }
        return false;
    }

    private void changeToRandomTemperature() {
        String[] temperatures = {"Celcius", "Fahrenheit", "Kelvin"};
        Random rand = new Random();
        String randomTemp;
        do {
            randomTemp = temperatures[rand.nextInt(3)];
        } while (randomTemp.equals(fromTemperature.getSelectedItem()));
        toTemperature.setSelectedItem(randomTemp);
    }

    private void clearFields() {
        inputField.setText("");
        fromTemperature.setSelectedIndex(0);
        toTemperature.setSelectedIndex(0);
        tableModel.setRowCount(0); // Hapus semua data di tabel
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(KonversiSuhuTabel::new);
    }
}
