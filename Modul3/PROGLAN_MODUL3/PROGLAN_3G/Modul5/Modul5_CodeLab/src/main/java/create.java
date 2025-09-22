import java.io.*;

class CreateFile {
    public static void main(String[] args) {
        try {
            // Membuat file writer dengan nama file "data_java.txt"
            FileWriter fileWriter = new FileWriter("data_java.txt");

            // Menulis data ke dalam file
            fileWriter.write("Nama, NIM, Semester\n");

            // Menutup file writer
            fileWriter.close();

            // Menampilkan pesan berhasil
            System.out.println("File berhasil dibuat.");
        } catch (IOException e) {
            // Menangani jika terjadi kesalahan saat membuat atau menulis file
            System.out.println("Terjadi kesalahan: " + e.getMessage());
        }
    }
}
