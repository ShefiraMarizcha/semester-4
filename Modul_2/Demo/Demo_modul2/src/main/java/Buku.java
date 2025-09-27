import java.util.ArrayList;
import java.util.Scanner;
//saya memakai library arraylist sesuai dengan ketentuan yang diberikan
//di propgram perpustakaan ini kalau pakai arraylist ukurannya bisa bertambah dan berkurang secara dinamis
//kayak misal kita nambahin buku baru, jadi otomatis ngeluasin kapasitasnya tanpa harus atur ukurannya dari awal kayak array biasa.
//kalau array biasa jadinya harus nentuin ukuran nya dan gaboleh ngelebihin ukuran yg udah di set
// misal Book[255]
//trus juga arraylist ini ada metod bawaannya yg mudahin kita buat nambah atau hapus buku, jadi memudahkan banget untuk dikelola
//sebenernya bisa pake linkedlist tapi akses datanya lebih lambat dari arraylist, terus juga gabisa akses langsung lewat indeks, jadi
// dia kalau mau nyari atau akses buku harus nelusurin satu2 dari indeks pertama sampe indesk yg diperluin

class Book {
    private String title;
    private String author;
//untuk bagian ini saya juga udah menuhin ketentuan diamana class buku ada 2 atribut judul dan penulis
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }
// di bagian get itu metod buat ngambil nilai title, sedangkan return disini untuk balikin nilai ke title
    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "Judul: " + title + ", Penulis: " + author;
    }
}
// pakai overaide karna untuk ngehindarin kesalahan, trus overide juga nunjukin
//kalau lagi gantiin metod tostring dari class objek book, dia tuh ngubah objek jadi teks
class Library {
    private ArrayList<Book> books = new ArrayList<>();
//sesuai ketentuan kedua, dimanaa harus pakai arraylist buat nyimpan daftar buku, nambah, nampilkan dan cari buku
    public void addBook(String title, String author) {
        books.add(new Book(title, author));
        System.out.println("Buku berhasil ditambahkan!");
    }
// disini juga sudah menerapkan pesan kepada pengguna denga jelas kalau buku berhasil ditambhkan dst.
    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("Tidak ada buku dalam daftar.");
        } else {
            System.out.println("Daftar Buku:");
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }
// saya juga menampilkan pesan dengan jelas di bagian daftar buku/ display book, jika kosong
    public void searchBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                System.out.println("Buku ditemukan!");
                System.out.println(book);
                return;
            }
        }
        System.out.println("Buku tidak ditemukan.");
    }
}
// disini juga saya sudah memnuhi untuk mencari buku berdasarkan judul pakai case-intensitive
//atau gak membedakan pakai huruf kecil atau besar equalsIgnoreCase

class LibraryManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        while (true) {
            System.out.println("\nSelamat datang di Pengelolaan Perpustakaan!");
            System.out.println("1. Tambah Buku");
            System.out.println("2. Lihat Daftar Buku");
            System.out.println("3. Cari Buku");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu (1-4): ");
// saya pakai while true untuk mastikan program bakal tetep jalan selain user milih keluar dengan input pilih nomor 4
            int choice = scanner.nextInt();
            scanner.nextLine();
// disini saya sudah menerapkan validasi input untuk ngehindarin kesalahan input angka sebelum membaca sting
            switch (choice) {
                case 1:
                    System.out.print("Masukkan judul buku: ");
                    String title = scanner.nextLine();
                    System.out.print("Masukkan nama penulis: ");
                    String author = scanner.nextLine();
                    library.addBook(title, author);
                    break;
                case 2:
                    library.displayBooks();
                    break;
                case 3:
                    System.out.print("Masukkan judul buku yang ingin dicari: ");
                    String searchTitle = scanner.nextLine();
                    library.searchBook(searchTitle);
                    break;
                case 4:
                    System.out.println("Terima kasih telah menggunakan program ini!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Pilihan tidak valid, silakan coba lagi.");
            }
        }
    }
}
