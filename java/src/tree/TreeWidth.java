package tree;

import java.util.ArrayList;
import java.util.List;

public class TreeWidth {

    public static void main(String[] args) {
        System.out.println("widthOfBinaryTree(Tree.createDummyTree()) = " + widthOfBinaryTree(Tree.createDummyTree()));
    }

    public static int widthOfBinaryTree(TreeNode root) {
        if (null == root) {
            return 0;
        }

        List<TreeNode> list = new ArrayList();
        list.add(root);

        List<TreeNode> currentList = null;
        int width = 0;

        while (!list.isEmpty()) {
            int size = list.size();
            // left most and right most in the queue construct width
            int currentWidth = (list.get(0) != null && list.get(list.size() - 1) != null) ? list.size() : Integer.MIN_VALUE;
            width = Math.max(width, currentWidth);

            currentList = new ArrayList();

            int index = 0;
            for (TreeNode n : list) {
                if (null == n) {
                    continue;
                }
                currentList.add(index++, n.left);
                currentList.add(index++, n.right);
            }
            list = currentList;

        }
        return width;
    }
}
