package org.example;
import java.util.Scanner;

class VowelCounter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan kata atau kalimat: ");
        String input = scanner.nextLine();

        int vowelCount = countVowels(input);
        System.out.println("Jumlah huruf vokal: " + vowelCount);

        scanner.close();
    }

    public static int countVowels(String str) {
        int count = 0;
        String vowels = "aeiouAEIOU"; // Huruf vokal dalam huruf kecil dan besar

        for (int i = 0; i < str.length(); i++) {
            if (vowels.indexOf(str.charAt(i)) != -1) {
                count++;
            }
        }

        return count;
    }
}
