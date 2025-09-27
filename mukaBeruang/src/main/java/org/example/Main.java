package org.example;

class Beruang {
    // Fields
    private String mata;
    private String hidung;
    private String mulut;
    private String telinga;
    private String tubuh;

    // Constructor
    public Beruang(String mata, String hidung, String mulut, String telinga, String tubuh) {
        this.mata = mata;
        this.hidung = hidung;
        this.mulut = mulut;
        this.telinga = telinga;
        this.tubuh = tubuh;
    }

    // Method to display bear face
    public void displayFace() {
        System.out.println("     " + mata + "   " + mata);
        System.out.println("    " + hidung + hidung + hidung + hidung + hidung + hidung + hidung + hidung + hidung + hidung + hidung + hidung + hidung + hidung + hidung + hidung + hidung + hidung + hidung + hidung + hidung + hidung + hidung + hidung + hidung + hidung + hidung + hidung + hidung + hidung + hidung + hidung + hidung + hidung + hidung + hidung + hidung + hidung + hidung + hidung + hidung + hidung + hidung + hidung + hidung + hidung + hidung + hidung + hidung + hidung + hidung + hidung + hidung);
        System.out.println("   " + mulut + " " + tubuh + " " + tubuh + " " + tubuh + " " + tubuh + " " + tubuh + " " + tubuh + " " + tubuh + " " + tubuh + " " + tubuh + " " + tubuh + " " + tubuh + " " + tubuh + " " + tubuh + " " + tubuh + " " + tubuh + " " + tubuh + " " + tubuh + " " + tubuh + " " + tubuh + " " + tubuh + " " + tubuh + " " + tubuh + " " + tubuh + " " + tubuh + " " + tubuh + " " + tubuh + " " + tubuh + " " + tubuh + " " + tubuh + " " + tubuh + " " + tubuh + " " + tubuh + " " + tubuh + " " + tubuh);
        System.out.println(" " + telinga + "     " + telinga);
        System.out.println("  ____");
    }

    public static void main(String[] args) {
        Beruang beruang = new Beruang("o", ">", "V", "^", "█");
        beruang.displayFace();

    }
}