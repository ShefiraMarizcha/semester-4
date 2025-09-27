import java.util.LinkedList;
import java.util.Queue;

public class ContohQueueBaru {
    public static void main(String[] args) {
        // Membuat queue dengan tipe data String
        Queue<String> hewan = new LinkedList<>();

        // Menambahkan elemen ke dalam queue
        hewan.add("Kucing");
        hewan.add("Burung");
        hewan.add("Ikan");
        hewan.add("Gajah");
        hewan.add("Harimau");

        // Menampilkan elemen pertama tanpa menghapusnya
        System.out.println("Peek: " + hewan.peek());

        // Menampilkan seluruh isi queue
        System.out.println("Daftar Hewan: " + hewan);

        // Menghapus dua elemen pertama dari queue
        hewan.poll();
        hewan.poll();

        // Menampilkan isi queue setelah dua elemen dihapus
        System.out.println("Daftar Hewan setelah Poll: " + hewan);
    }
}
