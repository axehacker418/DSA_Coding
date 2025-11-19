import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class largestbst {
    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class info {
        boolean isBst;
        int size;
        int min;
        int max;

        public info(boolean isBst,
                int size,
                int min,
                int max) {
            this.isBst = isBst;
            this.size = size;
            this.min = min;
            this.max = max;

        }
       

    }
     public static int maxBst=0;

        public static info largestbst(Node root) {
            if (root==null){
                return new info(true, 0,Integer.MAX_VALUE, Integer.MIN_VALUE);
            } {
                
            }
           
           info leftinfo=largestbst(root.left);
           info rightinfo=largestbst(root.right);
           int size=leftinfo.size+rightinfo.size+1;
           int min = Math.min( rightinfo.min, Math.min(root.data, leftinfo.min));
           int max = Math.max( rightinfo.max, Math.max(root.data, leftinfo.max));
           if (root.data<=leftinfo.max|| root.data>=rightinfo.min) {
            return new info(false, size, min, max);
            
           }
           
           if (leftinfo.isBst && rightinfo.isBst) {
            maxBst=Math.max(maxBst, size);
            return new info(true, size, min, max);
            
           }
           return new info(false, size, min, max);


        }

    public static void main(String[] args) {
        Node root = new Node(50);
        root.left = new Node(30);
        root.left.left = new Node(5);
        root.left.right = new Node(20);

        root.right = new Node(60);
        root.right.left = new Node(45);
        root.right.right = new Node(70);
        root.right.right.left = new Node(65);
        root.right.right.right = new Node(80);


        largestbst(root);
        System.out.println("largest bst size ="+ maxBst);

    }

}
