import java.io.FileWriter;
import java.io.IOException;

class UpdateFile {
    public static void main(String[] args) {
        try {
            // Membuka file untuk ditambahkan data (append: true)
            FileWriter fileWriter = new FileWriter("data_java.txt", true);

            // Menambahkan data baru ke dalam file
            fileWriter.write("John Doe, 12345, 3\n");

            // Menutup file writer setelah selesai
            fileWriter.close();

            // Menampilkan pesan berhasil
            System.out.println("Data berhasil ditambahkan.");
        } catch (IOException e) {
            // Menangani kesalahan jika terjadi
            System.out.println("Terjadi kesalahan: " + e.getMessage());
        }
    }
}
