package tree;

import java.util.*;

public class PathSum {

    public static void main(String[] args) {
        System.out.println("hasPathSum(Tree.createDummyTree(), 10) = " + hasPathSumIter(Tree.createDummyTree(), 9));
        System.out.println("hasPathSumRec(Tree.createDummyTree(), 10) = " + hasPathSumRec(Tree.createDummyTree(), 9));
    }

    /**
     * Check recursively if the tree has a path that sums up to given number
     *
     * @param root
     * @param sum
     * @return boolean
     */
    public static boolean hasPathSumRec(TreeNode root, int sum) {
        if (null == root) {
            return false;
        }
        if (null == root.left && null == root.right && root.val == sum) {
            return true;
        }

        // excellent solution:
        // pass on sum - root.val to only look for that number at the end when we reach to leaf
        return hasPathSumRec(root.left, sum - root.val)
                || hasPathSumRec(root.right, sum - root.val);
    }

    /**
     * Check iteratively if tree has path that sums up to given number
     *
     * @param root
     * @param sum
     * @return boolean
     */
    public static boolean hasPathSumIter(TreeNode root, int sum) {
        if (null == root) {
            return false;
        }

        Queue<TreeNode> q = new LinkedList();
        Queue<Integer> sums = new LinkedList();

        q.add(root);
        sums.add(root.val);

        while (!q.isEmpty()) {
            TreeNode c = q.remove();
            int cSum = sums.remove();

            if (null == c.left && null == c.right && cSum == sum) {
                return true;
            }

            if (null != c.left) {
                q.add(c.left);
                sums.add(cSum + c.left.val);
            }
            if (null != c.right) {
                q.add(c.right);
                sums.add(cSum + c.right.val);
            }
        }
        return false;
    }

    /**
     * Return list of all paths that sum up to given number
     * @param root
     * @param sum
     *
     * @return list
     */
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> lists = new ArrayList();
        if (null == root) {
            return lists;
        }

        pathSum(root, lists, sum, new Stack<Integer>());
        return lists;
    }

    /**
     * Recursively maintain list of paths that sum up to given number
     *
     * @param root
     * @param lists
     * @param sum
     * @param stack
     */
    public static void pathSum(TreeNode root, List<List<Integer>> lists, int sum, Stack<Integer> stack) {
        if (null == root) {
            return;
        }

        stack.push(root.val);

        if (null == root.left && null == root.right && root.val == sum) {
            lists.add(new ArrayList(stack));
        }

        pathSum(root.left, lists, sum - root.val, stack);
        pathSum(root.right, lists, sum - root.val, stack);

        stack.pop();
    }
}
