import java.util.*;

public class DFS {

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

    public static void bfs(ArrayList<Edge>[] graph) { // O(V+E)
        Queue<Integer> q = new LinkedList<>();
        boolean vis[] = new boolean[graph.length];
        q.add(0); // src=0;

        while (!q.isEmpty()) {
            int curr = q.remove();
            if (!vis[curr]) {
                System.out.println(curr + " ");
                vis[curr] = true;
                // Adding neighbours

                for (int i = 0; i < graph[curr].size(); i++) {
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }

            }

        }

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

    public static void dfs(ArrayList<Edge>[] graph, int curr, boolean vis[]) {
        if (vis[curr])
            return;
        System.out.println(curr + " ");
        vis[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vis[e.dest]) {
                dfs(graph, e.dest, vis);

            }
        }
    }

    public static boolean hashPath(ArrayList<Edge>[]  graph,int src,int dest, boolean vis[]){

        if (src==dest) {
            return true;
        }
        vis[src]=true;
        for(int i=0; i<graph[src].size(); i++){
            Edge e=graph[src].get(i);
            if (!vis[e.dest] && hashPath(graph, e.dest, dest, vis)) {
                return true;
                
            }
        }


        return false;
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        int v = 5;
        ArrayList<Edge>[] graph = new ArrayList[v];

        createGraph(graph);

        // bfs(graph);
        // dfs(graph, 0, new boolean[v]);

        System.out.println(hashPath(graph, 0, 2, new boolean[v]));;

    }
}

/*
 * 
 * import java.util.*;
 * 
 * public class DFS {
 * 
 * static class Edge {
 * int src;
 * int dest;
 * int wt;
 * 
 * public Edge(int src, int dest, int wt) {
 * this.src = src;
 * this.dest = dest;
 * this.wt = wt;
 * }
 * }
 * 
 * // BFS (O(V + E))
 * public static void bfs(ArrayList<Edge>[] graph) {
 * Queue<Integer> q = new LinkedList<>();
 * boolean vis[] = new boolean[graph.length];
 * q.add(0); // start from node 0
 * 
 * System.out.print("BFS: ");
 * while (!q.isEmpty()) {
 * int curr = q.remove();
 * if (!vis[curr]) {
 * System.out.print(curr + " ");
 * vis[curr] = true;
 * 
 * // enqueue neighbours that are not yet visited
 * for (int i = 0; i < graph[curr].size(); i++) {
 * Edge e = graph[curr].get(i);
 * if (!vis[e.dest]) {
 * q.add(e.dest);
 * }
 * }
 * }
 * }
 * System.out.println();
 * }
 * 
 * @SuppressWarnings("unchecked")
 * public static void createGraph(ArrayList<Edge>[] graph) {
 * for (int i = 0; i < graph.length; i++) {
 * graph[i] = new ArrayList<>();
 * }
 * 
 * // Add undirected edges (both directions) with consistent weights
 * graph[0].add(new Edge(0, 1, 5));
 * graph[1].add(new Edge(1, 0, 5));
 * 
 * graph[1].add(new Edge(1, 2, 3));
 * graph[2].add(new Edge(2, 1, 3));
 * 
 * graph[1].add(new Edge(1, 3, 2));
 * graph[3].add(new Edge(3, 1, 2));
 * 
 * graph[2].add(new Edge(2, 3, 6));
 * graph[3].add(new Edge(3, 2, 6));
 * 
 * graph[2].add(new Edge(2, 4, 9));
 * graph[4].add(new Edge(4, 2, 9));
 * 
 * graph[3].add(new Edge(3, 4, 3));
 * graph[4].add(new Edge(4, 3, 3));
 * }
 * 
 * // DFS (recursive)
 * public static void dfs(ArrayList<Edge>[] graph, int curr, boolean vis[]) {
 * if (vis[curr]) return;
 * vis[curr] = true;
 * System.out.print(curr + " ");
 * 
 * for (int i = 0; i < graph[curr].size(); i++) {
 * Edge e = graph[curr].get(i);
 * if (!vis[e.dest]) {
 * dfs(graph, e.dest, vis);
 * }
 * }
 * }
 * 
 * @SuppressWarnings("unchecked")
 * public static void main(String[] args) {
 * int v = 5;
 * ArrayList<Edge>[] graph = new ArrayList[v];
 * 
 * createGraph(graph);
 * 
 * bfs(graph);
 * 
 * System.out.print("DFS: ");
 * dfs(graph, 0, new boolean[v]);
 * System.out.println();
 * }
 * }
 * 
 * 
 */