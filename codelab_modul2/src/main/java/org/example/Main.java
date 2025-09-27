package org.example;

import java.util.Scanner;

class Mahasiswa {
    String nama;
    String nim;
    String jurusan;

    public Mahasiswa(String nama, String nim, String jurusan) {
        this.nama = nama;
        this.nim = nim;
        this.jurusan = jurusan;
    }

    public void tampil() {
        System.out.println("Nama: " + nama);
        System.out.println("NIM: " + nim);
        System.out.println("Jurusan: " + jurusan);
    }

    public static void tampilUniversitas() {
        System.out.println("Universitas MUHAMMADIYAH MALANG");
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input data mahasiswa
        System.out.print("Masukkan nama mahasiswa: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan NIM mahasiswa: ");
        String nim = scanner.nextLine();
        System.out.print("Masukkan jurusan mahasiswa: ");
        String jurusan = scanner.nextLine();

        // Validasi panjang NIM
        if (nim.length() != 15) {
            System.out.println("Panjang NIM harus 15 angka.");
            return;
        }

        // Membuat objek Mahasiswa
        Mahasiswa mahasiswa = new Mahasiswa(nama, nim, jurusan);

        // Menampilkan data mahasiswa
        System.out.println("\nData Mahasiswa:");
        mahasiswa.tampil();

        // Menampilkan nama universitas
        System.out.println("\nNama Universitas:");
        Mahasiswa.tampilUniversitas();

        scanner.close();
    }
}
