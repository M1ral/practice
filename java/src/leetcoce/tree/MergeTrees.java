package leetcoce.tree;

public class MergeTrees {

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        return merge(t1, t2);
    }

    /**
     * Merge given 2 trees
     * @param t1
     * @param t2
     * @return
     */
    public TreeNode merge(TreeNode t1, TreeNode t2) {
        if (null == t1 && null == t2) {
            return null;
        }

        // sum up the node values
        int val = ((t1 == null) ? 0 : t1.val) + ((t2 == null) ? 0 : t2.val);

        TreeNode result = new TreeNode(val);
        result.left = merge((t1 == null) ? null : t1.left, (t2 == null) ? null : t2.left);
        result.right = merge((t1 == null) ? null : t1.right, (t2 == null) ? null : t2.right);

        return result;
    }
}
