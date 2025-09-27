import java.util.Scanner;

// Enum untuk kategori buku
enum Kategori {
    NOVEL, BIOGRAFI, TEKNOLOGI, ANAK;
}

// Class Buku dengan dua generics
class Buku<T, U> {
    private T judul;
    private U pengarang;
    private double harga;
    private Kategori kategori;

    public Buku(T judul, U pengarang, double harga, Kategori kategori) {
        this.judul = judul;
        this.pengarang = pengarang;
        this.harga = harga;
        this.kategori = kategori;
    }

    public T getJudul() {
        return judul;
    }

    public U getPengarang() {
        return pengarang;
    }

    public double getHarga() {
        return harga;
    }

    public Kategori getKategori() {
        return kategori;
    }

    public void displayInfo() {
        System.out.println("\nInformasi Buku:");
        System.out.println("Judul: " + judul);
        System.out.println("Pengarang: " + pengarang);
        System.out.println("Harga: " + harga);
        System.out.println("Kategori: " + kategori);
    }
}

// Class Main untuk implementasi program
class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan Judul Buku: ");
        String judul = scanner.nextLine();

        System.out.print("Masukkan Nama Pengarang: ");
        String pengarang = scanner.nextLine();

        System.out.print("Masukkan Harga: ");
        double harga = scanner.nextDouble();

        System.out.println("\nPilih Kategori Buku:");
        for (int i = 0; i < Kategori.values().length; i++) {
            System.out.println(i + ". " + Kategori.values()[i]);
        }

        System.out.print("Masukkan pilihan: ");
        int pilihan = scanner.nextInt();
        Kategori kategori = Kategori.values()[pilihan];

        // Membuat objek Buku dengan generics
        Buku<String, String> buku = new Buku<>(judul, pengarang, harga, kategori);

        // Menampilkan informasi buku
        buku.displayInfo();
    }
}
