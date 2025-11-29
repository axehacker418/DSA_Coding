// import java.util.ArrayList;
// import java.util.PriorityQueue;

// public class DijkistrasAlgo {

//     static class  Edge {
//         int src;
//         int dest;
//         int wt;
//         public Edge(int src,int dest,int wt){
//             this.src=src;
//             this.dest=dest;
//             this.wt=wt;
//         }
//     }

//     static class  Pair implements Comparable<Pair>{
//         int n;
//         int path;
//         public Pair(int n, int path){
//             this.n=n;
//             this.path=path;
//         }

//         @Override // when we implement comparable interface  override compareto function beacuse parameter not defined 
//         public int compareTo(Pair p2){
//             return this.path - p2.path;
//         }
    
        
//     }
//     public static void disikstras(ArrayList<Edge>[] graph, int src){
//         int dist[]=new int[graph.length];

//         for(int i=0; i<graph.length; i++){
//             if (i!=src) {
//                 dist[i]=Integer.MAX_VALUE;
                
//             }
//         }
//         boolean[] vis=new boolean[graph.length];
//         PriorityQueue<Pair> pq=new PriorityQueue<>();
//         pq.add(new Pair(src, 0));
//         while (!pq.isEmpty()) {
//             Pair curr=pq.remove();
//             if (vis[curr.n]) {
//                 vis[curr.n]=true;
//                 for(int i=0; i<graph[curr.n].size(); i++){
//                     Edge e= graph[curr.n].get(i);
//                     int u=e.src;
//                     int v=e.dest;
//                     int wt=e.wt;
//                     if (dist[u]+wt < dist[v]) {
//                         dist[v]=dist[u]+wt;
//                         pq.add(new Pair(v, dist[v]));
                        
//                     }
//                 }
                
//             }
            
//         }
//         //print all sorce to vertices sortest dist 
//         for(int i=0 ; i<dist.length; i++){
//             System.out.print(dist[i]+" ");
//         }
//         System.out.println();

//     }

    
//     public static void createGraph(ArrayList<Edge>[] graph) {
//         for (int i = 0; i < graph.length; i++) {
//             graph[i] = new ArrayList<>();
//         }

//         graph[0].add(new Edge(0, 1, 5));
//         graph[1].add(new Edge(1, 0, 5));

//         graph[1].add(new Edge(1, 2, 3));
//         graph[1].add(new Edge(1, 3, 2));

//         graph[2].add(new Edge(2, 1, 1));
//         graph[2].add(new Edge(2, 3, 6));
//         graph[2].add(new Edge(2, 4, 9));

//         graph[3].add(new Edge(3, 2, 2));
//         graph[3].add(new Edge(3, 1, 9));
//         graph[3].add(new Edge(3, 4, 3));

//         graph[4].add(new Edge(4, 3, 2));
//     }

//   public static void main(String[] args) {
//     int v=5;
//     ArrayList<Edge> graph[]=new ArrayList[v];
//     createGraph(graph);
//     int src=0; 
//     disikstras(graph, src);
    
//   }
    
// }



import java.util.ArrayList;
import java.util.PriorityQueue;

public class DijkstrasAlgo {

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

    static class Pair implements Comparable<Pair> {
        int node;
        int distSoFar;
        public Pair(int node, int distSoFar) {
            this.node = node;
            this.distSoFar = distSoFar;
        }

        @Override
        public int compareTo(Pair other) {
            return Integer.compare(this.distSoFar, other.distSoFar);
        }
    }

    public static void dijkstra(ArrayList<Edge>[] graph, int src) {
        int n = graph.length;
        int[] dist = new int[n];
        boolean[] vis = new boolean[n];

        // initialize distances
        for (int i = 0; i < n; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[src] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src, 0));

        while (!pq.isEmpty()) {
            Pair curr = pq.remove();
            int u = curr.node;

            // If we've already processed this node, skip it
            if (vis[u]) continue;

            // mark visited now
            vis[u] = true;

            // relax all outgoing edges
            for (Edge e : graph[u]) {
                int v = e.dest;
                int wt = e.wt;

                // avoid overflow: only relax if u is reachable
                if (dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]) {
                    dist[v] = dist[u] + wt;
                    pq.add(new Pair(v, dist[v]));
                }
            }
        }

        // print distances (print INF for unreachable)
        for (int i = 0; i < n; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                System.out.print("INF ");
            } else {
                System.out.print(dist[i] + " ");
            }
        }
        System.out.println();
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

    public static void main(String[] args) {
        int v = 5;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[v];
        createGraph(graph);
        int src = 0;
        dijkstra(graph, src); // expected output: distances from 0
    }
}
