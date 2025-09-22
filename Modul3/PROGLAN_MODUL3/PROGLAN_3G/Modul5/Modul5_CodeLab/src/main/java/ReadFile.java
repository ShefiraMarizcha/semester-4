import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class ReadFile {
    public static void main(String[] args) {
        try {
            // Membuka file dengan nama "data_java.txt"
            File file = new File("data_java.txt");

            // Membaca isi file menggunakan Scanner
            Scanner dataReader = new Scanner(file);

            // Membaca setiap baris dalam file dan mencetaknya
            while (dataReader.hasNextLine()) {
                String fileData = dataReader.nextLine();
                System.out.println(fileData);
            }

            // Menutup Scanner setelah selesai
            dataReader.close();

        } catch (FileNotFoundException exception) {
            // Menangani jika file tidak ditemukan
            System.out.println("File tidak ditemukan: " + exception.getMessage());
        }
    }
}
