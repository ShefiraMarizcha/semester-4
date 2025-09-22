import java.util.Scanner;

public class RataRataKecepatan {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Meminta jarak tempuh
        System.out.print("Masukkan jarak tempuh (dalam kilometer): ");
        double jarak = input.nextDouble();

        // Meminta waktu tempuh
        System.out.print("Masukkan waktu tempuh (dalam jam): ");
        double waktu = input.nextDouble();

        // Menghitung kecepatan rata-rata
        double kecepatanRataRata = jarak / waktu;

        // Menampilkan hasil
        System.out.println("Kecepatan rata-rata: " + kecepatanRataRata + " km/jam");

        input.close();
    }
}
