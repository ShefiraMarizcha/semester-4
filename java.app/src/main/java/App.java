public class App {
    public static void main(String[] args) throws Exception {
        // Membuat objek untuk masing-masing kelas
        Tabung tabung = new Tabung("Tabung");
        Kubus kubus = new Kubus("Kubus");
        Balok balok = new Balok("Balok");

        System.out.println("\nPerhitungan Balok:");
        balok.inputNilai();
        balok.luasPermukaan();
        balok.volume();

        System.out.println("\nPerhitungan Kubus:");
        kubus.inputNilai();
        kubus.luasPermukaan();
        kubus.volume();

        System.out.println("\nPerhitungan Tabung:");
        tabung.inputNilai();
        tabung.luasPermukaan();
        tabung.volume();
    }
}
