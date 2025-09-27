package org.example;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Mahasiswa {
    private String nim;
    private String nama;
    private String kelas;
    private String universitas;

    public Mahasiswa(String nim, String nama, String kelas, String universitas) {
        this.nim = nim;
        this.nama = nama;
        this.kelas = kelas;
        this.universitas = universitas;
    }

    public String getNim() {
        return nim;
    }

    public String getNama() {
        return nama;
    }

    public String getKelas() {
        return kelas;
    }

    public String getUniversitas() {
        return universitas;
    }

    @Override
    public String toString() {
        return "NIM: " + nim + ", Nama: " + nama + ", Kelas: " + kelas + ", Universitas: " + universitas;
    }
}

class PengolahanDataMahasiswa {
    private static List<Mahasiswa> mahasiswaList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\nPengolahan Data Mahasiswa");
            System.out.println("1. Tambah Mahasiswa");
            System.out.println("2. Hapus Mahasiswa");
            System.out.println("3. Cari Mahasiswa");
            System.out.println("4. Tampilkan Semua Mahasiswa");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    tambahMahasiswa(scanner);
                    break;
                case 2:
                    hapusMahasiswa(scanner);
                    break;
                case 3:
                    cariMahasiswa(scanner);
                    break;
                case 4:
                    tampilkanSemuaMahasiswa();
                    break;
                case 5:
                    System.out.println("Keluar dari program.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid, silakan coba lagi.");
            }
        } while (choice != 5);

        scanner.close();
    }

    private static void tambahMahasiswa(Scanner scanner) {
        System.out.print("Masukkan NIM: ");
        String nim = scanner.nextLine();
        System.out.print("Masukkan Nama: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan Kelas: ");
        String kelas = scanner.nextLine();
        System.out.print("Masukkan Universitas: ");
        String universitas = scanner.nextLine();

        Mahasiswa mahasiswa = new Mahasiswa(nim, nama, kelas, universitas);
        mahasiswaList.add(mahasiswa);
        System.out.println("Mahasiswa berhasil ditambahkan.");
    }

    private static void hapusMahasiswa(Scanner scanner) {
        System.out.print("Masukkan NIM mahasiswa yang akan dihapus: ");
        String nim = scanner.nextLine();
        boolean found = false;
        for (Mahasiswa mahasiswa : mahasiswaList) {
            if (mahasiswa.getNim().equals(nim)) {
                mahasiswaList.remove(mahasiswa);
                System.out.println("Mahasiswa dengan NIM " + nim + " berhasil dihapus.");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Mahasiswa dengan NIM " + nim + " tidak ditemukan.");
        }
    }

    private static void cariMahasiswa(Scanner scanner) {
        System.out.print("Masukkan NIM mahasiswa yang akan dicari: ");
        String nim = scanner.nextLine();
        boolean found = false;
        for (Mahasiswa mahasiswa : mahasiswaList) {
            if (mahasiswa.getNim().equals(nim)) {
                System.out.println(mahasiswa);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Mahasiswa dengan NIM " + nim + " tidak ditemukan.");
        }
    }

    private static void tampilkanSemuaMahasiswa() {
        if (mahasiswaList.isEmpty()) {
            System.out.println("Tidak ada data mahasiswa.");
        } else {
            System.out.println("Data semua mahasiswa:");
            for (Mahasiswa mahasiswa : mahasiswaList) {
                System.out.println(mahasiswa);
            }
        }
    }
}
