public class TiketPesawat {
    private String nama;
    private String asal;
    private String tujuan;
    private double Tiket;
    private double diskon;

    public TiketPesawat(String nmInfo, String aSal, String dst, double Tiket, double disk) {
        this.nama = nama;
        this.asal = aSal;
        this.tujuan = dst;
        this.Tiket = Tiket;
        this.diskon = disk;
    }

    public double hitungBiayaTiket() {
        return Tiket - (Tiket * (diskon / 100));
    }

    public double hitungDiskon() {
        return Tiket * (diskon / 100);
    }

    public void t() {
        System.out.println("Nama Penumpang: " + nama);
        System.out.println("Asal: " + asal);
        System.out.println("Tujuan: " + tujuan);
        System.out.println("Harga Tiket: " + Tiket);
        System.out.println("Diskon: " + diskon + "%");
        System.out.println("Biaya Tiket Setelah Diskon: " + hitungBiayaTiket());
        System.out.println("Jumlah Diskon: " + hitungDiskon());
    }
}
