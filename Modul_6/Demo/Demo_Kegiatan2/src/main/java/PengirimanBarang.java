import java.util.*;

public class PengirimanBarang {
    static int[][] adjacencyMatrix = new int[8][8];
    static String[] kota = {"0", "1", "2", "3", "4", "5", "6", "7"};

    public static void main(String[] args) {
        // Inisialisasi graf (directed)
        addEdge(0, 1); // A → B
        addEdge(0, 2); // A → C
        addEdge(1, 3); // B → D
        addEdge(1, 4); // B → E
        addEdge(2, 5); // C → F
        addEdge(3, 6); // D → G
        addEdge(4, 6); // E → G
        addEdge(5, 7); // F → H
        addEdge(6, 7); // G → H
        addEdge(7, 0); // H → A

        System.out.println("Adjacency Matrix:");
        printMatrix();

        System.out.print("\nBFS Traversal dari A: ");
        bfs(1);

        System.out.print("\nDFS Traversal dari A: ");
        boolean[] visited = new boolean[8];
        dfs(0, visited);
    }

    static void addEdge(int from, int to) {
        adjacencyMatrix[from][to] = 1;
    }

    static void printMatrix() {
        System.out.print("  ");
        for (String k : kota) System.out.print(k + " ");
        System.out.println();
        for (int i = 0; i < 8; i++) {
            System.out.print(kota[i] + " ");
            for (int j = 0; j < 8; j++) {
                System.out.print(adjacencyMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void bfs(int start) {
        boolean[] visited = new boolean[8];
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.add(start);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(kota[node] + " ");
            for (int i = 0; i < 8; i++) {
                if (adjacencyMatrix[node][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }

    static void dfs(int node, boolean[] visited) {
        visited[node] = true;
        System.out.print(kota[node] + " ");
        for (int i = 0; i < 8; i++) {
            if (adjacencyMatrix[node][i] == 1 && !visited[i]) {
                dfs(i, visited);
            }
        }
    }
}
