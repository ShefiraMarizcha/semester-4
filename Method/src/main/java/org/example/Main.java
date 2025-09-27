package org.example;
import java.util.Scanner;

class SentenceFormatter {

    public String formatSentence(String sentence) {
        if (sentence == null || sentence.isEmpty()) {
            return sentence;
        }

        String[] words = sentence.toLowerCase().split("\\s+");
        StringBuilder formattedSentence = new StringBuilder();

        for (String word : words) {
            if (word.length() > 0) {
                formattedSentence.append(Character.toUpperCase(word.charAt(0)))
                        .append(word.substring(1))
                        .append(" ");
            }
        }

        return formattedSentence.toString().trim();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SentenceFormatter formatter = new SentenceFormatter();

        System.out.print("Masukkan kalimat: ");
        String input = scanner.nextLine();

        String formatted = formatter.formatSentence(input);

        System.out.println("Sebelum: " + input);
        System.out.println("Sesudah: " + formatted);

        scanner.close();
    }
}
