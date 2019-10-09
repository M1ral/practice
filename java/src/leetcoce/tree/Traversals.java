package leetcoce.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

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
        Stack<TreeNode> stack = new Stack();

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

        Stack<TreeNode> stack = new Stack();
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

        Stack<TreeNode> stack = new Stack();
        stack.push(root);

        Stack<Integer> output = new Stack();

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
}
