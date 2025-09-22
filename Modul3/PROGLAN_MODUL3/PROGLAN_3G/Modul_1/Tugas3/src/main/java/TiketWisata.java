import java.util.Scanner;

public class TiketWisata {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nama;
        String hari;
        String tanggal;
        String jenisTiket;
        int jumlahDewasa;
        int jumlahAnak;

        // Input Nama
        System.out.print("Masukkan nama: ");
        nama = scanner.nextLine();
        while (nama.isEmpty()) {
            System.out.println("Data harus diisi");
            System.out.print("Masukkan nama: ");
            nama = scanner.nextLine();
        }

        // Input Hari
        System.out.print("Masukkan hari (contoh: Senin): ");
        hari = scanner.nextLine();
        while (hari.isEmpty()) {
            System.out.println("Data harus diisi");
            System.out.print("Masukkan hari: ");
            hari = scanner.nextLine();
        }

        // Input Tanggal
        System.out.print("Masukkan tanggal (contoh: 2024-10-01): ");
        tanggal = scanner.nextLine();
        while (tanggal.isEmpty()) {
            System.out.println("Data harus diisi");
            System.out.print("Masukkan tanggal: ");
            tanggal = scanner.nextLine();
        }

        // Input Jenis Tiket
        System.out.print("Masukkan jenis tiket (reguler/terusan): ");
        jenisTiket = scanner.nextLine();
        while (jenisTiket.isEmpty() || (!jenisTiket.equalsIgnoreCase("reguler") && !jenisTiket.equalsIgnoreCase("terusan"))) {
            System.out.println("Data harus diisi dan jenis tiket harus 'reguler' atau 'terusan'");
            System.out.print("Masukkan jenis tiket: ");
            jenisTiket = scanner.nextLine();
        }

        // Input Jumlah Dewasa
        System.out.print("Masukkan jumlah dewasa: ");
        jumlahDewasa = scanner.nextInt();
        while (jumlahDewasa < 0) {
            System.out.println("Jumlah dewasa tidak boleh negatif");
            System.out.print("Masukkan jumlah dewasa: ");
            jumlahDewasa = scanner.nextInt();
        }

        // Input Jumlah Anak
        System.out.print("Masukkan jumlah anak: ");
        jumlahAnak = scanner.nextInt();
        while (jumlahAnak < 0) {
            System.out.println("Jumlah anak tidak boleh negatif");
            System.out.print("Masukkan jumlah anak: ");
            jumlahAnak = scanner.nextInt();
        }

        // Hitung Harga
        double hargaDewasa, hargaAnak;
        if (jenisTiket.equalsIgnoreCase("reguler")) {
            hargaDewasa = 75000;
            hargaAnak = 60000;
        } else {
            hargaDewasa = 100000;
            hargaAnak = 85000;
        }

        double totalDewasa = hargaDewasa * jumlahDewasa;
        double totalAnak = hargaAnak * jumlahAnak;
        double totalHarga = totalDewasa + totalAnak;

        // Tambah 20% jika hari Sabtu atau Minggu
        if (hari.equalsIgnoreCase("sabtu") || hari.equalsIgnoreCase("minggu")) {
            totalHarga *= 1.2;
        }

        // Tampilkan informasi pemesanan
        System.out.printf("Pemesan: %s%n", nama);
        System.out.printf("Hari: %s%n", hari);
        System.out.printf("Tanggal: %s%n", tanggal);
        System.out.printf("Jenis Tiket: %s%n", jenisTiket);
        System.out.printf("Jumlah Dewasa: %d, Jumlah Anak: %d%n", jumlahDewasa, jumlahAnak);
        System.out.printf("Total Harga: Rp %.2f%n", totalHarga);
    }
}
