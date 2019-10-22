package leetcode.tree;

import java.util.*;

public class TreeView {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(leftView(Tree.createDummyTree()).toArray()));
        System.out.println(Arrays.toString(rightView(Tree.createDummyTree()).toArray()));
    }

    public static List<Integer> leftView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (null == root) {
            return list;
        }

        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean newLevel = true;

            while (size != 0) {
                TreeNode current = queue.removeFirst();
                if (newLevel) {
                    list.add(current.val);
                    newLevel = false;
                }

                if (null != current.left) {
                    queue.add(current.left);
                }
                if (null != current.right) {
                    queue.add(current.right);
                }
                size--;
            }
        }

        return list;
    }

    public static List<Integer> rightView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (null == root) {
            return list;
        }

        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size != 0) {
                TreeNode current = queue.removeFirst();
                if (null != current.left) {
                    queue.add(current.left);
                }
                if (null != current.right) {
                    queue.add(current.right);
                }

                if (size == 1) {
                    list.add(current.val);
                }
                size--;
            }
        }

        return list;
    }
}
