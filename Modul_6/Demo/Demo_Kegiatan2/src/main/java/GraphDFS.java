import java.util.*;

public class GraphDFS {
    static class Graph {
        private Map<String, List<String>> adjList = new HashMap<>();

        public void addEdge(String src, String dest) {
            adjList.computeIfAbsent(src, k -> new ArrayList<>()).add(dest);
            adjList.computeIfAbsent(dest, k -> new ArrayList<>()).add(src); // karena graf tidak berarah
        }

        public boolean dfs(String start, String target, Set<String> visited) {
            if (start.equals(target)) {
                System.out.println("Ditemukan node: " + target);
                return true;
            }

            visited.add(start);
            System.out.println("Mengunjungi: " + start);

            for (String neighbor : adjList.getOrDefault(start, new ArrayList<>())) {
                if (!visited.contains(neighbor)) {
                    if (dfs(neighbor, target, visited)) {
                        return true;
                    }
                }
            }

            return false;
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph();

        // Tambahkan edge berdasarkan tabel
        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.addEdge("B", "D");
        graph.addEdge("C", "D");
        graph.addEdge("C", "E");
        graph.addEdge("C", "F");
        graph.addEdge("C", "G");
        graph.addEdge("D", "G");
        graph.addEdge("E", "F");
        graph.addEdge("F", "G");

        Set<String> visited = new HashSet<>();
        boolean found = graph.dfs("A", "E", visited);

        if (!found) {
            System.out.println("Node E tidak ditemukan.");
        }
    }
}
