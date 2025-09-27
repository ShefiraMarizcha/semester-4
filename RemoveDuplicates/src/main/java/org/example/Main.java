package org.example;
import java.util.Scanner;
import java.util.LinkedHashSet;
import java.util.Set;

class RemoveDuplicates {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan kata atau kalimat: ");
        String input = scanner.nextLine();

        String result = removeDuplicates(input);
        System.out.println("Hasil setelah menghapus karakter duplikat: " + result);

        scanner.close();
    }

    public static String removeDuplicates(String str) {
        Set<Character> seen = new LinkedHashSet<>();
        StringBuilder result = new StringBuilder();

        for (char c : str.toCharArray()) {
            if (seen.add(c)) {
                result.append(c);
            }
        }

        return result.toString();
    }
}
