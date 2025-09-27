public class App {
    public static void main(String[] args) {
        Tabung tabung = new Tabung("tabung");
        Kubus kubus = new Kubus("kubus");
        Balok balok = new Balok("balok");

        System.out.println("Perhitungan Balok:");
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
