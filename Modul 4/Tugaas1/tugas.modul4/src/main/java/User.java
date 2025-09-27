package modul4.tugas.data;

import modul4.tugas.books.Books;

public abstract class User<Books> {

    private String nim;

    public User(String nim) {
        this.nim = nim;
    }

    public String getNim() {
        return nim;
    }

    public void displayBooks(Books[] booksList){

    }
    public void addStudent(){

    }
    public void choiceBook(Books[] booksList){

    }

}