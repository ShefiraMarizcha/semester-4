package org.example;

import java.util.ArrayList;
import java.util.Scanner;

class Mahasiswa {
    String nama;
    long nim;
    String jurusan;
    static String universitas = "Universitas Muhammadiyah Malang";

    Mahasiswa(String nama, long nim, String jurusan) {
        this.nama = nama;
        this.nim = nim;
        this.jurusan = jurusan;
    }

    static void tampilUniversitas() {
        System.out.println("Universitas: " + universitas);
    }

    String tampilDataMahasiswa() {
        return "Nama: " + nama + ", NIM: " + nim + ", Jurusan: " + jurusan;
    }
}

public class Main {
    static ArrayList<Mahasiswa> daftarMahasiswa = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        menu();
    }

    static void menu() {
        int pilihan;
        do {
            System.out.println("Menu:");
            System.out.println("1. Tambah Data Mahasiswa");
            System.out.println("2. Tampilkan Data Mahasiswa");
            System.out.println("3. Keluar");
            System.out.print("Pilihan Anda: ");
            pilihan = scanner.nextInt();
            scanner.nextLine(); // Membuang newline character dari buffer

            switch (pilihan) {
                case 1:
                    tambahDataMahasiswa();
                    break;
                case 2:
                    tampilkanDataMahasiswa();
                    break;
                case 3:
                    System.out.println("Adios");
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
                    break;
            }
        } while (pilihan != 3);
    }

    static void tambahDataMahasiswa() {
        System.out.print("Masukkan nama mahasiswa: ");
        String nama = scanner.nextLine();
        long nim;
        do {
            System.out.print("Masukkan NIM mahasiswa: ");
            nim = scanner.nextLong();
            scanner.nextLine(); // Membuang newline character dari buffer
            if (String.valueOf(nim).length() != 15) {
                System.out.println("NIM Harus 15 Digit!!!");
            }
        } while (String.valueOf(nim).length() != 15);
        System.out.print("Masukkan jurusan mahasiswa: ");
        String jurusan = scanner.nextLine();

        Mahasiswa mahasiswa = new Mahasiswa(nama, nim, jurusan);
        daftarMahasiswa.add(mahasiswa);

        System.out.println("Data mahasiswa berhasil ditambahkan.");
    }

    static void tampilkanDataMahasiswa() {
        System.out.println("Data Mahasiswa:");
        Mahasiswa.tampilUniversitas();
        for (Mahasiswa mahasiswa : daftarMahasiswa) {
            System.out.println(mahasiswa.tampilDataMahasiswa());
        }
    }
}
