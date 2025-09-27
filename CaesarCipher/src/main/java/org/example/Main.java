package org.example;
import java.util.Scanner;

class CaesarCipher {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan teks: ");
        String text = scanner.nextLine();

        System.out.print("Masukkan pergeseran: ");
        int shift = scanner.nextInt();

        String encryptedText = encrypt(text, shift);
        String decryptedText = decrypt(encryptedText, shift);

        System.out.println("Teks terenkripsi: " + encryptedText);
        System.out.println("Teks terdekripsi: " + decryptedText);

        scanner.close();
    }

    public static String encrypt(String text, int shift) {
        StringBuilder encrypted = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (Character.isLetter(c)) {
                char base = Character.isLowerCase(c) ? 'a' : 'A';
                c = (char) ((c - base + shift) % 26 + base);
            }
            encrypted.append(c);
        }

        return encrypted.toString();
    }

    public static String decrypt(String text, int shift) {
        return encrypt(text, 26 - shift);
    }
}
