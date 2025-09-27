class Graph {
    private int vertices;
    private LinkedList<Integer>[] adjacencyList;

    Graph(int v) {
        vertices = v;
        adjacencyList = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
    }

    void addEdge(int src, int dest) {
        adjacencyList[src].add(dest);
    }

    void printGraph() {
        for (int i = 0; i < vertices; i++) {
            System.out.print("Vertex " + i + ": ");
            for (Integer node : adjacencyList[i]) {
                System.out.print("-> " + node + " ");
            }
            System.out.println();
        }
    }
}
