import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class Siswa {
    String nama;
    int nilai;

    public Siswa(String nama, int nilai) {
        this.nama = nama;
        this.nilai = nilai;
    }

    @Override
    public String toString() {
        return "Nama: " + nama + ", Nilai: " + nilai;
    }
}

class Main {
    public static void main(String[] args) {
        ArrayList<Siswa> dataSiswa = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int pilihan;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Tambah Siswa");
            System.out.println("2. Urutkan dan Tampilkan berdasarkan Nama");
            System.out.println("3. Urutkan dan Tampilkan berdasarkan Nilai");
            System.out.println("4. Keluar");
            System.out.print("Pilihan: ");
            pilihan = scanner.nextInt();
            scanner.nextLine();  // Membersihkan buffer newline

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan nama siswa: ");
                    String nama = scanner.nextLine();
                    System.out.print("Masukkan nilai siswa: ");
                    int nilai = scanner.nextInt();
                    dataSiswa.add(new Siswa(nama, nilai));
                    System.out.println("Data siswa berhasil ditambahkan.");
                    break;

                case 2:
                    Collections.sort(dataSiswa, Comparator.comparing(s -> s.nama));
                    System.out.println("Data siswa diurutkan berdasarkan nama:");
                    for (Siswa s : dataSiswa) {
                        System.out.println(s);
                    }
                    break;

                case 3:
                    dataSiswa.sort((s1, s2) -> Integer.compare(s2.nilai, s1.nilai));
                    System.out.println("Data siswa diurutkan berdasarkan nilai:");
                    for (Siswa s : dataSiswa) {
                        System.out.println(s);
                    }
                    break;

                case 4:
                    System.out.println("Keluar dari program.");
                    break;

                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        } while (pilihan != 4);

        scanner.close();
    }
}
