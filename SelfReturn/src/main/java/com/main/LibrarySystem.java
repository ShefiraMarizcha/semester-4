package com.main;

import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {
    private Map<String, String> borrowedBooks; // ID buku dan nama peminjam
    private Map<String, String> returnedBooks; // ID buku dan nama pengembali

    public LibrarySystem() {
        borrowedBooks = new HashMap<>();
        returnedBooks = new HashMap<>();
    }

    public void borrowBook(String bookId, String borrower) {
        borrowedBooks.put(bookId, borrower);
    }

    public boolean returnBook(String bookId) {
        if (borrowedBooks.containsKey(bookId)) {
            String borrower = borrowedBooks.remove(bookId);
            returnedBooks.put(bookId, borrower);
            return true;
        }
        return false;
    }

    public Map<String, String> getBorrowedBooks() {
        return borrowedBooks;
    }

    public Map<String, String> getReturnedBooks() {
        return returnedBooks;
    }
}

