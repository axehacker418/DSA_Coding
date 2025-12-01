import java.util.ArrayList;

public class BellmanFort {
   
    static class  Edge {
        int src; 
        int dest;
        int wt;
        public Edge(int src, int dest , int wt){
            this.src=src;
            this.dest=dest;
            this.wt=wt;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph){
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
    
    public static void createGraph2(ArrayList<Edge>graph){
        
        
        graph.add(new Edge(0, 1, 5));
        graph.add(new Edge(1, 0, 5));

        // 1 <-> 2 (3)
        graph.add(new Edge(1, 2, 3));
        graph.add(new Edge(2, 1, 3));

        // 1 <-> 3 (2)
        graph.add(new Edge(1, 3, 2));
        graph.add(new Edge(3, 1, 2));

        // 2 <-> 3 (2)
        graph.add(new Edge(2, 3, 2));
        graph.add(new Edge(3, 2, 2));

        // 2 <-> 4 (9)
        graph.add(new Edge(2, 4, 9));
        graph.add(new Edge(4, 2, 9));

        // 3 <-> 4 (3)
        graph.add(new Edge(3, 4, 3));
        graph.add(new Edge(4, 3, 3));

    }
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        int v=5;
        ArrayList<Edge>[] graph=new ArrayList[v];
        createGraph(graph);
        bellmanford(graph, 0);

        ArrayList<Edge> edges=new ArrayList<>();
        createGraph2(edges);
        bellmanford2(edges, 0, v);
        

    }
    public static void bellmanford(ArrayList<Edge>[] graph, int src){
        int dist[]=new int[graph.length];
        for(int i=0; i<graph.length; i++){
            if (i!=src) {
                dist[i]=Integer.MAX_VALUE; // initialize all vertices to zero accept the src that is 0 most of the time 
    
                
            }
        }

        // algo start 
        int n=graph.length;
        for(int i=0; i<n-1; i++){
            for(int j=0; j<graph.length; j++){
                for(int k=0; k<graph[j].size(); k++){
                    Edge e= graph[j].get(k);
                    // u v wt 
                    int u = e.src;
                    int v= e.dest; 
                    int wt=e.wt;
                    // relaxation 
                    if (dist[u] != Integer.MAX_VALUE &&  dist[u]+wt<dist[v]) {
                        dist[v]=dist[u]+wt;
                        
                    }
                }
            }

        }


        // print 
        for(int i=0; i<dist.length; i++){
            System.out.print(dist[i]+" ");
        }
        System.out.println();

    
    }


    public static void bellmanford2(ArrayList<Edge> graph, int src, int v){
        int dist[]=new int[v];
        for(int i=0; i<dist.length; i++){
            if (i!=src) {
                dist[i]=Integer.MAX_VALUE; // initialize all vertices to zero accept the src that is 0 most of the time 
    
                
            }
        }

        // algo start 
        for(int i=0; i<v-1; i++){
            for(int j=0; j<graph.size(); j++){
                
                    Edge e= graph.get(j);
                    // u v wt 
                    int u = e.src;
                    int d= e.dest; 
                    int wt=e.wt;
                    // relaxation 
                    if (dist[u] != Integer.MAX_VALUE &&  dist[u]+wt<dist[d]) {
                        dist[d]=dist[u]+wt;
                        
                    }
                
            }

        }


        // print 
        for(int i=0; i<dist.length; i++){
            System.out.print(dist[i]+" ");
        }
        System.out.println();

    
    }



 

}
