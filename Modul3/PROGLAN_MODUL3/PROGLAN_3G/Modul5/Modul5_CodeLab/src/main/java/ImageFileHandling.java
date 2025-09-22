import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageFileHandling {
    public static void main(String[] args) {
        try {
            // Membaca gambar
            File inputFile = new File("example.jpg");
            BufferedImage image = ImageIO.read(inputFile);
            System.out.println("Gambar berhasil dibaca. Dimensi: " + image.getWidth() + "x" + image.getHeight());

            // Menyimpan gambar
            File outputFile = new File("example_copy.jpg");
            ImageIO.write(image, "jpg", outputFile);
            System.out.println("Gambar berhasil disalin.");
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan: " + e.getMessage());
        }
    }
}
