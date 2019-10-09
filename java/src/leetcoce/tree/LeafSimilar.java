package leetcoce.tree;

import java.util.ArrayList;
import java.util.List;

public class LeafSimilar {

    /**
     * Check if given two trees have similar leaves
     * @param root1
     * @param root2
     * @return
     */
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if (null == root1 && null == root2) {
            return true;
        }

        List<Integer> leavesOne = new ArrayList();
        List<Integer> leavesTwo = new ArrayList();

        traverse(root1, leavesOne);
        traverse(root2, leavesTwo);

        return leavesOne.equals(leavesTwo);
    }

    private void traverse(TreeNode root, List<Integer> leaves) {
        if (null == root) {
            return;
        }
        if (null == root.left && null == root.right) {
            leaves.add(root.val);
        }
        traverse(root.left, leaves);
        traverse(root.right, leaves);
    }
}
