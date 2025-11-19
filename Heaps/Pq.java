import java.util.Comparator;
import java.util.PriorityQueue;

public class Pq {

    static class Student {
        String name;
        int rank;
    
        
    }

     public static void main(String[] args) {
        PriorityQueue<Integer> pq=new PriorityQueue<>(Comparator.reverseOrder());
        
        // <Integer or Node means Object of a class or Charactwer etc all >
        pq.add(8);
        pq.add(3);
        pq.add(5);
        pq.add(1);

        while (!pq.isEmpty()) {
            System.out.println(pq.peek());
            pq.remove();    
        }
     }
}