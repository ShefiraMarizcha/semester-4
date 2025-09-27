import java.util.*;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;


public class InventarisTokoBuku {

    private static final Map<String, Integer> inventaris = new HashMap<>();
    private static final Map<String, Double> hargaBuku = new HashMap<>();
    private static final Map<String, String> users = new HashMap<>();
    private static final Map<String, ArrayList<String>> userDetails = new HashMap<>();
    private static final Map<String, List<String>> riwayatPembelian = new HashMap<>();
    private static final Map<String, Integer> laporanPenjualan = new HashMap<>();

    private static String loggedInUser = null;
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Selamat Datang di Sistem Inventaris Toko Buku");
        while (true) {
            if (loggedInUser == null) {
                System.out.println("\nMenu Utama:");
                System.out.println("1. Register");
                System.out.println("2. Login");
                System.out.println("3. Keluar");
                System.out.print("Pilihan Anda: ");

                int pilihan = scanner.nextInt();
                scanner.nextLine();
                switch (pilihan) {
                    case 1:
                        register();
                        break;
                    case 2:
                        login();
                        break;
                    case 3:
                        System.out.println("Terima kasih telah menggunakan sistem ini.");
                        return;
                    default:
                        System.out.println("Pilihan tidak valid.");
                }
            } else {
                System.out.println("\nMenu Inventaris:");
                System.out.println("1. Tambah Buku Baru");
                System.out.println("2. Lihat Daftar Buku");
                System.out.println("3. Cari Buku");
                System.out.println("4. Tambah Stok Buku");
                System.out.println("5. Hapus Buku");
                System.out.println("6. Perbarui Harga Buku");
                System.out.println("7. Kasir (Pembelian Buku)");
                System.out.println("8. Lihat Riwayat Pembelian Pelanggan");
                System.out.println("9. Lihat Laporan Penjualan");
                System.out.println("10. Lihat Laporan Inventaris");
                System.out.println("11. Logout");
                System.out.print("Pilihan Anda: ");

                int pilihan = scanner.nextInt();
                scanner.nextLine();

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
                        kasir();
                        break;
                    case 8:
                        lihatRiwayatPembelian();
                        break;
                    case 9:
                        lihatLaporanPenjualan();
                        break;
                    case 10:
                        lihatLaporanInventaris();
                        break;
                    case 11:
                        logout();
                        break;
                    default:
                        System.out.println("Pilihan tidak valid.");
                }
            }
        }
    }

    private static void register() {
        System.out.print("Masukkan username: ");
        String username = scanner.nextLine();
        if (users.containsKey(username)) {
            System.out.println("Registrasi Gagal! Username sudah terdaftar.");
            return;
        }
        if (!username.contains("@")) {
            System.out.println("Registrasi Gagal! Username harus mengandung karakter '@'.");
            return;
        }
        System.out.print("Masukkan password: ");
        String password = scanner.nextLine();
        if (password.length() < 8) {
            System.out.println("Registrasi Gagal! Password minimal 8 karakter.");
            return;
        }
        System.out.print("Masukkan nama lengkap: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan alamat: ");
        String alamat = scanner.nextLine();

        users.put(username, password);
        userDetails.put(username, new ArrayList<>(Arrays.asList(nama, alamat)));
        System.out.println("Registrasi Berhasil!");
    }

    private static void login() {
        System.out.print("Masukkan username: ");
        String username = scanner.nextLine();
        System.out.print("Masukkan password: ");
        String password = scanner.nextLine();

        if (users.containsKey(username) && users.get(username).equals(password)) {
            loggedInUser = username;
            ArrayList<String> detail = userDetails.get(username);
            String nama = detail.get(0);
            String alamat = detail.get(1);
            System.out.println("===========================Login berhasil============================!!");
            System.out.println("Selamat datang, " + nama + " (" + alamat + ")");
        } else {
            System.out.println("Login Gagal!");
        }

    }

    private static void logout() {
        loggedInUser = null;
        System.out.println("Logout Berhasil!");
    }

    private static void kasir() {
        System.out.print("Masukkan nama pembeli: ");
        String namaPembeli = scanner.nextLine();

        System.out.print("Masukkan judul buku yang ingin dibeli: ");
        String judul = scanner.nextLine();
        if (!inventaris.containsKey(judul)) {
            System.out.println("Buku tidak ditemukan.");
            return;
        }

        System.out.print("Masukkan jumlah pembelian: ");
        int jumlah = scanner.nextInt();
        scanner.nextLine();

        int stok = inventaris.get(judul);
        if (stok < jumlah) {
            System.out.println("Stok tidak mencukupi.");
            return;
        }

        inventaris.put(judul, stok - jumlah);
        laporanPenjualan.put(judul, laporanPenjualan.getOrDefault(judul, 0) + jumlah);

        riwayatPembelian.putIfAbsent(namaPembeli, new ArrayList<>());
        riwayatPembelian.get(namaPembeli).add(judul + " x" + jumlah);

        double totalHarga = hargaBuku.get(judul) * jumlah;
        System.out.println("Transaksi berhasil. Total harga: Rp" + totalHarga);
    }

    private static void lihatRiwayatPembelian() {
        System.out.print("Masukkan nama pembeli: ");
        String nama = scanner.nextLine();

        List<String> riwayat = riwayatPembelian.get(nama);
        if (riwayat == null || riwayat.isEmpty()) {
            System.out.println("Tidak ada riwayat pembelian untuk " + nama);
            return;
        }

        System.out.println("Riwayat pembelian untuk " + nama + ":");
        for (String transaksi : riwayat) {
            System.out.println("- " + transaksi);
        }
    }

    private static void lihatLaporanPenjualan() {
        if (laporanPenjualan.isEmpty()) {
            System.out.println("Belum ada penjualan.");
            return;
        }

        System.out.println("Laporan Penjualan:");
        for (Map.Entry<String, Integer> entry : laporanPenjualan.entrySet()) {
            System.out.println(entry.getKey() + ": Terjual " + entry.getValue() + " buku");
        }
    }

    private static void lihatLaporanInventaris() {
        System.out.println("Laporan Inventaris:");
        for (String judul : inventaris.keySet()) {
            System.out.println(judul + ": Stok = " + inventaris.get(judul) + ", Harga = Rp" + hargaBuku.get(judul));
        }
        if (loggedInUser != null) {
            ArrayList<String> detail = userDetails.get(loggedInUser);
            System.out.println("User yang login: " + detail.get(0));
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
            scanner.nextLine();
        }
    }

    private static void lihatDaftarBuku() {
        if (inventaris.isEmpty()) {
            System.out.println("Belum ada buku dalam inventaris.");
            return;
        }

        System.out.println("Daftar Buku:");
        for (String judul : inventaris.keySet()) {
            System.out.println(judul + ": Stok = " + inventaris.get(judul) + ", Harga = Rp" + hargaBuku.get(judul));
        }
    }

    private static void cariBuku() {
        System.out.print("Masukkan Judul Buku yang Dicari: ");
        String judul = scanner.nextLine();

        if (inventaris.containsKey(judul)) {
            System.out.println("Stok Buku: " + inventaris.get(judul) + ", Harga: Rp" + hargaBuku.get(judul));
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
                scanner.nextLine();
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
                scanner.nextLine();
            }
        } else {
            System.out.println("Buku tidak ditemukan.");
        }
    }
}