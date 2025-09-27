import java.util.*;

public class LogisticCompany {
    private int V; // Jumlah vertex (gudang)
    private LinkedList<Integer> adj[]; // Adjacency List untuk representasi graph

    // Constructor
    LogisticCompany(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; ++i)
            adj[i] = new LinkedList();
    }

    // Menambahkan edge ke graph
    void addEdge(int v,int w) {
        adj[v].add(w); // Add w to v's list.
    }

    // BFS traversal dari source vertex s
    void BFS(int s) {
        // Array untuk menandai vertex yang sudah dikunjungi
        boolean visited[] = new boolean[V];

        // Queue untuk BFS
        LinkedList<Integer> queue = new LinkedList<Integer>();

        // Tandai vertex saat ini sebagai sudah dikunjungi dan tambahkan ke queue
        visited[s]=true;
        queue.add(s);

        while (queue.size() != 0) {
            // Dequeue vertex dari queue dan print
            s = queue.poll();
            System.out.print(s+" ");

            // Ambil semua vertex yang berdekatan dari vertex dequeued ini.
            // Jika vertex yang belum pernah dikunjungi, maka tandai sebagai sudah dikunjungi dan tambahkan ke queue
            Iterator<Integer> i = adj[s].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    // DFS traversal dari vertex s
    void DFSUtil(int v,boolean visited[]) {
        // Tandai vertex saat ini sebagai sudah dikunjungi dan print
        visited[v] = true;
        System.out.print(v+" ");

        // Rekursi untuk semua vertex yang berdekatan dari vertex ini
        Iterator<Integer> i = adj[v].listIterator();
        while (i.hasNext()) {
            int n = i.next();
            if (!visited[n])
                DFSUtil(n, visited);
        }
    }

    // DFS traversal dari vertex s
    void DFS(int s) {
        // Array untuk menandai vertex yang sudah dikunjungi
        boolean visited[] = new boolean[V];

        // Panggil util function DFSUtil untuk print DFS traversal
        DFSUtil(s, visited);
    }

    // Main method untuk menguji graph yang dibuat
    public static void main(String args[]) {
        LogisticCompany g = new LogisticCompany(5);

        // Menambahkan edge untuk graph yang dibuat
        g.addEdge(0, 1);
        g.addEdge(0, 4);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 3);
        g.addEdge(3, 4);

        // Tampilkan adjacency matrix
        System.out.println("Adjacency Matrix:");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (g.adj[i].contains(j))
                    System.out.print("1 ");
                else
                    System.out.print("0 ");
            }
            System.out.println();
        }

        System.out.println("\nBFS traversal dari vertex 0:");
        g.BFS(0);

        System.out.println("\n\nDFS traversal dari vertex 0:");
        g.DFS(0);
    }
}
