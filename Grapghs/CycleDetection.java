import java.util.ArrayList;

public class CycleDetection {
    // use dfs, bfs, and DSU {Disjoint set detection} to detected cycle in
    // undirected graph
    // use dfs, bfs, and Topological Cost{Kahn's algo} to detected cycle in directed
    // graph
    // DFS is better then BFS
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

    public static void dfs(ArrayList<Edge>[] graph) {
        boolean vis[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            dfsUtil(graph, i, vis);
        }

    }

    public static void dfsUtil(ArrayList<Edge>[] graph, int curr, boolean vis[]) {
        if (vis[curr])
            return;
        System.out.println(curr + " ");
        vis[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vis[e.dest]) {
                dfsUtil(graph, e.dest, vis);

            }
        }
    }

    public static boolean detectCycle(ArrayList<Edge>[] graph) {
        boolean vis[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                if (detectCycleUtil(graph, vis, i, -1)) {
                    return true;

                }

            }
        }
        return false;
    }

    public static boolean detectCycleUtil(ArrayList<Edge>[] graph, boolean vis[], int curr, int parrent) {
        vis[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vis[e.dest] ) {
                if (detectCycleUtil(graph, vis, e.dest, curr)) {
                    return true;
                    
                }
                

            } else if (vis[e.dest] && e.dest != parrent) {
                return true;

            }
            // else{
            // continue;
            // }
        }
        return false;

    }

    @SuppressWarnings("unchecked")

    public static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1, 5));
        graph[1].add(new Edge(1, 0, 5));

        graph[1].add(new Edge(1, 2, 3));
        graph[1].add(new Edge(1, 3, 2));

        graph[2].add(new Edge(2, 1, 1));
        graph[2].add(new Edge(2, 3, 6));
        graph[2].add(new Edge(2, 4, 9));

        graph[3].add(new Edge(3, 2, 2));
        graph[3].add(new Edge(3, 1, 9));
        graph[3].add(new Edge(3, 4, 3));

        graph[4].add(new Edge(4, 3, 2));

    }

    @SuppressWarnings("unchecked")

    public static void main(String[] args) {
         int v = 5;
        ArrayList<Edge>[] graph = new ArrayList[v];

        createGraph(graph);

       System.out.println(detectCycle(graph)); //O(V+E) total for this 

    }

}
