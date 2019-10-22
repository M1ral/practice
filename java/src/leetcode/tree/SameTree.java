package leetcode.tree;

public class SameTree {

    public static void main(String[] args) {
        System.out.println(isSameTree(Tree.createDummyTree(), Tree.createDummyTree()));
    }

    /**
     * Check if both given trees are exact same
     * (Same as matchTree() method in Subtree problem
     *
     * @param p
     * @param q
     * @return boolean
     */
    public static boolean isSameTree(TreeNode p, TreeNode q) {
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
