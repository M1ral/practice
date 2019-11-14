package leetcode.dp.houserobber;

import leetcode.tree.Tree;
import leetcode.tree.TreeNode;

public class HouseRobber3 {

    public static void main(String[] args) {
        System.out.println("robTree(dummyTree()) = " + robTree(Tree.createDummyTree()));
    }

    public static int robTree(TreeNode root) {
        if (null == root) {
            return 0;
        }
        int[] result = rob(root);
        return Math.max(result[0], result[1]);
    }

    public static int[] rob(TreeNode root) {
        if (null == root) {
            return new int[]{0, 0};
        }

        int[] left = rob(root.left);
        int[] right = rob(root.right);

        int[] result = new int[2];
        result[0] = root.val + left[1] + right[1];
        result[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

        return result;
    }
}
