package tree;

public class SumLeftLeaves {

    public static void main(String[] args) {
        System.out.println("sumOfLeftLeaves(Tree.createDummyTree()) = " + sumOfLeftLeaves(Tree.createDummyTree()));
    }

    public static int sumOfLeftLeaves(TreeNode root) {
        if (null == root) {
            return 0;
        }
        traverse(root, false);
        return total;
    }

    private static int total;

    public static void traverse(TreeNode root, boolean isLeft) {
        if (null == root) {
            return;
        }
        // left leaf
        if (null == root.left && null == root.right && isLeft) {
            total += root.val;
        }
        traverse(root.left, true);
        traverse(root.right, false);
    }
}
