package org.example;

import java.util.Scanner;

class Library {
    private String adminUsername = "admin";
    private String adminPassword = "admin123";

    public void loginAsStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your NIM : ");
        String nim = scanner.nextLine();
        if (nim.equals("202310370311027")) {
            System.out.println("Successful Login as Student");
        } else {
            System.out.println("User Not Found");
        }
    }

    public void loginAsAdmin() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your username (admin): ");
        String username = scanner.nextLine();
        System.out.print("Enter your password (admin): ");
        String password = scanner.nextLine();
        if (username.equals(adminUsername) && password.equals(adminPassword)) {
            System.out.println("Successful Login as Admin");
        } else {
            System.out.println("Admin User Not Found!!");
        }
    }

    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nLibrary System\n");
            System.out.println("1. Login as Student");
            System.out.println("2. Login as Admin");
            System.out.println("3. Exit");
            System.out.print("\nChoose option (1-3): ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    library.loginAsStudent();
                    break;
                case 2:
                    library.loginAsAdmin();
                    break;
                case 3:
                    System.out.println("adios");
                    break;
                default:
                    System.out.println("Invalid choice. Please choose between 1 to 3.");
            }
        } while (choice != 3);
    }
}