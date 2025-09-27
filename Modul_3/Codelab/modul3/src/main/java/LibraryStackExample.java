import java.util.Stack;

public class LibraryStackExample {
    public static void main(String[] args) {
        Stack<String> myStack = new Stack<>();

        // Mengecek apakah stack kosong sebelum penambahan elemen
        System.out.println(myStack.isEmpty());

        // Menambahkan elemen ke dalam stack
        myStack.push("Kucing");
        myStack.push("Burung");
        myStack.push("Kelinci");
        myStack.push("Ikan");
        myStack.push("Gajah");

        // Mengecek apakah stack kosong setelah penambahan elemen
        System.out.println(myStack.isEmpty());

        // Menampilkan elemen teratas (peek) dan semua isi stack
        System.out.println("Peek: " + myStack.peek());
        System.out.println("Contents: " + myStack);

        // Menghapus dua elemen teratas dari stack
        myStack.pop();
        myStack.pop();

        // Menampilkan isi stack setelah pop
        System.out.println("Contents after pop: " + myStack);

        // Mencari posisi "Kucing" dari atas stack
        System.out.println("Position of 'Kucing': " + myStack.search("Kucing"));
    }
}
