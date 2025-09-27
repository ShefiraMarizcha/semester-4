import java.util.Scanner;
import java.util.Stack;

public class ValidasiKurung {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan ekspresi matematika: ");
        String ekspresi = scanner.nextLine();

        if (isValid(ekspresi)) {
            System.out.println("→ VALID");
        } else {
            System.out.println("→ TIDAK VALID");
        }

        scanner.close();
    }

    public static boolean isValid(String ekspresi) {
        Stack<Character> stack = new Stack<>();

        for (char ch : ekspresi.toCharArray()) {
            if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                if (stack.isEmpty()) {
                    return false; // ada penutup tanpa pembuka
                }
                stack.pop();
            }
        }

        return stack.isEmpty(); // jika kosong berarti semua kurung seimbang
    }
}
