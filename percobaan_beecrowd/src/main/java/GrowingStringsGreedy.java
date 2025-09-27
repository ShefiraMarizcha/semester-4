import java.util.*;

public class GrowingStringsGreedy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int n = Integer.parseInt(sc.nextLine());
            if (n == 0) break;
            String[] s = new String[n];
            for (int i = 0; i < n; i++) s[i] = sc.nextLine();
            Arrays.sort(s, Comparator.comparingInt(String::length));

            int[] dp = new int[n];
            Arrays.fill(dp, 1);
            int max = 1;

            for (int i = 1; i < n; i++) {
                for (int j = 0; j < i; j++) {
                    if (s[i].contains(s[j])) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
                max = Math.max(max, dp[i]);
            }

            System.out.println(max);
        }
    }
}
