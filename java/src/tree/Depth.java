package tree;

import java.util.LinkedList;
import java.util.Queue;

public class Depth {

    public static void main(String[] args) {
        System.out.println("getHeight(Tree.createDummyTree()) = " + getHeight(Tree.createDummyTree()));
        System.out.println("maxDepth(Tree.createDummyTree()) = " + maxDepth(Tree.createDummyTree()));
        System.out.println("minDepth(Tree.createDummyTree()) = " + minDepthRecurse(Tree.createDummyTree()));
        System.out.println("minDepthIterative(Tree.createDummyTree()) = " + minDepthIterative(Tree.createDummyTree()));
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
     * min depth recursive
     *
     * @param root
     * @return int
     */
    private static int minDepthRecurse(TreeNode root) {
        if (null == root) {
            return 0;
        }
        if (null == root.left && null == root.right) {
            return 1;
        }
        if (null == root.left) {
            return 1 + minDepthRecurse(root.right);
        }
        if (null == root.right) {
            return 1 + minDepthRecurse(root.left);
        }
        
        return 1 + Math.min(minDepthRecurse(root.left), minDepthRecurse(root.right));
    }

    /**
     * min depth iteratively
     *
     * @param root
     * @return int
     */
    public static int minDepthIterative(TreeNode root) {
        if (null == root) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        int depth = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size != 0) {
                TreeNode current = queue.remove();
                if (null == current.left && null == current.right) {
                    return depth; // return depth as soon as we encounter a leaf node
                }
                if (null != current.left)
                    queue.add(current.left);
                if (null != current.right)
                    queue.add(current.right);

                size--;
            }
            depth++;
        }
        return depth;
    }
}
