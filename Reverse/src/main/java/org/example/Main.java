package org.example;
import java.util.Scanner;

class ReverseString {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan kata atau kalimat: ");
        String input = scanner.nextLine();

        String reversed = reverseString(input);
        System.out.println("Hasil dibalik: " + reversed);

        scanner.close();
    }

    public static String reverseString(String str) {
        StringBuilder reversed = new StringBuilder(str);
        return reversed.reverse().toString();
    }
}
