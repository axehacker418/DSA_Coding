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

    public static void main(String[] args) {
        int nodes[] = { 8, 5, 3, 1, 4, 6, 10, 11, 14 };// { 1, 2, 4, 5, 3, 6, };
        Node root = null;
        for (int i = 0; i < nodes.length; i++) {
            root = insert(root, nodes[i]);
        }
        inorder(root);
        System.out.println();
        searchK(root, 2);

        root = delete(root, 4); // delete value 4
        inorder(root); // should reflect deletion

    }

}
