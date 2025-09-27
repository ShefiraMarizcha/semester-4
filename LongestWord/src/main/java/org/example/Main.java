package org.example;
import java.util.Scanner;

class LongestWordFinder {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan kalimat: ");
        String sentence = scanner.nextLine();

        String longestWord = findLongestWord(sentence);
        System.out.println("Kata terpanjang: " + longestWord);

        scanner.close();
    }

    public static String findLongestWord(String sentence) {
        String[] words = sentence.split("\\s+");
        String longestWord = "";

        for (String word : words) {
            if (word.length() > longestWord.length()) {
                longestWord = word;
            }
        }

        return longestWord;
    }
}
