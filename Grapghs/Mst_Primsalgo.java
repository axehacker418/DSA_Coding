import java.util.ArrayList;
import java.util.PriorityQueue;

public class Mst_Primsalgo {

    static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int sec, int dest, int wt) {
            this.src = sec;
            this.dest = dest;
            this.wt = wt;
        }

    }

    public static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // We'll use an undirected (symmetric) example here:
        // 0 <-> 1 (5)
        graph[0].add(new Edge(0, 1, 5));
        graph[1].add(new Edge(1, 0, 5));

        // 1 <-> 2 (3)
        graph[1].add(new Edge(1, 2, 3));
        graph[2].add(new Edge(2, 1, 3));

        // 1 <-> 3 (2)
        graph[1].add(new Edge(1, 3, 2));
        graph[3].add(new Edge(3, 1, 2));

        // 2 <-> 3 (2)
        graph[2].add(new Edge(2, 3, 2));
        graph[3].add(new Edge(3, 2, 2));

        // 2 <-> 4 (9)
        graph[2].add(new Edge(2, 4, 9));
        graph[4].add(new Edge(4, 2, 9));

        // 3 <-> 4 (3)
        graph[3].add(new Edge(3, 4, 3));
        graph[4].add(new Edge(4, 3, 3));
    }

    static class Pair implements Comparable<Pair> {
        int v;
        int cost;

        public Pair(int v, int c) {
            this.v = v;
            this.cost = c;
        }

        @Override
        public int compareTo(Pair p2) {
            return this.cost - p2.cost;
        }

    }

    public static void prims(ArrayList<Edge>[] graph) {
        boolean visited[] = new boolean[graph.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0, 0));
        int finalcost = 0;
        while (!pq.isEmpty()) {
            Pair curr = pq.remove();
            if (!visited[curr.v]) {
                visited[curr.v] = true;
                finalcost += curr.cost;

                for (int i = 0; i < graph[curr.v].size(); i++) {
                    Edge e = graph[curr.v].get(i);
                    pq.add(new Pair(e.dest, e.wt));
                }

            }

        }
        System.out.println("final cost of mst is " + finalcost);

    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        int v = 5;
        ArrayList<Edge>[] graph = new ArrayList[v];
        createGraph(graph);

        prims(graph);

    }

}
