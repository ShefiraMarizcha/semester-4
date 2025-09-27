import java.util.HashMap;
import java.util.Map;

public class BukuTelepon {
    public static void main(String[] args) {
        // Inisialisasi HashMap untuk menyimpan nama dan nomor telepon
        HashMap<String, String> bukuTelepon = new HashMap<>();

        // Menambahkan data kontak
        bukuTelepon.put("Faizal", "08123456789");
        bukuTelepon.put("Taufiq", "08765432100");
        bukuTelepon.put("Adit", "08555555555");

        // Menampilkan isi buku telepon
        System.out.println("Isi Buku Telepon:");
        for (Map.Entry<String, String> entry : bukuTelepon.entrySet()) {
            System.out.println("Nama: " + entry.getKey() + ", Telepon: " + entry.getValue());
        }

        // Mencari nomor telepon berdasarkan nama
        String namaDicari = "Taufiq";
        String nomorTelepon = bukuTelepon.get(namaDicari);
        if (nomorTelepon != null) {
            System.out.println("Nomor telepon " + namaDicari + ": " + nomorTelepon);
        } else {
            System.out.println("Kontak " + namaDicari + " tidak ditemukan.");
        }

        // Memeriksa apakah sebuah nama ada dalam buku telepon
        String namaPengecekan = "Adit";
        if (bukuTelepon.containsKey(namaPengecekan)) {
            System.out.println("Kontak " + namaPengecekan + " ada dalam buku telepon.");
        } else {
            System.out.println("Kontak " + namaPengecekan + " tidak ada dalam buku telepon.");
        }

        // Menghapus data kontak
        String namaHapus = "Faizal";
        bukuTelepon.remove(namaHapus);
        System.out.println("Isi Buku Telepon setelah menghapus " + namaHapus + ":");

        for (Map.Entry<String, String> entry : bukuTelepon.entrySet()) {
            System.out.println("Nama: " + entry.getKey() + ", Telepon: " + entry.getValue());
        }
    }
}
