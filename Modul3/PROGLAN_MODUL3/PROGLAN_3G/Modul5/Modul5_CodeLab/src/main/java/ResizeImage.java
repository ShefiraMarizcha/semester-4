import net.coobird.thumbnailator.Thumbnails;
import java.io.File;
import java.io.IOException;

public class ResizeImage {
    public static void main(String[] args) {
        try {
            // Mengubah ukuran gambar
            Thumbnails.of("example.jpg")
                    .size(100, 100)
                    .toFile(new File("example_resized.jpg"));
            System.out.println("Gambar berhasil diubah ukurannya.");
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan: " + e.getMessage());
        }
    }
}
