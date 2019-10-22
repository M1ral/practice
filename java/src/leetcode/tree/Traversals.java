package leetcode.tree;

import java.util.*;

public class Traversals {

    public static void main(String[] args) {
        // inorder
        System.out.println("\nIn-Order - recursive:");
        inOrderRec(Tree.createDummyTree());

        System.out.println("\nIn-Order - iterative:");
        inOrderIter(Tree.createDummyTree());

        // preorder
        System.out.println("\n\nPre-Order - recursive:");
        preOrderRec(Tree.createDummyTree());

        System.out.println("\nPre-Order - iterative:");
        preOrderIter(Tree.createDummyTree());

        // post order
        System.out.println("\n\nPost-Order - recursive:");
        postOrderRec(Tree.createDummyTree());

        System.out.println("\nnPost-Order - recursive:");
        postOrderIter(Tree.createDummyTree());

        // level order
        System.out.println("\n\n Level-Order - recursive");
        List<List<Integer>> list = new ArrayList<>();
        levelOrderRec(Tree.createDummyTree(), 0, list);
        System.out.println(Arrays.deepToString(list.toArray()));

        System.out.println("\n\n Level-Order - iterative");
        levelOrderIter(Tree.createDummyTree());
    }

    /***********************************************************
     ************************** Recursive **********************
     ***********************************************************/

    /**
     * In-order
     * @param root
     */
    public static void inOrderRec(TreeNode root) {
        if (null == root) {
            return;
        }

        inOrderIter(root.left);
        // inorder
        System.out.print(root.val + "->");
        inOrderIter(root.right);
    }

    /**
     * Pre-order
     * @param root
     */
    public static void preOrderRec(TreeNode root) {
        if (null == root) {
            return;
        }

        // preorder
        System.out.print(root.val + "->");
        preOrderRec(root.left);
        preOrderRec(root.right);
    }

    /**
     * Post-order
     * @param root
     */
    public static void postOrderRec(TreeNode root) {
        if (null == root) {
            return;
        }

        postOrderRec(root.left);
        postOrderRec(root.right);
        // postorder
        System.out.print(root.val + "->");
    }

    /***********************************************************
     ************************** Iterative **********************
     ***********************************************************/
    /**
     * iterative in-order
     * @param root
     */
    public static void inOrderIter(TreeNode root) {
        if (null == root) {
            return;
        }

        TreeNode current = root;
        Deque<TreeNode> stack = new ArrayDeque<>();

        while (null != current) {
            stack.push(current);
            current = current.left;
        }

        while (!stack.isEmpty()) {
            current = stack.pop();
            System.out.print(current.val + "->");

            if (null != current.right) {
                current = current.right;

                while (null != current) {
                    stack.push(current);
                    current = current.left;
                }
            }
        }
    }

    /**
     * Iterative pre-order
     * @param root
     */
    public static void preOrderIter(TreeNode root) {
        if (null == root) {
            return;
        }

        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            System.out.print(current.val + "->");

            if (null != current.right) {
                stack.push(current.right);
            }

            if (null != current.left) {
                stack.push(current.left);
            }
        }
    }

    /**
     * Iterative post-order
     * @param root
     */
    public static void postOrderIter(TreeNode root) {
        if (null == root) {
            return;
        }

        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);

        Deque<Integer> output = new ArrayDeque<>();

        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            output.push(current.val);

            if (null != current.left) {
                stack.push(current.left);
            }

            if (null != current.right) {
                stack.push(current.right);
            }
        }

        List<Integer> list = new ArrayList<>(output);
        Collections.reverse(list);

        for (int i : list) {
            System.out.print(i + "->");
        }
    }

    public static void levelOrderRec(
            TreeNode root, int level, List<List<Integer>> list) {
        if (null == root) {
            return;
        }
        // find the current level
        if (level == list.size()) {
            list.add(level, new ArrayList<Integer>());
        }
        // add current element to its level
        list.get(level).add(root.val);

        levelOrderRec(root.left, level + 1, list);
        levelOrderRec(root.right, level + 1, list);
    }

    /**
     * Level order iterative traversal
     * @param root
     */
    public static void levelOrderIter(TreeNode root) {
        if (null == root) {
            return;
        }

        List<List<Integer>> list = new ArrayList<>();
        Deque<TreeNode> queue = new ArrayDeque();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> currentLevel = new ArrayList<>();

            while (size != 0) {
                TreeNode current = queue.removeFirst();
                currentLevel.add(current.val);

                if (null != current.left) {
                    queue.add(current.left);
                }
                if (null != current.right) {
                    queue.add(current.right);
                }

                size--;
            }
            list.add(currentLevel);
        }
        // leetcode - for (bottom) level order traversal II
        // Collections.reverse(list);
        System.out.println(Arrays.deepToString(list.toArray()));
    }
}
