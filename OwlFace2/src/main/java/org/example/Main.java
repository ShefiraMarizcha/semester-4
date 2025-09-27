package org.example;

class mahasiswa {
    // Fields
    private String name;
    private int nim ;
    private String jurusan;

    public Owl(String name, int nim, String jurusan) {

        name = name;
        nim = nim;
        jurusan = jurusan;
    }

    public void hoot() {
        System.out.println("Hoot hoot!");
    }

    // Method to display information about the owl
    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age + " years");
        System.out.println("Color: " + color);
        System.out.println("Habitat: " + habitat);
        System.out.println("Is nocturnal: " + (isNocturnal ? "Yes" : "No"));
    }

    // Method to draw the owl's face
    public void drawFace() {
        System.out.println("  \\     /");
        System.out.println("   \\___/");
        System.out.println("   (o o)");
        System.out.println("  {  \"  }");
        System.out.println("   -^-^-");
    }

    // Main method to test the Owl class
    public static void main(String[] args) {
        // Create an instance of Owl
        Owl myOwl = new Owl("Owlbert", 5, "Brown", "Forest", true);

        // Call the displayInfo method to see owl's information
        myOwl.displayInfo();

        // Make the owl hoot
        myOwl.hoot();

        // Draw the owl's face
        myOwl.drawFace();
    }
}
