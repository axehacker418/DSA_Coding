import java.util.Comparator;
import java.util.PriorityQueue;

public class Pq {

    // static class Student {
    // String name;
    // int rank;

    // public Student(String name , int rank){
    // this.name=name;
    // this.rank=rank;
    // }

    // }

    // this is normal class above

    // FOR PriorityQueue

    static class Student implements Comparable<Student> {
        String name;
        int rank;

        public Student(String name, int rank) {
            this.name = name;
            this.rank = rank;
        }
        // Overriding

        @Override
        public int compareTo(Student s2) {
            return this.rank - s2.rank; // = 'negetive', 'positive' or '0'

        }

    }

    public static void main(String[] args) {
        // PriorityQueue<Integer> pq=new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Student> pq = new PriorityQueue<>();

        // // <Integer or Node means Object of a class or Charactwer etc all >
        // pq.add(8);
        // pq.add(3);
        // pq.add(5);
        // pq.add(1);

        // while (!pq.isEmpty()) {
        // System.out.println(pq.peek());
        // pq.remove();
        // }

        pq.add(new Student("A", 4));
        pq.add(new Student("B", 2));
        pq.add(new Student("C", 5));
        pq.add(new Student("H", 4));
        pq.add(new Student("D", 8));
        pq.add(new Student("J", 1));

        while (!pq.isEmpty()) {
            System.out.println(pq.peek().name+ "-> "+pq.peek().rank);
            pq.remove();
        }

    }
}