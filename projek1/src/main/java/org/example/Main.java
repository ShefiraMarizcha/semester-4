package org.example;

import java.util.Scanner;

class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Masukkan dua angka:");
        double angka1 = scanner.nextDouble();
        double angka2 = scanner.nextDouble();

        System.out.println("Pilih operasi: tambah (+), kurang (-), kali (*), atau bagi (/)");
        char operator = scanner.next().charAt(0);

        double hasil;

        switch (operator) {
            case '+':
                hasil = angka1 + angka2;
                break;
            case '-':
                hasil = angka1 - angka2;
                break;
            case '*':
                hasil = angka1 * angka2;
                break;
            case '/':
                hasil = angka1 / angka2;
                break;
            default:
                System.out.println("Operasi tidak valid");
                return;
        }

        System.out.println("Hasil: " + hasil);
    }
}