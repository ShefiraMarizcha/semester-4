package org.example;

import java.util.Scanner;

class Main {
    static String[][] bookList = {
            {"1", "388c-e681-9152", "title1", "author1", "Sejarah", "4"},
            {"2", "ed90-be30-5cdb", "title2", "author2", "Sejarah", "0"},
            {"3", "d95e-0c4a-9523", "title3", "author3", "Sejarah", "2"}
    };

    static String[][] userStudent = {
            {"123456789012345", "Student1"},
            {"123456789012346", "Student2"},
            {"123456789012347", "Student3"}
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Main main = new Main();

        while (true) {
            System.out.println("===== Library System =====");
            displayBooksTable();
            System.out.println("Input Id buku yang ingin dipinjam (input 99 untuk back)");
            System.out.print("Input: ");
            int bookId = scanner.nextInt();
            if (bookId == 99) {
                System.out.println("Kembali ke menu awal...");
                System.out.println("==== Student Menu ====");
                System.out.println("1. Buku terpinjam");
                System.out.println("2. Pinjam buku");
                System.out.println("3. Pinjam Buku atau Logout");
                System.out.print("Choose option (1-3): ");
                int option = scanner.nextInt();
                switch (option) {
                    case 3:
                        System.out.println("System logout...");
                        break;
                    default:
                        System.out.println("Invalid option. Please choose again.");
                }
                System.out.println("===== Library System =====");
                System.out.println("1. Login as Student");
                System.out.println("2. Login as Admin");
                System.out.println("3. Exit");
                System.out.print("Choose option (1-3): ");
                int choice = scanner.nextInt();
                if (choice == 3) {
                    System.out.println("Thank you. Exiting program.");
                    break;
                }
                continue;
            }
            System.out.println("==== Student Menu ====");
            System.out.println("1. Buku terpinjam");
            System.out.println("2. Pinjam buku");
            System.out.println("3. Pinjam Buku atau Logout");
            System.out.print("Choose option (1-3): ");
            int option = scanner.nextInt();
            switch (option) {
                case 3:
                    System.out.println("System logout...");
                    break;
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
            System.out.println("===== Library System =====");
            System.out.println("1. Login as Student");
            System.out.println("2. Login as Admin");
            System.out.println("3. Exit");
            System.out.print("Choose option (1-3): ");
            int choice = scanner.nextInt();
            if (choice == 2) {
                menuAdmin(scanner); // Panggil fungsi menuAdmin() dengan scanner sebagai parameter
            } else if (choice == 3) {
                System.out.println("Thank you. Exiting program.");
                break;
            }
        }
    }
    void menu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("===== Library System =====");
            System.out.println("1. Login as Student");
            System.out.println("2. Login as Admin");
            System.out.println("3. Exit");
            System.out.print("Choose option (1-3): ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    // Call menu for student
                    menuStudent();
                    break;
                case 2:
                    menuAdmin(scanner); // Call menu for admin
                    break;
                case 3:
                    System.out.println("Thank you. Exiting program.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        }
    }

    static void displayBooksTable() {
        System.out.println("========================================================================================");
        System.out.println("|| No. ||        Id buku                ||  Nama Buku || Author || Category ||  Stock ||");
        System.out.println("========================================================================================");
        for (String[] book : bookList) {
            System.out.printf("|| %-4s|| %-29s || %-10s || %-7s|| %-9s|| %-7s||\n",
                    book[0], book[1], book[2], book[3], book[4], book[5]);
        }
        System.out.println("========================================================================================");
    }

    static void menuAdmin(Scanner scanner) {
        while (true) {
            System.out.println("===== Admin Menu =====");
            System.out.println("1. Add Student");
            System.out.println("2. Display Registered Students");
            System.out.println("3. Logout");
            System.out.print("Choose option (1-3): ");
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    // Panggil fungsi untuk menambahkan mahasiswa
                    break;
                case 2:
                    displayRegisteredStudents();
                    break;
                case 3:
                    System.out.println("Logging out from admin account.");
                    return;
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        }
    }

    static void displayRegisteredStudents() {
        System.out.println("List of Registered Students:");
        // Implementasi untuk menampilkan daftar mahasiswa yang terdaftar
        System.out.println("Name: Taufiq Ramadhan");
        System.out.println("Faculty: Teknik");
        System.out.println("NIM: 202210370311208");
        System.out.println("Program: Informatika");

        System.out.println("Name: Who");
        System.out.println("Faculty: Teknik");
        System.out.println("NIM: 200510370310521");
        System.out.println("Program: Informatika");

        System.out.println("Name: Sutrisno Adit Pratama");
        System.out.println("Faculty: Teknik");
        System.out.println("NIM: 202210370311203");
        System.out.println("Program: Informatika");
    }

    void inputNim() {
        // Implement your logic for inputting NIM here
    }

    void checkNim() {
        // Implement your logic for checking NIM here
    }

    void menuStudent() {
        // Implement your student menu logic here
    }
}
