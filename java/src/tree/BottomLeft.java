package tree;

import java.util.LinkedList;
import java.util.Queue;

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

        Queue<TreeNode> q = new LinkedList();
        q.add(root);

        while (!q.isEmpty()) {
            root = q.remove();
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
