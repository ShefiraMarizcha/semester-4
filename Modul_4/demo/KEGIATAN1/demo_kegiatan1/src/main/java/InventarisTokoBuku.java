import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class InventarisTokoBuku {

    private static final Map<String, Integer> inventaris = new HashMap<>();
    private static final Map<String, Double> hargaBuku = new HashMap<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Selamat Datang di Sistem Inventaris Toko Buku");
        while (true) {
            System.out.println("\nPilih Menu:");
            System.out.println("1. Tambah Buku Baru");
            System.out.println("2. Lihat Daftar Buku");
            System.out.println("3. Cari Buku");
            System.out.println("4. Tambah Stok Buku");
            System.out.println("5. Hapus Buku");
            System.out.println("6. Perbarui Harga Buku");
            System.out.println("7. Keluar");
            System.out.print("Pilihan Anda: ");

            int pilihan = 0;
            try {
                pilihan = scanner.nextInt();
                scanner.nextLine(); // konsumsi newline
            } catch (InputMismatchException e) {
                System.out.println("Input tidak valid. Masukkan angka.");
                scanner.nextLine(); // bersihkan buffer
                continue;
            }

            switch (pilihan) {
                case 1:
                    tambahBuku();
                    break;
                case 2:
                    lihatDaftarBuku();
                    break;
                case 3:
                    cariBuku();
                    break;
                case 4:
                    tambahStokBuku();
                    break;
                case 5:
                    hapusBuku();
                    break;
                case 6:
                    perbaruiHargaBuku();
                    break;
                case 7:
                    System.out.println("Terima kasih telah mengunjungi kami!.");
                    return;
                default:
                    System.out.println("Pilihan tidak valid, silakan pilih lagi.");
            }
        }
    }

    private static void tambahBuku() {
        System.out.print("Masukkan Judul Buku: ");
        String judul = scanner.nextLine();

        if (inventaris.containsKey(judul)) {
            System.out.println("Buku sudah ada di inventaris.");
            return;
        }

        try {
            System.out.print("Masukkan Jumlah Stok: ");
            int stok = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Masukkan Harga: ");
            double harga = scanner.nextDouble();
            scanner.nextLine();

            inventaris.put(judul, stok);
            hargaBuku.put(judul, harga);
            System.out.println("Buku berhasil ditambahkan!");
        } catch (InputMismatchException e) {
            System.out.println("Input tidak valid. Tambah buku dibatalkan.");
            scanner.nextLine(); // bersihkan buffer
        }
    }

    private static void lihatDaftarBuku() {
        if (inventaris.isEmpty()) {
            System.out.println("Belum ada buku dalam inventaris.");
            return;
        }

        System.out.println("Daftar Buku:");
        for (String judul : inventaris.keySet()) {
            System.out.println(judul + ": Stok = " + inventaris.get(judul) + ", Harga = " + hargaBuku.get(judul));
        }
    }

    private static void cariBuku() {
        System.out.print("Masukkan Judul Buku yang Dicari: ");
        String judul = scanner.nextLine();

        if (inventaris.containsKey(judul)) {
            System.out.println("Stok Buku: " + inventaris.get(judul) + ", Harga: " + hargaBuku.get(judul));
        } else {
            System.out.println("Buku tidak ditemukan.");
        }
    }

    private static void tambahStokBuku() {
        System.out.print("Masukkan Judul Buku yang Akan Ditambah Stoknya: ");
        String judul = scanner.nextLine();

        if (inventaris.containsKey(judul)) {
            try {
                System.out.print("Masukkan Jumlah Stok yang Akan Ditambahkan: ");
                int tambahan = scanner.nextInt();
                scanner.nextLine();
                inventaris.put(judul, inventaris.get(judul) + tambahan);
                System.out.println("Stok buku berhasil diperbarui!");
            } catch (InputMismatchException e) {
                System.out.println("Input tidak valid. Tambah stok dibatalkan.");
                scanner.nextLine(); // bersihkan buffer
            }
        } else {
            System.out.println("Buku tidak ditemukan.");
        }
    }

    private static void hapusBuku() {
        System.out.print("Masukkan Judul Buku yang Akan Dihapus: ");
        String judul = scanner.nextLine();

        if (inventaris.containsKey(judul)) {
            inventaris.remove(judul);
            hargaBuku.remove(judul);
            System.out.println("Buku berhasil dihapus!");
        } else {
            System.out.println("Buku tidak ditemukan.");
        }
    }

    private static void perbaruiHargaBuku() {
        System.out.print("Masukkan Judul Buku yang Harganya Akan Diperbarui: ");
        String judul = scanner.nextLine();

        if (inventaris.containsKey(judul)) {
            try {
                System.out.print("Masukkan Harga Baru: ");
                double hargaBaru = scanner.nextDouble();
                scanner.nextLine();
                hargaBuku.put(judul, hargaBaru);
                System.out.println("Harga buku berhasil diperbarui!");
            } catch (InputMismatchException e) {
                System.out.println("Input tidak valid. Perbarui harga dibatalkan.");
                scanner.nextLine(); // bersihkan buffer
            }
        } else {
            System.out.println("Buku tidak ditemukan.");
        }
    }
}
