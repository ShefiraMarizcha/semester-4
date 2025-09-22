// Kelas utama Trial
public class Trial {
    // Atribut
    private String nama;
    private int angka;

    // Konstruktor tanpa parameter
    public Trial() {
        this.nama = "Default";
        this.angka = 0;
    }

    // Konstruktor dengan parameter
    public Trial(String nama, int angka) {
        this.nama = nama;
        this.angka = angka;
    }

    // Getter untuk nama
    public String getNama() {
        return nama;
    }

    // Setter untuk nama
    public void setNama(String nama) {
        this.nama = nama;
    }

    // Getter untuk angka
    public int getAngka() {
        return angka;
    }

    // Setter untuk angka
    public void setAngka(int angka) {
        this.angka = angka;
    }

    // Metode untuk menampilkan informasi
    public void tampilkanInfo() {
        System.out.println("Nama: " + nama);
        System.out.println("Angka: " + angka);
    }

    // Main method untuk menjalankan program
    public static void main(String[] args) {
        // Membuat objek Trial tanpa parameter
        Trial trial1 = new Trial();
        trial1.tampilkanInfo();

        // Membuat objek Trial dengan parameter
        Trial trial2 = new Trial("Contoh", 10);
        trial2.tampilkanInfo();

        // Mengubah atribut menggunakan setter
        trial1.setNama("Ubah Nama");
        trial1.setAngka(5);
        trial1.tampilkanInfo();
    }
}
