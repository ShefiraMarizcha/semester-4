package org.example;

class PalindromeChecker {

    public static <Scanner> void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan kata: ");
        String input = scanner.nextLine();

        if (isPalindrome(input)) {
            System.out.println(input + " adalah palindrome.");
        } else {
            System.out.println(input + " bukan palindrome.");
        }

        scanner.close();
    }

    public static boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            // Lewati karakter non-alfanumerik
            while (left < right && !Character.isLetterOrDigit(str.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(str.charAt(right))) {
                right--;
            }

            // Bandingkan karakter dari depan dan belakang
            if (Character.toLowerCase(str.charAt(left)) != Character.toLowerCase(str.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
