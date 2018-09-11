package tree;

public class SameTree {
    /**
     * Check if both given trees are exact same
     * (Same as matchTree() method in Subtree problem
     *
     * @param p
     * @param q
     * @return boolean
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (null == p && null == q) {
            return true;
        }
        if (null == p || null == q) {
            return false;
        }
        return (p.val == q.val)
                && isSameTree(p.left, q.left)
                && isSameTree(p.right, q.right);
    }
}
