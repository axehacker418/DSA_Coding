import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Practice {

    static class  Edge {
        int source;
        int destination;
        int weight;

        public Edge(int src,int dest, int wt)
        {
            this.source=src;
            this.destination=dest;
            this.weight=wt;
        }
    }

    // Node/Edge class done to store values of edges source destination and weight 
    public static void storeEdges(ArrayList<Edge>[] graph){
        for(int i=0; i<graph.length; i++){
            //for every index of array list storing the edges type collection (src,dest,wt) that is also a arrayList;
            graph[i]=new ArrayList<>();
        }

        // values adding 
        graph[0].add(new Edge(0, 1, 0)); // src =i dest =j value =wt if i write insertion function ok 

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

    // function for bfs search 

    public static void bfs(ArrayList<Edge>[] graph){

        Queue<Integer> q=new LinkedList<>();
        boolean vis[]=new boolean[graph.length];

        q.add(0);

        while (!q.isEmpty()) {
            int curr=q.remove();
            if (!vis[curr]) {
                System.out.println(curr+ " ");
                vis[curr]=true;
                for(int i=0; i<graph[curr].size(); i++){
                    Edge e=graph[curr].get(i);
                    q.add(e.destination);
                }
                
            }
            
        }

    }


    public static void main(String args[]){
        int v=5; // no. of vertices 
        ArrayList<Edge>[] graph=new ArrayList[v];

        storeEdges(graph);
        bfs(graph);


    }
    
}
