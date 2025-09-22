import java.util.Random;
import java.util.Scanner;

public class RandomSelection {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int choice;

        do {
            // Menampilkan menu
            System.out.println("Menu:");
            System.out.println("1. Menghasilkan Bilangan Bulat Acak");
            System.out.println("2. Memilih Elemen Acak dari Array");
            System.out.println("3. Keluar");
            System.out.print("Pilihan: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Membersihkan buffer input

            switch (choice) {
                case 1:
                    // Menghasilkan Bilangan Bulat Acak
                    System.out.print("Masukkan nilai minimum: ");
                    int min = scanner.nextInt();
                    System.out.print("Masukkan nilai maksimum: ");
                    int max = scanner.nextInt();

                    // Memastikan min < max
                    if (min > max) {
                        System.out.println("Nilai minimum harus lebih kecil dari nilai maksimum.");
                    } else {
                        int randomNumber = random.nextInt((max - min) + 1) + min;
                        System.out.println("Bilangan bulat acak antara " + min + " dan " + max + ": " + randomNumber);
                    }
                    break;

                case 2:
                    // Memilih Elemen Acak dari Array
                    System.out.print("Masukkan jumlah elemen dalam array: ");
                    int numElements = scanner.nextInt();
                    scanner.nextLine();  // Membersihkan buffer

                    if (numElements > 0) {
                        String[] elements = new String[numElements];
                        for (int i = 0; i < numElements; i++) {
                            System.out.print("Masukkan elemen ke-" + (i + 1) + ": ");
                            elements[i] = scanner.nextLine();
                        }

                        // Memilih elemen acak dari array
                        String randomElement = elements[random.nextInt(numElements)];
                        System.out.println("Elemen acak dari array: " + randomElement);
                    } else {
                        System.out.println("Jumlah elemen harus lebih dari 0.");
                    }
                    break;

                case 3:
                    System.out.println("Keluar dari program.");
                    break;

                default:
                    System.out.println("Pilihan tidak valid.");
            }
            System.out.println();
        } while (choice != 3);

        scanner.close();
    }
}
