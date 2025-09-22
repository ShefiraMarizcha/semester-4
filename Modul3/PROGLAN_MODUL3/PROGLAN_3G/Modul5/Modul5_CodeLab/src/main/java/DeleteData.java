import java.io.*;

class DeleteData {
    public static void main(String[] args) {
        try {
            // File input (data yang akan diproses) dan file sementara (untuk menyimpan hasil)
            File inputFile = new File("data_java.txt");
            File tempFile = new File("temp.txt");

            // Membaca file input menggunakan BufferedReader
            BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFile));
            PrintWriter printWriter = new PrintWriter(new FileWriter(tempFile));

            // Data yang ingin dihapus
            String lineToRemove = "John Doe, 12345, 3";
            String line;

            // Membaca setiap baris dalam file input
            while ((line = bufferedReader.readLine()) != null) {
                // Menulis baris yang tidak sesuai dengan data yang ingin dihapus
                if (!line.equals(lineToRemove)) {
                    printWriter.println(line);
                }
            }

            // Menutup file setelah selesai
            printWriter.close();
            bufferedReader.close();

            // Menghapus file lama dan mengganti dengan file sementara
            inputFile.delete();
            tempFile.renameTo(inputFile);

            // Menampilkan pesan berhasil
            System.out.println("Data berhasil dihapus.");

        } catch (IOException e) {
            // Menangani kesalahan
            System.out.println("Terjadi kesalahan: " + e.getMessage());
        }
    }
}
