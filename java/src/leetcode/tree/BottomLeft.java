package leetcode.tree;

import java.util.ArrayDeque;
import java.util.Deque;

public class BottomLeft {

    public static void main(String[] args) {
        System.out.println(findBottomLeftValue(Tree.createDummyTree()));
    }

    /**
     * Return Bottom left value of the Tree
     * Perform BFS iteratively (right to left)
     *
     * @param root
     * @return int
     */
    public static int findBottomLeftValue(TreeNode root) {
        if (null == root) {
            return -1;
        }

        Deque<TreeNode> q = new ArrayDeque<>();
        q.add(root);

        while (!q.isEmpty()) {
            root = q.removeFirst();
            if (null != root.right) {
                q.add(root.right);
            }
            if (null != root.left) {
                q.add(root.left);
            }
        }
        return root.val;
    }
}
