import java.util.ArrayList;

public class Graph1 {

    static class  Edge {
        int src;
        int dest;
        int wt;
        public Edge(int src, int dest, int wt){
            this.src=src;
            this.dest=dest;
            this.wt=wt;
        }
        
    }
@SuppressWarnings("unchecked")
    public static void main(String[] args) {
        int v=5; // total no. or vertaces 
        ArrayList<Edge>[] graph=new ArrayList[v]; //null mean undefined to empty creation 

        for(int i=0; i<v; i++){
            graph[i]=new ArrayList<>(); // create arraylists of empty value for all index of vertices 
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

        for(int i=0; i<graph[2].size(); i++){
            Edge e=graph[2].get(i);
            System.out.println(e.dest);
        }


        

        
    }
}