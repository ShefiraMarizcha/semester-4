package org.example.latihanpraktikum1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KalkulatorKonversiSuhu extends JFrame {

    // Komponen GUI
    private JTextField displayField;
    private JTextField celciusField, fahrenheitField, kelvinField, reamurField;
    private JButton konversiButton;

    public KalkulatorKonversiSuhu() {
        // Pengaturan Frame
        setTitle("Kalkulator dan Konversi Suhu");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        // ** Display Input Field **
        displayField = new JTextField();
        displayField.setFont(new Font("Arial", Font.BOLD, 20));
        displayField.setBounds(50, 30, 300, 50);
        add(displayField);

        // ** Panel Tombol Kalkulator **
        JPanel panelTombol = new JPanel(new GridLayout(4, 4, 10, 10));
        panelTombol.setBounds(50, 100, 300, 200);

        String[] tombol = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "+", "-", "*", "/", "C", "="};

        for (String label : tombol) {
            JButton button = new JButton(label);
            button.setFont(new Font("Arial", Font.BOLD, 18));
            button.addActionListener(new ButtonAction());
            panelTombol.add(button);
        }
        add(panelTombol);

        // ** Panel Konversi Suhu **
        JLabel titleLabel = new JLabel("KALKULATOR KONVERSI SUHU");
        titleLabel.setBounds(400, 30, 200, 20);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 12));
        add(titleLabel);

        JLabel labelReamur = new JLabel("Reamur:");
        labelReamur.setBounds(400, 60, 80, 20);
        add(labelReamur);

        reamurField = new JTextField();
        reamurField.setBounds(480, 60, 80, 20);
        add(reamurField);

        JLabel labelCelcius = new JLabel("Celcius:");
        labelCelcius.setBounds(400, 90, 80, 20);
        add(labelCelcius);

        celciusField = new JTextField();
        celciusField.setBounds(480, 90, 80, 20);
        celciusField.setEditable(false);
        add(celciusField);

        JLabel labelFahrenheit = new JLabel("Fahrenheit:");
        labelFahrenheit.setBounds(400, 120, 80, 20);
        add(labelFahrenheit);

        fahrenheitField = new JTextField();
        fahrenheitField.setBounds(480, 120, 80, 20);
        fahrenheitField.setEditable(false);
        add(fahrenheitField);

        JLabel labelKelvin = new JLabel("Kelvin:");
        labelKelvin.setBounds(400, 150, 80, 20);
        add(labelKelvin);

        kelvinField = new JTextField();
        kelvinField.setBounds(480, 150, 80, 20);
        kelvinField.setEditable(false);
        add(kelvinField);

        konversiButton = new JButton("KONVERSI");
        konversiButton.setBounds(430, 180, 100, 30);
        konversiButton.addActionListener(e -> konversiSuhu());
        add(konversiButton);

        // Tampilkan frame
        setVisible(true);
    }

    // Aksi untuk tombol kalkulator
    private class ButtonAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            if (command.equals("C")) {
                displayField.setText("");
            } else if (command.equals("=")) {
                try {
                    String expression = displayField.getText();
                    double result = eval(expression);
                    displayField.setText(String.valueOf(result));
                } catch (Exception ex) {
                    displayField.setText("Error");
                }
            } else {
                displayField.setText(displayField.getText() + command);
            }
        }
    }

    // Evaluasi ekspresi matematika menggunakan ScriptEngine
    private double eval(String expression) {
        try {
            return (double) new javax.script.ScriptEngineManager()
                    .getEngineByName("JavaScript")
                    .eval(expression);
        } catch (Exception e) {
            throw new RuntimeException("Invalid Expression");
        }
    }

    // Konversi suhu dari Reamur ke Celcius, Fahrenheit, dan Kelvin
    private void konversiSuhu() {
        try {
            double reamur = Double.parseDouble(reamurField.getText());
            double celcius = reamur * 5 / 4;
            double fahrenheit = celcius * 9 / 5 + 32;
            double kelvin = celcius + 273.15;

            celciusField.setText(String.format("%.2f", celcius));
            fahrenheitField.setText(String.format("%.2f", fahrenheit));
            kelvinField.setText(String.format("%.2f", kelvin));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Input harus berupa angka yang valid!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(KalkulatorKonversiSuhu::new);
    }
}
