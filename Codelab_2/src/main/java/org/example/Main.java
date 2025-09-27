package org.example;

import java.util.Scanner;
import java.util.ArrayList;

class Mahasiswa {
    static ArrayList<Mahasiswa> daftarMahasiswa = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int pilihan;
        do {
            System.out.println("\nMenu:\n1. Tambah Data Mahasiswa\n2. Tampilkan Data Mahasiswa\n3. Keluar");
            System.out.print("Pilihan Anda: ");
            pilihan = scanner.nextInt();
            scanner.nextLine(); // Membersihkan buffer

            switch (pilihan) {
                case 1:
                    tambahDataMahasiswa(scanner);
                    break;
                case 2:
                    tampilkanDataMahasiswa(daftarMahasiswa);
                    break;
                case 3:
                    System.out.println("Terima kasih!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 3);

        scanner.close();
    }

    public static void tambahDataMahasiswa(Scanner scanner) {
        System.out.print("Masukkan nama mahasiswa: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan NIM mahasiswa: ");
        String nim = scanner.nextLine();

        while (nim.length() != 15) {
            System.out.println("NIM harus terdiri dari 15 digit.");
            System.out.print("Masukkan NIM mahasiswa: ");
            nim = scanner.nextLine();
        }

        System.out.print("Masukkan jurusan mahasiswa: ");
        String jurusan = scanner.nextLine();

        Mahasiswa.tambahDataMahasiswa(daftarMahasiswa, nama, nim, jurusan);
    }

    private static void tambahDataMahasiswa(ArrayList<Mahasiswa> daftarMahasiswa, String nama, String nim, String jurusan) {
    }

    public static void tampilkanDataMahasiswa(ArrayList<Mahasiswa> daftarMahasiswa) {
        Mahasiswa.tampilkanDataMahasiswa(Mahasiswa.daftarMahasiswa);
    }
}
