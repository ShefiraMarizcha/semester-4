package org.example;

import java.util.Scanner;

class Tabung extends BangunRuang {
    private double tinggi;
    private double jari_jari;
    Scanner scanner = new Scanner(System.in);

    public Tabung(String nameBangun) {
        super();
    }

    public void inputNilai() {
        super.inputNilai();
        System.out.print("Input tinggi: ");
        tinggi = scanner.nextDouble();
        System.out.print("Input jari-jari: ");
        jari_jari = scanner.nextDouble();
    }

    public void hitungLuasPermukaan() {
        double hasil = 2 * Math.PI * jari_jari * (jari_jari + tinggi);
        System.out.println("Hasil luas permukaan: " + hasil);
    }

    public void hitungVolume() {
        double hasil = Math.PI * Math.pow(jari_jari, 2) * tinggi;
        System.out.println("Hasil volume: " + hasil);
    }
}
