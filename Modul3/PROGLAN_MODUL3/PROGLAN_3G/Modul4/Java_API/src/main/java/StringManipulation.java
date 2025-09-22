import java.util.Scanner;
import java.lang.String;
import java.lang.StringBuilder;

public class StringManipulation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan sebuah kalimat: ");
        String input = scanner.nextLine();

        // Menampilkan kalimat dalam huruf kapital semua
        System.out.println("Huruf kapital: " + input.toUpperCase());

        // Mengganti kata dalam kalimat
        System.out.print("Masukkan kata yang ingin diganti: ");
        String oldWord = scanner.nextLine();
        System.out.print("Masukkan kata pengganti: ");
        String newWord = scanner.nextLine();
        String replacedString = input.replace(oldWord, newWord);
        System.out.println("Setelah mengganti kata: " + replacedString);

        // Membalikkan kalimat
        StringBuilder reversedString = new StringBuilder(input);
        System.out.println("Kalimat terbalik: " + reversedString.reverse().toString());

        scanner.close();
    }
}
