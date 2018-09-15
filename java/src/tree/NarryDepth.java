package tree;

public class NarryDepth {

    /**
     * Find max depth of an N-ary tree
     *
     * @param root
     * @return int
     */
    public int maxDepth(Node root) {
        if (null == root) {
            return 0;
        }
        return getHeight(root);
    }

    /**
     * Return the height of n-ary tree (max depth)
     *
     * @param root
     * @return int
     */
    public int getHeight(Node root) {

        /****** BASE CONDITION IS IMPORTANT ******/
        if (null == root || null == root.children || root.children.isEmpty()) {
            return 1; // IMPORTANT - default height of leaf
        }

        int max = Integer.MIN_VALUE;
        for (Node n : root.children) {
            max = Math.max(max, getHeight(n));
        }

        return 1 + max;
    }
}
