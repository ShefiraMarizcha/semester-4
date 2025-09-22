import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;

public class CopyMoveImage {
    public static void main(String[] args) {
        try {
            // Menyalin gambar
            File sourceFile = new File("example.jpg");
            File destFile = new File("example_copy.jpg");
            FileUtils.copyFile(sourceFile, destFile);
            System.out.println("Gambar berhasil disalin.");

            // Memindahkan gambar
            File movedFile = new File("moved_example.jpg");
            FileUtils.moveFile(destFile, movedFile);
            System.out.println("Gambar berhasil dipindahkan.");
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan: " + e.getMessage());
        }
    }
}
