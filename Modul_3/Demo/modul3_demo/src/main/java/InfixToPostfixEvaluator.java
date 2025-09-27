import java.util.*;


public class InfixToPostfixEvaluator {

   // cek krkter mtk
    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    // prioritas, 2>1

    private static int getPrecedence(char op) {
        switch (op) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                return -1;
        }
    }

    // konvert  => Shunting-yard
    private static String infixToPostfix(String infix) {
        StringBuilder postfix = new StringBuilder();
        Deque<Character> stack = new ArrayDeque<>(); //  sementara


        for (int i = 0; i < infix.length(); i++) {
            char c = infix.charAt(i);

            if (Character.isWhitespace(c)) {
                continue; // ignore
            }

            if (Character.isLetterOrDigit(c)) { // 1/A => postfix
                postfix.append(c);
            } else if (c == '(') {
                stack.push(c); // ( = stack
            } else if (c == ')') {
                // ) smppai ktmu (
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(' ').append(stack.pop()); // + postfix
                }
                stack.pop(); // del ( sr stk
            } else if (isOperator(c)) {
                postfix.append(' ');

                // operasi > sama
                while (!stack.isEmpty() && getPrecedence(c) <= getPrecedence(stack.peek())) {
                    postfix.append(stack.pop()).append(' ');
                }

                stack.push(c);
            }
        }

        //  keluarkan all opr
        while (!stack.isEmpty()) {
            postfix.append(' ').append(stack.pop());
        }

        return postfix.toString();
    }

    // eval eks p > s
    private static int evaluatePostfix(String postfix) {
        Deque<Integer> stack = new ArrayDeque<>(); // smntara
        Scanner tokenizer = new Scanner(postfix); // pisah


        while (tokenizer.hasNext()) {
            if (tokenizer.hasNextInt()) {
                //1 masuk stk
                stack.push(tokenizer.nextInt());
            } else {
                //oprtr= ambl 2 stk
                String op = tokenizer.next();
                int operand2 = stack.pop();   //ats
                int operand1 = stack.pop();   // first
                int result = 0;

                //lakkn opr = input
                switch (op) {
                    case "+":
                        result = operand1 + operand2;
                        break;
                    case "-":
                        result = operand1 - operand2;
                        break;
                    case "*":
                        result = operand1 * operand2;
                        break;
                    case "/":
                        result = operand1 / operand2;
                        break;
                }

                //hasil
                stack.push(result);
            }
        }


        return stack.pop();
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Masukkan ekspresi infix (gunakan spasi antar token, contoh: 3 + 4 * 2 / ( 1 - 5 )): ");
        String infixExpression = scanner.nextLine(); // Baca

        // Konvers
        String postfixExpression = infixToPostfix(infixExpression);

        // Eval
        int result = evaluatePostfix(postfixExpression);


        System.out.println("Ekspresi Postfix : " + postfixExpression);
        System.out.println("Hasil Evaluasi   : " + result);

        scanner.close();
    }
}
