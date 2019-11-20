package interview.phone.oracle;

public class PostOrderSuccessor {

    static class Node {
        Node left, right, parent;
        int value;
    }

    // Utility function to create a new node with
    // given value.
    static Node newNode(int value)
    {
        Node temp = new Node();
        temp.left = null;
        temp.right = null;
        temp.parent = null;
        temp.value = value;
        return temp;
    }

    public static Node postorderSuccessor(Node n) {
        // Root has no successor in postorder
        if (n == null || n.parent == null)
            return null;
        // if node is its parent's right or parent's right is null
        Node parent = n.parent;
        if (parent.right == null || parent.right == n)
            return parent;

        // In all other cases, find deepest node in parent's right subtree
        return findPostOrderSuccessorInRightSubtree(n.parent.right);
    }

    public static Node findPostOrderSuccessorInRightSubtree(Node n) {
        if (null == n) {
            return null;
        }

        while (null != n) {
            Node p = n;
            n = n.left;

            if (null == n) {
                if (null == p.right) {
                    return p;
                } else {
                    return findPostOrderSuccessorInRightSubtree(p.right);
                }
            }
        }

        return null;
    }


    public static void postOrder(Node root) {
        if (null == root) {
            return;
        }

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.value + " -> ");
    }

    // Driver code
    public static void main(String[] args)
    {
        Node root = newNode(20);
        root.parent = null;
        root.left = newNode(10);
        root.left.parent = root;
        root.left.left = newNode(4);
        root.left.left.parent = root.left;
        root.left.right = newNode(18);
        root.left.right.parent = root.left;
        root.right = newNode(26);
        root.right.parent = root;
        root.right.left = newNode(24);
        root.right.left.parent = root.right;
        root.right.left.right = newNode(25);
        root.right.left.right.parent = root.right.left;
        root.right.left.right.left = newNode(30);
        root.right.left.right.parent = root.right.left;
        root.right.left.right.left.right = newNode(31);
        root.right.left.right.left.right.parent = root.right.left.right.left;
        root.right.right = newNode(27);
        root.right.right.parent = root.right;
        root.left.right.left = newNode(14);
        root.left.right.left.parent = root.left.right;
        root.left.right.left.left = newNode(13);
        root.left.right.left.left.parent = root.left.right.left;
        root.left.right.left.right = newNode(15);
        root.left.right.left.right.parent = root.left.right.left;
        root.left.right.right = newNode(19);
        root.left.right.right.parent = root.left.right;

        System.out.println("postOrder(root)");
        postOrder(root);

        System.out.println("\npostorderSuccessor(19) = " +
                postorderSuccessor(root.left.right.right).value);

        System.out.println("postorderSuccessor(10) = " +
                postorderSuccessor(root.left).value);
    }
}
