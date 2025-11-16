// package tree;
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

        return isSubtree(root.left, subroot)||isSubtree(root.right, subroot);

    }

    public static boolean isIdentical(BinarytreeA.Node node, BinarytreeA.Node subroot){
        if (node==null && subroot==null ) {
            return true;
        }
        else if (node==null|| subroot==null||node.data!=subroot.data) {
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
    public static void main(String[] args) {

        BinarytreeA.Node root = new BinarytreeA.Node(1);
        root.left = new BinarytreeA.Node(2);
        root.right = new BinarytreeA.Node(3);
        root.left.left = new BinarytreeA.Node(4);
        root.left.right = new BinarytreeA.Node(5);
        root.right.left = new BinarytreeA.Node(6);
        root.right.right = new BinarytreeA.Node(6);

        // Subtree
        BinarytreeA.Node subroot = new BinarytreeA.Node(2);
        subroot.left = new BinarytreeA.Node(4);
        subroot.right = new BinarytreeA.Node(5);

        System.out.println("check subtree "+isSubtree(root, subroot));

    }

}
