import java.util.Scanner;

class BangunRuang {
    Scanner scanner = new Scanner(System.in);
    private double tinggi;
    private double jari_jari;

    // Konstruktor
    public BangunRuang() {
        // Tidak perlu ada pemanggilan super() di sini
    }

    public void inputNilai() {
        System.out.print("Input tinggi: ");
        tinggi = scanner.nextDouble();
        System.out.print("Input jari-jari: ");
        jari_jari = scanner.nextDouble();
    }

    public void luasPermukaan() {
        double hasil = 2 * Math.PI * jari_jari * (jari_jari);
        System.out.println("Hasil luas permukaan: " + hasil);
    }

    public void volume() {
        double hasil = Math.PI * Math.pow(jari_jari, 2) * tinggi;
        System.out.println("Hasil volume: " + hasil);
    }

    protected void input() {

    }
}
