package tree;

public class Depth {

    public static void main(String[] args) {
        System.out.println("getHeight(Tree.createDummyTree()) = " + getHeight(Tree.createDummyTree()));
        System.out.println("maxDepth(Tree.createDummyTree()) = " + maxDepth(Tree.createDummyTree()));
        System.out.println("minDepth(Tree.createDummyTree()) = " + minDepth(Tree.createDummyTree()));
    }

    /**
     * Return the height of given tree node
     * @param root
     * @return int height
     */
    public static int getHeight(TreeNode root) {
        if (null == root) {
            return 0;
        }

        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }

    /**
     * Return max depth of given tree node, (equals to the height of the tree)
     * @param root
     * @return int max depth
     */
    public static int maxDepth(TreeNode root) {
        return getHeight(root);
    }

    /**
     * Return min depth of given tree node
     *
     * @param root
     * @return int min depth
     */
    public static int minDepth(TreeNode root) {
        if (null == root) {
            return 0;
        }

        return 1 + Math.min(getHeight(root.left), getHeight(root.right));
    }
}
