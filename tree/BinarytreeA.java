// package tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinarytreeA {

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

    public  static class BinaryTree {
        static int idx = -1;

        public static Node buildTree(int nodes[]) {
            idx++;
            if (nodes[idx] == -1) {
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
            return newNode;

        }

        public static void preorder(Node root) {
            if (root == null) {
                System.out.print(-1 + " ");
                return;
            }
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);

        }

        public static void inorder(Node root) {
            if (root == null) {
                System.out.print(-1 + " ");
                return;
            }
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);

        }

        public static void postorder(Node root) {
            if (root == null) {
                return;
            }
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data + " ");

        }

        public static void levelorder(Node root) {
            if (root == null) {
                return;
            }
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);

            while (!q.isEmpty()) {
                Node currNode = q.remove();
                if (currNode == null) {
                    System.out.println();
                    if (q.isEmpty()) {
                        break;

                    } else {
                        q.add(null);
                    }

                } else {
                    System.out.print(currNode.data + " ");
                    if (currNode.left != null) {
                        q.add(currNode.left);

                    }
                    if (currNode.right != null) {
                        q.add(currNode.right);

                    }
                }

            }
        }

        public static int height(Node root) {

            if (root == null) {
                return 0;

            }

            int lheight = height(root.left);
            int rheight = height(root.right);
            int totalHeight = Math.max(lheight, rheight) + 1;

            return totalHeight;
        }

        public static int countNodes(Node root) {
            if (root == null) {
                return 0;
            }

            int lc = countNodes(root.left);
            int rc = countNodes(root.right);
            return lc + rc + 1;
        }

        public static int sumofNodes(Node root) {
            if (root == null) {
                return 0;

            }
            int ls = sumofNodes(root.left);
            int rs = sumofNodes(root.right);

            return ls + rs + root.data;
        }

        public static int treeDiameter(Node root){ // O(n^2)= n*n
        // daimeter is one leaf node to other leaf node max height.

        if (root==null) {
        return 0;
        }

        // Approach 1
        // if diameter passes through root lh+rh+1
        // does not pass through root ld= D of left subtree, rd= diameter of right
        // diameter , diameter through root max one is the correct diameter.
        int ld=treeDiameter(root.left);
        int lh=height(root.left);
        int rd=treeDiameter(root.right);
        int rh=height(root.right);

        int rootDiameter= lh+rh+1;

        int max1=Math.max(ld, rootDiameter);
        int max2=Math.max(max1,rd);

        return max2;

        }

         static class Info{
            int daim ;
            int ht;
            public Info(int daim, int ht){
                this.daim=daim;
                this.ht=ht;

            }
         }

         public static Info diameter(Node root){
               
            if (root==null) {
                return new Info(0,0);
                
            }
            Info leftInfo=diameter(root.left);
            Info rightInfo=diameter(root.right);
            int diam=Math.max(Math.max(leftInfo.daim, rightInfo.daim),leftInfo.ht+rightInfo.ht+1 );

            int ht=Math.max(leftInfo.ht, rightInfo.ht)+1;
            return new Info(diam, ht);
         }


    }

    public static  void Klavel(Node root,int level,int k){
        if (root==null) {
            return;
            
        }
        if (level==k) {
            System.out.print(root.data + " ");
            return;

            
        }
        Klavel(root.left,level+1,k);
        Klavel(root.right, level+1,k);
    }
    public static void main(String[] args) {
        int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };

        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        System.out.println("root node of this tree is :" + root.data);
        System.out.println("Printing the preorder! ");
        tree.preorder(root);
        System.out.println();
        System.out.println(" Inorder ");
        tree.inorder(root);
        System.out.println();
        System.out.println("postorder ");
        tree.postorder(root);
        System.out.println();
        System.out.println(" level wise ");
        tree.levelorder(root);

        System.out.println();
        System.out.println(" the total height is " + tree.height(root));
        System.out.println(" the total Nodes count is " + tree.countNodes(root));
        System.out.println("total sum of all noeds is " + tree.sumofNodes(root));

        System.out.println("The diameter is " + tree.treeDiameter(root));

        System.out.println("the diameter Using Approach 2 O(n) "+ tree.diameter(root).daim);
        System.out.println("the height Using Approach 2 O(n) "+ tree.diameter(root).ht);

        System.out.println("K lavel" );
        Klavel(root,1,2);

    }

}
