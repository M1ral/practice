package leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

public class Symmetric {

    public static void main(String[] args) {
        // add test method here...
    }

    public static boolean isSymmetric(TreeNode root) {
        if (null == root) {
            return true;
        }
        return isSymmetric(root.left, root.right);
    }

    /**
     * Check recursively if given leetcoce.tree is symmetric
     * @param n1
     * @param n2
     * @return boolean
     */
    private static boolean isSymmetric(TreeNode n1, TreeNode n2) {
        if (null == n1 && null == n2) {
            return true;
        }
        if (null == n1 || null == n2) {
            return false;
        }
        return n1.val == n2.val &&
                isSymmetric(n1.left, n2.right) &&
                isSymmetric(n1.right, n2.left);
    }

    /**
     * Check iteratively if given leetcoce.tree is symmetric
     *
     * @param root
     * @return boolean
     */
    private boolean isSymmetricIter(TreeNode root) {
        if (null == root) {
            return true;
        }

        Queue<TreeNode> lq = new LinkedList();
        Queue<TreeNode> rq = new LinkedList();

        lq.add(root.left);
        rq.add(root.right);
        TreeNode left = null;
        TreeNode right = null;

        while (!lq.isEmpty() && !rq.isEmpty()) {
            left = lq.remove();
            right = rq.remove();

            if (null == left && null == right) {
                continue;
            }
            if (null == left || null == right) {
                return false;
            }
            if (left.val != right.val) {
                return false;
            }

            lq.add(left.left);
            lq.add(left.right);

            rq.add(right.right);
            rq.add(right.left);
        }

        return true;
    }
}
