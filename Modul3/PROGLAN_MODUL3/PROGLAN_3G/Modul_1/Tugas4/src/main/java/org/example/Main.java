package org.example;

import java.util.Scanner;

public class Main {
    // Fungsi findMax untuk mencari nilai maksimum dari tiga bilangan
    public static int findMax(int a, int b, int c) {
        // Menggunakan Math.max untuk membandingkan bilangan
        return Math.max(a, Math.max(b, c));
    }

    public static void main(String[] args) {
        // Membuat scanner untuk membaca input dari pengguna
        Scanner scanner = new Scanner(System.in);

        // Meminta input dari pengguna untuk nilai a, b, dan c
        System.out.print("Masukkan nilai a: ");
        int a = scanner.nextInt();

        System.out.print("Masukkan nilai b: ");
        int b = scanner.nextInt();

        System.out.print("Masukkan nilai c: ");
        int c = scanner.nextInt();

        // Menghitung nilai maksimum menggunakan fungsi findMax
        int max = findMax(a, b, c);

        // Mencetak hasil
        System.out.println("Nilai maksimum adalah: " + max);

        // Menutup scanner untuk mencegah kebocoran memori
        scanner.close();
    }
}
