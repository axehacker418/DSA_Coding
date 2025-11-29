import java.util.*;

public class TopologicalSortingDFS {

    static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }

    @SuppressWarnings("unchecked")
    public static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // Directed edges for topological sorting
        graph[5].add(new Edge(5, 0, 0));
        graph[5].add(new Edge(5, 2, 0));
        graph[4].add(new Edge(4, 0, 0));
        graph[4].add(new Edge(4, 1, 0));
        graph[2].add(new Edge(2, 3, 0));
        graph[3].add(new Edge(3, 1, 0));
    }

    // DFS-based topological sort
    public static void topoDFS(ArrayList<Edge>[] graph, int curr, boolean vis[], Stack<Integer> stack) {
        vis[curr] = true;

        for (Edge e : graph[curr]) {
            if (!vis[e.dest]) {
                topoDFS(graph, e.dest, vis, stack);
            }
        }

        // Push node AFTER exploring its neighbors
        stack.push(curr);
    }

    public static void topologicalSort(ArrayList<Edge>[] graph) {
        boolean vis[] = new boolean[graph.length];
        Stack<Integer> stack = new Stack<>();

        // Run DFS from every unvisited node
        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                topoDFS(graph, i, vis, stack);
            }
        }

        // Print result
        System.out.print("Topological Order: ");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
        System.out.println();
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        int v = 6;
        ArrayList<Edge>[] graph = new ArrayList[v];

        createGraph(graph);
        topologicalSort(graph);
    }
}
