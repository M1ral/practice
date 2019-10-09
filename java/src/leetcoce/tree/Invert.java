package leetcoce.tree;

public class Invert {

    /**
     * Invert leetcoce.tree
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
    public TreeNode invertTree(TreeNode root) {
        if (root != null) {
            helper(root);
        }
        return root;
    }

    public void helper(TreeNode p) {
        TreeNode temp = p.left;
        p.left = p.right;
        p.right = temp;

        if (p.left != null)
            helper(p.left);

        if (p.right != null)
            helper(p.right);
    }
}
