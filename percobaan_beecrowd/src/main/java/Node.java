import java.util.*;

class GrowingStringsTrieDFS {
    static class Node {
        Map<Character, Node> children = new HashMap<>();
        int index = -1;
    }

    static String[] strings;
    static int maxLen;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int n = Integer.parseInt(sc.nextLine());
            if (n == 0) break;
            strings = new String[n];
            for (int i = 0; i < n; i++) strings[i] = sc.nextLine();

            maxLen = 0;
            for (int i = 0; i < n; i++) {
                boolean[] visited = new boolean[n];
                dfs(i, 1, visited);
            }
            System.out.println(maxLen);
        }
    }

    static void dfs(int current, int length, boolean[] visited) {
        visited[current] = true;
        maxLen = Math.max(maxLen, length);
        for (int i = 0; i < strings.length; i++) {
            if (!visited[i] && strings[i].contains(strings[current]))
                dfs(i, length + 1, visited);
        }
        visited[current] = false;
    }
}
