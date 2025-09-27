package org.example;

public class Person {
    String name;
    int age;

    // Constructor
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Metode untuk menampilkan informasi
    public void displayInfo() {
        System.out.println("Name: " + name + ", Age: " + age);
    }

    public static void main(String[] args) {
        // Membuat objek dari class Person
        Person person1 = new Person("John", 25);

        // Menampilkan informasi tentang person1
        person1.displayInfo();
    }
}
