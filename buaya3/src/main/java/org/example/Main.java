package org.example;

class Hewan {
    // Fields
    private String jenis;
    private String warna;
    private int umur;
    private double berat;
    private boolean sehat;

    // Constructor
    public Hewan(String jenis, String warna, int umur, double berat, boolean sehat) {
        this.jenis = jenis;
        this.warna = warna;
        this.umur = umur;
        this.berat = berat;
        this.sehat = sehat;
    }

    // Method 1
    public void displayInfo() {
        System.out.println("Jenis: " + jenis);
        System.out.println("Warna: " + warna);
        System.out.println("Umur: " + umur);
        System.out.println("Berat: " + berat + " kg");
        System.out.println("Sehat: " + (sehat ? "Ya" : "Tidak"));
        System.out.println("Muka: Buaya");
    }

    // Method 2
    public void berenang() {
        System.out.println("Buaya sedang berenang.");
    }

    // Method to draw the crocodile's face
    public void drawFace() {
        System.out.println("      __");
        System.out.println("    /      \\");
        System.out.println("   |  o  o  |");
        System.out.println("    \\  __  /");
        System.out.println("    /      \\");
        System.out.println("   |        |");
        System.out.println("    \\______/");
    }

    public static void main(String[] args) {
        // Creating an instance of Hewan
        Hewan buaya = new Hewan("Buaya", "Hijau", 10, 500.0, true);

        // Calling methods
        buaya.displayInfo();
        buaya.berenang();

        // Drawing the crocodile's face
        buaya.drawFace();
    }
}
