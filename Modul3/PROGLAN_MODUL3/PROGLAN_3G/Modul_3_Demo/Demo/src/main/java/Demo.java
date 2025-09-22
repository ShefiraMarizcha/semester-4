// Kelas utama Demo
public class Demo {
    // Atribut
    private String pesan;
    private int nomor;

    // Konstruktor tanpa parameter
    public Demo() {
        this.pesan = "Pesan Default";
        this.nomor = 0;
    }

    // Konstruktor dengan parameter
    public Demo(String pesan, int nomor) {
        this.pesan = pesan;
        this.nomor = nomor;
    }

    // Getter untuk pesan
    public String getPesan() {
        return pesan;
    }

    // Setter untuk pesan
    public void setPesan(String pesan) {
        this.pesan = pesan;
    }

    // Getter untuk nomor
    public int getNomor() {
        return nomor;
    }

    // Setter untuk nomor
    public void setNomor(int nomor) {
        this.nomor = nomor;
    }

    // Metode untuk menampilkan informasi
    public void tampilkanInfo() {
        System.out.println("Pesan: " + pesan);
        System.out.println("Nomor: " + nomor);
    }

    // Main method untuk menjalankan program
    public static void main(String[] args) {
        // Membuat objek Demo tanpa parameter
        Demo demo1 = new Demo();
        demo1.tampilkanInfo();

        System.out.println();

        // Membuat objek Demo dengan parameter
        Demo demo2 = new Demo("Halo, ini adalah kelas Demo!", 27);
        demo2.tampilkanInfo();

        System.out.println();

        // Mengubah atribut menggunakan setter
        demo1.setPesan("Pesan Baru");
        demo1.setNomor(99);
        demo1.tampilkanInfo();
    }
}
