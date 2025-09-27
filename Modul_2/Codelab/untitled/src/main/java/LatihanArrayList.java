import java.util.ArrayList;

public class LatihanArrayList {
    public static void main(String[] args) {
        // 1. Membuat objek ArrayList yang menyimpan data String
        ArrayList<String> daftarBuah = new ArrayList<>();

        // 2. Menambahkan beberapa nama buah ke dalam ArrayList
        daftarBuah.add("Apel");
        daftarBuah.add("Jeruk");
        daftarBuah.add("Mangga");
        daftarBuah.add("Semangka");

        // 3. Menampilkan isi ArrayList dengan perulangan for-each
        System.out.println("Daftar Buah:");
        for (String buah : daftarBuah) {
            System.out.println(buah);
        }

        // 4. Mengakses elemen pada indeks 1 menggunakan get()
        System.out.println("\nElemen pada indeks 1: " + daftarBuah.get(1));

        // 5. Mengubah elemen pada indeks 2 menjadi "Durian" menggunakan set()
        daftarBuah.set(2, "Durian");

        System.out.println("\nDaftar Buah setelah perubahan:");
        for (String buah : daftarBuah) {
            System.out.println(buah);
        }

        // 6. Menghapus elemen pada indeks 3 menggunakan remove()
        daftarBuah.remove(3);

        System.out.println("\nDaftar Buah setelah penghapusan:");
        for (String buah : daftarBuah) {
            System.out.println(buah);
        }

        // 7. Menampilkan jumlah elemen dalam ArrayList menggunakan size()
        System.out.println("\nJumlah elemen dalam ArrayList: " + daftarBuah.size());

        // 8. Memeriksa apakah ArrayList kosong menggunakan isEmpty()
        System.out.println("Apakah ArrayList kosong? " + daftarBuah.isEmpty());
    }
}
