import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class ReplaceNegativeNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] X = new int[10];

        // Read 10 integers and replace null (0) or negative numbers with 1
        for (int i = 0; i < 10; i++) {
            X[i] = Integer.parseInt(reader.readLine());
            if (X[i] <= 0) {
                X[i] = 1;
            }
        }

        // Print the results
        for (int i = 0; i < 10; i++) {
            System.out.println("X[" + i + "] = " + X[i]);
        }
    }
}