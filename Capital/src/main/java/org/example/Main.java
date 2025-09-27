package org.example;
import java.util.Scanner;

class CapitalizeWords {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan kalimat: ");
        String sentence = scanner.nextLine();

        String capitalizedSentence = capitalizeWords(sentence);
        System.out.println("Kalimat setelah mengubah huruf pertama setiap kata menjadi huruf besar: " + capitalizedSentence);

        scanner.close();
    }

    public static String capitalizeWords(String sentence) {
        String[] words = sentence.split("\\s+");
        StringBuilder capitalizedSentence = new StringBuilder();

        for (String word : words) {
            if (word.length() > 0) {
                capitalizedSentence.append(Character.toUpperCase(word.charAt(0)))
                        .append(word.substring(1).toLowerCase())
                        .append(" ");
            }
        }

        return capitalizedSentence.toString().trim();
    }
}
