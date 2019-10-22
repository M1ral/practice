package leetcode.tree;

public class Diameter {

    private int maxDiameter = 0;

    /**
     * Returns the longest path between two nodes (doesn't have to pass through the root)
     *
     * basically - the node with max left and max right depths.
     *
     * @param root
     * @return int
     */
    public int diameterOfBinaryTree(TreeNode root) {
        if (null == root) {
            return 0;
        }
        traverse(root);
        return maxDiameter;
    }

    public int traverse(TreeNode root) {
        if (null == root) {
            return 0;
        }

        int left = traverse(root.left);
        int right = traverse(root.right);
        maxDiameter = Math.max(maxDiameter, left + right);
        return 1 + Math.max(left, right);
    }
}
