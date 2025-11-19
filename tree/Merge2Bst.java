import java.util.*;

public class Merge2Bst {

    public static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    static class Info {
        boolean isBst;
        int size, min, max;

        Info(boolean isBst, int size, int min, int max) {
            this.isBst = isBst;
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }

    public static int maxBst = 0;

    // ----------------------------------------------------------
    //        FIND LARGEST BST IN A BINARY TREE
    // ----------------------------------------------------------
    public static Info largestBst(Node root) {
        if (root == null) {
            return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        Info left = largestBst(root.left);
        Info right = largestBst(root.right);

        int size = left.size + right.size + 1;
        int min = Math.min(root.data, Math.min(left.min, right.min));
        int max = Math.max(root.data, Math.max(left.max, right.max));

        if (!left.isBst || !right.isBst || root.data <= left.max || root.data >= right.min) {
            return new Info(false, size, min, max);
        }

        maxBst = Math.max(maxBst, size);
        return new Info(true, size, min, max);
    }

    // ----------------------------------------------------------
    //        MERGE TWO BSTs INTO ONE BALANCED BST
    // ----------------------------------------------------------

    // inorder traversal → sorted list
    public static void inorder(Node root, List<Integer> arr) {
        if (root == null) return;
        inorder(root.left, arr);
        arr.add(root.data);
        inorder(root.right, arr);
    }

    // merge two sorted arrays
    public static List<Integer> mergeSorted(List<Integer> a, List<Integer> b) {
        List<Integer> merged = new ArrayList<>();
        int i = 0, j = 0;

        while (i < a.size() && j < b.size()) {
            if (a.get(i) < b.get(j)) merged.add(a.get(i++));
            else merged.add(b.get(j++));
        }
        while (i < a.size()) merged.add(a.get(i++));
        while (j < b.size()) merged.add(b.get(j++));

        return merged;
    }

    // convert sorted array → balanced BST
    public static Node sortedToBst(List<Integer> arr, int start, int end) {
        if (start > end) return null;
        int mid = (start + end) / 2;

        Node root = new Node(arr.get(mid));
        root.left = sortedToBst(arr, start, mid - 1);
        root.right = sortedToBst(arr, mid + 1, end);

        return root;
    }

    // final function to merge two BSTs
    public static Node mergeBst(Node root1, Node root2) {
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();

        inorder(root1, a);
        inorder(root2, b);

        List<Integer> merged = mergeSorted(a, b);

        return sortedToBst(merged, 0, merged.size() - 1);
    }

    // ----------------------------------------------------------
    public static void main(String[] args) {

        // SAMPLE TREE FOR LARGEST BST PROBLEM
        Node root = new Node(50);
        root.left = new Node(30);
        root.left.left = new Node(5);
        root.left.right = new Node(20);

        root.right = new Node(60);
        root.right.left = new Node(45);
        root.right.right = new Node(70);
        root.right.right.left = new Node(65);
        root.right.right.right = new Node(80);

        largestBst(root);
        System.out.println("Largest BST size = " + maxBst);

        // SAMPLE MERGE
        Node bst1 = new Node(40);
        bst1.left = new Node(20);
        bst1.right = new Node(60);

        Node bst2 = new Node(50);
        bst2.left = new Node(30);
        bst2.right = new Node(70);

        Node mergedRoot = mergeBst(bst1, bst2);

        System.out.println("Merged BST (inorder): ");
        List<Integer> out = new ArrayList<>();
        inorder(mergedRoot, out);
        System.out.println(out);
    }
}
