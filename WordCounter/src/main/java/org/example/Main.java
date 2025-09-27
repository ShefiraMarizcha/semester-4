package org.example;
import java.util.Scanner;

class WordCounter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan kalimat: ");
        String sentence = scanner.nextLine();

        int wordCount = countWords(sentence);
        System.out.println("Jumlah kata dalam kalimat: " + wordCount);

        scanner.close();
    }

    public static int countWords(String sentence) {
        if (sentence == null || sentence.isEmpty()) {
            return 0;
        }

        String[] words = sentence.trim().split("\\s+");
        return words.length;
    }
}
