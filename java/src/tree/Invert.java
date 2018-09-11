package tree;

public class Invert {

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
