package leetcoce.tree;

import java.util.ArrayDeque;
import java.util.Deque;

public class Depth {

    public static void main(String[] args) {
        System.out.println("getHeight recursive = " + getHeight(Tree.createDummyTree()));
        System.out.println("maxDepth recursive = " + maxDepth(Tree.createDummyTree()));
        System.out.println("maxDepth iterative = " + maxDepthIter(Tree.createDummyTree()));
        System.out.println("minDepth recursive = " + minDepthRec(Tree.createDummyTree()));
        System.out.println("minDepth iterative  = " + minDepthIterative(Tree.createDummyTree()));
    }

    /**
     * Return the height of given leetcode.tree node
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
     * Return max depth of given leetcoce.tree node, (equals to the height of the leetcoce.tree)
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
    private static int minDepthRec(TreeNode root) {
        if (null == root) {
            return 0;
        }
        if (null == root.left && null == root.right) {
            return 1;
        }
        if (null == root.left) {
            return 1 + minDepthRec(root.right);
        }
        if (null == root.right) {
            return 1 + minDepthRec(root.left);
        }
        
        return 1 + Math.min(
                minDepthRec(root.left), minDepthRec(root.right));
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

        Deque<TreeNode> queue = new ArrayDeque<>();
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

    /**
     * max depth iteratively
     * @param root
     * @return
     */
    public static int maxDepthIter(TreeNode root) {
        int maxDepth = 0;
        if (null == root) {
            return maxDepth;
        }

        Deque<TreeNode> queue = new ArrayDeque();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            maxDepth++;

            while (size != 0) {
                TreeNode current = queue.removeFirst();
                if (null != current.left) {
                    queue.add(current.left);
                }
                if (null != current.right) {
                    queue.add(current.right);
                }

                size--;
            }
        }

        return maxDepth;
    }
}
