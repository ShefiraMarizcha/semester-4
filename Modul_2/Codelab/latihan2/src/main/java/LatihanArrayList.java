import java.util.ArrayList;
import java.util.Scanner;

public class LatihanArrayList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> daftarBuah = new ArrayList<>();

        // 1 & 2. Meminta user untuk memasukkan beberapa nama buah
        System.out.println("Masukkan jumlah buah yang ingin ditambahkan:");
        int jumlahBuah = scanner.nextInt();
        scanner.nextLine(); // Konsumsi newline

        for (int i = 0; i < jumlahBuah; i++) {
            System.out.print("Masukkan nama buah ke-" + (i + 1) + ": ");
            daftarBuah.add(scanner.nextLine());
        }

        // 3. Menampilkan daftar buah dalam format bernomor
        System.out.println("\nDaftar Buah:");
        for (int i = 0; i < daftarBuah.size(); i++) {
            System.out.println((i + 1) + ". " + daftarBuah.get(i));
        }

        // 4. Mengakses elemen pada indeks 1 (jika ada minimal 2 elemen)
        if (daftarBuah.size() > 1) {
            System.out.println("\nElemen pada indeks 1: " + daftarBuah.get(1));
        }

        // 5. Mengubah elemen pada indeks 2 menjadi "Durian" (jika ada minimal 3 elemen)
        if (daftarBuah.size() > 2) {
            daftarBuah.set(2, "Durian");
            System.out.println("\nDaftar Buah setelah perubahan:");
            for (int i = 0; i < daftarBuah.size(); i++) {
                System.out.println((i + 1) + ". " + daftarBuah.get(i));
            }
        }

        // 6. Menghapus elemen pada indeks 3 (jika ada minimal 4 elemen)
        if (daftarBuah.size() > 3) {
            daftarBuah.remove(3);
            System.out.println("\nDaftar Buah setelah penghapusan:");
            for (int i = 0; i < daftarBuah.size(); i++) {
                System.out.println((i + 1) + ". " + daftarBuah.get(i));
            }
        }

        // 7. Menampilkan jumlah elemen dalam ArrayList
        System.out.println("\nJumlah elemen dalam ArrayList: " + daftarBuah.size());

        // 8. Memeriksa apakah ArrayList kosong
        System.out.println("Apakah ArrayList kosong? " + daftarBuah.isEmpty());

        scanner.close();
    }
}
