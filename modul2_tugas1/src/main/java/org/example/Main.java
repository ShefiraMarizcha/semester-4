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
            System.out.println("========================================================================================");
            displayBooksTable();
            System.out.println("========================================================================================");
            System.out.println("1. Login as Student");
            System.out.println("2. Login as Admin");
            System.out.println("3. Exit");

            System.out.print("Choose option (1-3): ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    Student student = new Student();
                    student.menu();
                    break;
                case 2:
                    Admin admin = new Admin();
                    admin.menu();
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
        System.out.println("|| No. ||        Id buku                ||  Nama Buku || Author || Category ||  Stock ||");
        System.out.println("========================================================================================");
        for (String[] book : bookList) {
            System.out.printf("|| %-4s|| %-29s || %-10s || %-7s|| %-9s|| %-7s||\n",
                    book[0], book[1], book[2], book[3], book[4], book[5]);
        }
    }

    void inputNim() {
        // Implement your logic for inputting NIM here
    }

    void checkNim() {
        // Implement your logic for checking NIM here
    }

    void menuAdmin() {
        // Implement your admin menu logic here
    }

    void menuStudent() {
        // Implement your student menu logic here
    }
}

class Student {
    void displayBooks() {
        // Implement logic to display books
        System.out.println("Books Displayed");
    }

    void logout() {
        System.out.println("System logout...");
    }

    void menu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("==== Student Menu ====");
            System.out.println("1. Display Books");
            System.out.println("2. Logout");
            System.out.println("3. Exit");
            System.out.print("Choose option (1-3): ");
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    displayBooks();
                    break;
                case 2:
                    logout();
                    return;
                case 3:
                    System.out.println("Thank you. Exiting program.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        }
    }
}

class Admin {
    void addStudent() {
        // Implement logic to add student
    }

    void displayStudent() {
        // Implement logic to display students
        System.out.println("Students Displayed");
    }

    void menu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("==== Admin Menu ====");
            System.out.println("1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Logout");
            System.out.println("4. Exit");
            System.out.print("Choose option (1-4): ");
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    displayStudent();
                    break;
                case 3:
                    System.out.println("System logout...");
                    return;
                case 4:
                    System.out.println("Thank you. Exiting program.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        }
    }
}