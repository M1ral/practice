package leetcode.tree;

public class Invert {

    public static void main(String[] args) {
        // call invert tree method
    }

    /**
     * Invert leetcode.tree
     *
     * from:
     *      1
     *    2   3
     *
     * to:
     *      1
     *    3   2
     *
     * @param root
     * @return TreeNode
     */
    public static TreeNode invertTree(TreeNode root) {
        if (null != root) {
            traverse(root);
        }
        return root;
    }

    public static void traverse(TreeNode root) {
        if (null == root) {
            return;
        }

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        traverse(root.left);
        traverse(root.right);
    }
}