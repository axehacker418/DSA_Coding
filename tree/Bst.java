import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Bst {

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

    // insert in BST
    public static Node insert(Node root, int val) {
        if (root == null) {
            root = new Node(val);
            return root;

        }
        if (root.data > val) {
            root.left = insert(root.left, val);

        } else {
            root.right = insert(root.right, val);
        }
        return root;
    }

    public static void inorder(Node root) {
        if (root == null) {
            return;

        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    // search in BST

    public static int searchK(Node root, int key) {
        if (root == null) {
            System.out.println("not found");
            return -1;
        }
        if (root.data == key) {
            System.out.println("found");
            return root.data;
        }

        if (key < root.data) {
            return searchK(root.left, key);
        } else {
            return searchK(root.right, key);
        }

    }

    // Delete in BST case 1 single child case 2 delete child node case 3 both child
    // exist means sbroot or root of the subtree
    // 1 search 2 delete 3 adjust

    // case No chiled delete node and return null to parent node
    // case2 one child delete node and replcae with child node
    // case2 two childs replace value with inorder successor deletw the node for
    // inorder successor
    // Inorder successor in bst is equal to left most node in the right subtree that
    // is minimum value in it
    public static Node delete(Node root, int key) {
        if (root == null) {
            System.out.println(" this is empty");
            return null;
        }
        if (root.data < key) {
            root.right = delete(root.right, key);
        } else if (root.data > key) {
            root.left = delete(root.left, key);
        } else {
            // voila
            // Case 1
            if (root.left == null && root.right == null) {
                return null;
            }
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // case 3
            Node is = findInorderSuccesor(root.right);
            root.data = is.data;
            root.right = delete(root.right, is.data);

        }
        return root;

    }

    public static Node findInorderSuccesor(Node root) {
        while (root.left != null) {
            root = root.left;

        }
        return root;

    }

    public static void printinRange(Node root, int k1, int k2) {
        if (root == null) {
            return;

        }
        if (root.data >= k1 && root.data <= k2) {
            printinRange(root.left, k1, k2);
            System.out.print(root.data + " ");
            printinRange(root.right, k1, k2);
        } else if (root.data < k1) {
            printinRange(root.right, k1, k2);

        } else {
            printinRange(root.left, k1, k2);
        }

    }

    public static void printPath(ArrayList<Integer> path) {
        for (int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i) + "->");
        }
        System.out.println("N");

    }

    public static void leafPath(Node root, ArrayList<Integer> path) {
        if (root == null) {
            return;
        }
        path.add(root.data);

        if (root.left == null && root.right == null) {
            printPath(path);

        }

        leafPath(root.left, path);
        leafPath(root.right, path);
        path.remove(path.size() - 1);

    }

    public static boolean isValidBST(Node root, Node min, Node max) {
        if (root == null) {
            return true;
        }
        if (min != null && root.data <= min.data) {
            return false;
        } else if (max != null && root.data >= max.data) {
            return false;

        }

        return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
    }

    // mirror a bst mean make right subtree and to left subtree and left nodes
    public static Node mirrorTree(Node root) {

        if (root == null) {
            return null;
        }
        Node leftmirror = mirrorTree(root.left);
        Node rightmirror = mirrorTree(root.right);
        Node swap;

        root.left = rightmirror;
        root.right = leftmirror;
        return root;

    }

    public static void preorder(Node root) {
        if (root == null) {
            return;

        }
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    // Sorted array to BST array divide in two part mid is root lees in left grater
    // in right side balensed tree

    public static Node creatBST(int[] arr, int st, int end) {
    if(st>end)

    {
        return null;

    }
    int mid = (st + end) / 2;
    Node root = new Node(arr[mid]);root.left=

    creatBST(arr, st, mid - 1);
        root.right = creatBST(arr, mid + 1, end);
        return root;

    }

    public static void getInorder(Node root, ArrayList<Integer> inorder) {
        if (root == null) {
            return;

        }
        getInorder(root.left, inorder);
        inorder.add(root.data);
        getInorder(root.right, inorder);
    }

    public static Node createBST(ArrayList<Integer> inorder, int st, int end) {
        if (st > end) {
            return null;

        }
        int mid = (st + end) / 2;
        Node root = new Node(inorder.get(mid));
        root.left = createBST(inorder, st, mid - 1);
        root.right = createBST(inorder, mid + 1, end);

        return root;
    }

    public static Node balencedBST(Node root) {
        // step create inorder sequence step2 make balenced tree using array
        ArrayList<Integer> inorder = new ArrayList<>();
        getInorder(root, inorder);
        // createBST(inorder, 0, inorder.size()-1);

        // return root;
        return createBST(inorder, 0, inorder.size() - 1);
    }

    // public static void main(String[] args) {
    // int nodes[] = { 8, 5, 3, 1, 4, 6, 10, 11, 14 };// { 1, 2, 4, 5, 3, 6, };
    // Node root = null;
    // for (int i = 0; i < nodes.length; i++) {
    // root = insert(root, nodes[i]);
    // }
    // inorder(root);
    // // System.out.println();
    // // searchK(root, 2);

    // // root = delete(root, 4); // delete value 4
    // // inorder(root); // should reflect deletion
    // // System.out.println();
    // // printinRange(root, 5, 12);
    // // System.out.println();

    // // ArrayList<Integer> path=new ArrayList<>();
    // // leafPath(root, path);

    // // System.out.print("validity check is - ");

    // // if (isValidBST(root, null, null)) {
    // // System.out.println("Valid");

    // // }
    // // else{
    // // System.out.println("Invalid");
    // // }

    // // System.out.println();
    // // mirrorTree(root);
    // // preorder(root);

    // // int arr[] = { 3, 5, 6, 8, 10, 11, 12 };
    // // Node root = creatBST(arr, 0, arr.length - 1);
    // // preorder(root);

    // balencedBST(root);

    // }



    public static void main(String[] args) {

        // -----------------------------
        // 1. INSERT NODES INTO THE BST
        // -----------------------------
        int nodes[] = { 8, 5, 3, 1, 4, 6, 10, 11, 14 };
        Node root = null;

        for (int i = 0; i < nodes.length; i++) {
            root = insert(root, nodes[i]);
        }

        System.out.println("Original BST (inorder):");
        inorder(root);
        System.out.println();

        // -----------------------------
        // 2. BALANCE THE BST
        // -----------------------------
        Node balanced = balencedBST(root);

        System.out.println("\nBalanced BST (preorder):");
        preorder(balanced);
        System.out.println();

        System.out.println("Balanced BST (inorder):");
        inorder(balanced);
        System.out.println();

    }

}
