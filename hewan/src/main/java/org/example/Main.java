package org.example;

class OwlFace {
    private String eye;
    private String nose;
    private String mouth;
    private String ear;
    private String head;

    public OwlFace(String o, String s, String v, String s1, String s2) {

    }

    public void OwlFce(String eye, String nose, String mouth, String ear, String head) {
        this.eye = eye;
        this.nose = nose;
        this.mouth = mouth;
        this.ear = ear;
        this.head = head;
    }

    public void displayFace() {
        System.out.println("  " + ear + "_" + ear);
        System.out.println(" /     \\");
        System.out.println("| " + eye + "   " + eye + " |");
        System.out.println("|   " + nose + "   |");
        System.out.println("| " + mouth + " " + mouth + " |");
        System.out.println("|_|");
        System.out.println("   " + head);
    }

    public void roar() {
        System.out.println("Roarrrr!");
    }

    public void eat() {
        System.out.println("Nom nom nom...");
    }

    public static void main(String[] args) {
        OwlFace Owl = new OwlFace("o", ">", "V", "^", "█");
        Owl.displayFace();
        Owl.roar();
        Owl.eat();
}
}