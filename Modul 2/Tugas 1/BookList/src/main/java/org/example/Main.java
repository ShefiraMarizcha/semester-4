package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private final ArrayList<Book> bookList;
    private final ArrayList<Student> studentList;
    private final Admin admin;
    private final Scanner scanner;

    public Main() {
        this.bookList = new ArrayList<>();
        this.studentList = new ArrayList<>();
        this.admin = new Admin(this.studentList);
        this.scanner = new Scanner(System.in);
        // Menambahkan beberapa contoh buku
        bookList.add(new Book(1, "Book1", "Author1", "Sejarah", 10));
        bookList.add(new Book(2, "Book2", "Author2", "Sejarah", 5));
    }

    public void menu() {
        boolean validInput = false;

        while (!validInput) {
            System.out.println("========== Library  System ===========");
            System.out.println("1. Login as Admin");
            System.out.println("2. Login as Student");
            System.out.println("3. EXIT");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    // Autentikasi admin
                    System.out.print("Enter admin username: ");
                    scanner.nextLine();
                    System.out.print("Enter admin password: ");
                    String adminPassword = scanner.nextLine();
                    if (admin.authenticate(adminPassword)) {
                        menuAdmin();
                    } else {
                        System.out.println("Invalid username or password for admin");
                    }
                    validInput = true;
                    break;
                // Autentikasi mahasiswa
                case 2:
                    String studentID;
                    // Autentikasi mahasiswa
                    while (true) {
                        System.out.print("Enter student ID: ");
                        studentID = scanner.nextLine();

                        if (studentID.length() == 15) {
                            if (authenticateStudent(studentID)) {
                                menuStudent();
                            } else {
                                System.out.println("Invalid student ID");
                            }
                            break; // keluar dari loop jika ID siswa valid
                        } else {
                            System.out.println("Student ID should not be empty and should not exceed 15 characters.");
                            // melanjutkan loop jika ID siswa tidak valid
                        }
                    }
                    validInput = true;
                    break;

                case 3:
                    System.out.println("Thank you. Exiting program.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }



    private boolean authenticateStudent(String studentID) {
        // Validasi panjang ID siswa
        if(studentID.length() != 15) {
            System.out.println("Error: Student ID should be 15 characters.");
            return false;
        }
        return true;
    }


    public void menuAdmin() {
        boolean logout = false;
        while (!logout) {
            System.out.println("\n======== Admin Menu ========");
            System.out.println("1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Add Book");
            System.out.println("4. Display Books");
            System.out.println("5. Logout and Back to Menu");
            System.out.println("6. Logout");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline
            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    admin.displayStudent();
                    break;
                case 3:
                    addBook();
                    break;
                case 4:
                    displayBooks();
                    break;
                case 5:
                    System.out.println("Logging out...");
                    logout = true;
                    break;
                case 6:
                    System.out.println("Logging out...");
                    return; // Keluar dari program
                default:
                    System.out.println("Invalid choice");
            }
        }
        // Kembali ke menu setelah logout
        menu();
    }

    public void menuStudent() {
        while (true) {
            displayBooks();
            System.out.println("\n========= Student Menu =========");
            System.out.println("1. Buku terpinjam");
            System.out.println("2. Pinjam buku");
            System.out.println("3. Pinjam Buku atau Logout");
            System.out.print("Choose option (1-3): ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline
            switch (choice) {
                case 1:
                    displayBorrowedBooks();
                    break;
                case 2:
                    borrowBook();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    private void borrowBook() {
    }

    private void displayBorrowedBooks() {
    }

    public void addStudent() {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        System.out.print("Enter student ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter student faculty: ");
        String faculty = scanner.nextLine();
        System.out.print("Enter student program: ");
        String program = scanner.nextLine();
        studentList.add(new Student(name, id, faculty, program));
        System.out.println("Student added successfully");
    }

    public void addBook() {
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter book author: ");
        String author = scanner.nextLine();
        System.out.print("Enter book category: ");
        String category = scanner.nextLine();
        System.out.print("Enter book stock: ");
        int stock = scanner.nextInt();
        scanner.nextLine(); // consume newline
        int id = bookList.size() + 1; // Generate ID
        bookList.add(new Book(id, title, author, category, stock));
        System.out.println("Book added successfully");
    }

    public void displayBooks() {
        System.out.println("\nList of Books:");
        System.out.println("===================================================================================");
        System.out.printf("|| %-4s || %-20s || %-20s || %-10s || %-6s||\n", "ID", "Title", "Author", "Stock", "Category");
        System.out.println("===================================================================================");
        for (Book book : bookList) {
            System.out.printf("|| %-4d || %-20s || %-20s || %-10d || %-6s ||\n", book.id(), book.title(), book.author(), book.stock(), book.category());
        }
        System.out.println("===================================================================================");
    }

    public static void main(String[] args) {
        Main library = new Main();
        library.menu();
    }
}

/**
 * @param id       Atribut buku
 * @param category Menambahkan atribut kategori
 */
record Book(int id, String title, String author, String category, int stock) {
}

record Student(String name, String id, String faculty, String program) {
    // Menyimpan ID buku yang sedang dipinjam
}

class Admin {
    private final ArrayList<Student> studentList;

    public Admin(ArrayList<Student> studentList) {
        this.studentList = studentList;
    }

    public boolean authenticate(String ignoredPassword) {
        // Autentikasi admin
        // Anda bisa menambahkan logika autentikasi admin sesuai kebutuhan di sini
        return true;
    }

    public void displayStudent() {
        System.out.println("\nList of Students:");
        for (Student student : studentList) {
            System.out.println("Name: " + student.name());
            System.out.println("ID: " + student.id());
            System.out.println("Faculty: " + student.faculty());
            System.out.println("Program: " + student.program());
            System.out.println(); // Tambahkan baris kosong antara setiap mahasiswa
        }
    }
}