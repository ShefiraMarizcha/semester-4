package org.example;

public class App {
    public static <Tabung> void main(String[] args) throws Exception {
        Kubus1.Kubus kubus = new Kubus1.Kubus("kubus");
        Tabung tabung = new Tabung("tabung");

        kubus.inputNilai();
        kubus.luasPermukaan();
        kubus.volume();

        tabung.notify();
        tabung.equals();
        tabung.clone();
    }
}
