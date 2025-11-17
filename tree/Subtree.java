// package tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Subtree {

    public static boolean isSubtree(BinarytreeA.Node root, BinarytreeA.Node subroot) {

        if (root == null) {
            return false;
        }

        if (root.data == subroot.data) {
            if (isIdentical(root, subroot)) {
                return true;

            }

        }

        // boolean leftAns = isSubtree(root.left, subroot);
        // boolean rightAns = isSubtree(root.right, subroot);

        // return leftAns || rightAns;

        return isSubtree(root.left, subroot) || isSubtree(root.right, subroot);

    }

    public static boolean isIdentical(BinarytreeA.Node node, BinarytreeA.Node subroot) {
        if (node == null && subroot == null) {
            return true;
        } else if (node == null || subroot == null || node.data != subroot.data) {
            return false;
        }
        if (!isIdentical(node.left, subroot.left)) {
            return false;

        }
        if (!isIdentical(node.right, subroot.right)) {
            return false;

        }

        return true;
    }

    static class treeInfo {
        BinarytreeA.Node node;
        int hd;

        treeInfo(BinarytreeA.Node node, int hd) {
            this.node = node;
            this.hd = hd;

        }
    }

    public static void topView(BinarytreeA.Node root) {
        // level order traversal
        Queue<treeInfo> q = new LinkedList<>();
        HashMap<Integer, BinarytreeA.Node> map = new HashMap<>();

        int min = 0, max = 0;
        q.add(new treeInfo(root, 0));
        q.add(null);
        while (!q.isEmpty()) {
            treeInfo curr = q.remove();
            if (curr == null) {
                if (q.isEmpty()) {
                    break;

                } else {
                    q.add(null);
                }

            }else{
                if (!map.containsKey(curr.hd)) {
                map.put(curr.hd, curr.node);
            }
            if (curr.node.left!=null) {
                q.add(new treeInfo(curr.node.left, curr.hd-1));
                min=Math.min(min, curr.hd-1);
                
            }
            if (curr.node.right !=null) {
                q.add(new treeInfo(curr.node.right, curr.hd+1));
                max=Math.max(max, curr.hd+1);
            }
            }
            
        }
        for(int i=min; i<=max; i++){
            System.out.print(map.get(i).data+" ");

        }
        System.out.println( );

    }

    public static void main(String[] args) {

        BinarytreeA.Node root = new BinarytreeA.Node(1);
        root.left = new BinarytreeA.Node(2);
        root.right = new BinarytreeA.Node(3);
        root.left.left = new BinarytreeA.Node(4);
        root.left.right = new BinarytreeA.Node(5);
        root.right.left = new BinarytreeA.Node(6);
        root.right.right = new BinarytreeA.Node(7);

        // Subtree
        BinarytreeA.Node subroot = new BinarytreeA.Node(2);
        subroot.left = new BinarytreeA.Node(4);
        subroot.right = new BinarytreeA.Node(5);

        System.out.println("check subtree " + isSubtree(root, subroot));
        System.out.println("Top view is : "  );
        topView(root);

    }

}
