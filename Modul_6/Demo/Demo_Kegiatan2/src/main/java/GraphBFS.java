import java.util.*;

public class GraphBFS {
    private Map<String, List<String>> adjList;

    public GraphBFS() {
        adjList = new HashMap<>();
    }

    // Menambahkan edge dua arah (graf tidak berarah)
    public void addEdge(String source, String dest) {
        adjList.putIfAbsent(source, new ArrayList<>());
        adjList.putIfAbsent(dest, new ArrayList<>());

        adjList.get(source).add(dest);
        adjList.get(dest).add(source);
    }

    // BFS untuk mencari node target dari node awal
    public void bfs(String start, String target) {
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.add(start);
        visited.add(start);

        System.out.print("Node yang dilewati: ");
        while (!queue.isEmpty()) {
            String current = queue.poll();
            System.out.print(current + " ");

            if (current.equals(target)) {
                System.out.println("\nKey \"" + target + "\" ditemukan.");
                return;
            }

            for (String neighbor : adjList.getOrDefault(current, new ArrayList<>())) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }

        System.out.println("\nKey \"" + target + "\" tidak ditemukan.");
    }

    public static void main(String[] args) {
        GraphBFS graph = new GraphBFS();

        // Menambahkan edge sesuai tabel transisi
        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.addEdge("B", "A");
        graph.addEdge("B", "D");
        graph.addEdge("C", "A");
        graph.addEdge("C", "D");
        graph.addEdge("C", "E");
        graph.addEdge("C", "F");
        graph.addEdge("C", "G");
        graph.addEdge("D", "B");
        graph.addEdge("D", "C");
        graph.addEdge("E", "C");
        graph.addEdge("F", "C");
        graph.addEdge("G", "C");

        // Jalankan BFS dari A untuk mencari node E
        graph.bfs("A", "E");
    }
}
