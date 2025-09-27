package org.example;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class CharacterFrequency {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan kata atau kalimat: ");
        String input = scanner.nextLine();

        Map<Character, Integer> frequencyMap = countCharacterFrequency(input);
        System.out.println("Frekuensi kemunculan setiap karakter: " + frequencyMap);

        scanner.close();
    }

    public static Map<Character, Integer> countCharacterFrequency(String str) {
        Map<Character, Integer> frequencyMap = new HashMap<>();

        for (char c : str.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        return frequencyMap;
    }
}
