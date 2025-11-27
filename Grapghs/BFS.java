// TO implement  a BFS search into a graph 

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {

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

    public static void bfs(ArrayList<Edge>[] graph) { //O(V+E) 
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

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        int v = 5;
        ArrayList<Edge>[] graph = new ArrayList[v];

        createGraph(graph);

        bfs(graph);

    }

}
