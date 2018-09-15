package tree;

import java.util.Stack;

/**
 * BST Iterator for BST Tree
 *
 * Perform inorder traversal underneath and maintain nodes in the stack
 *
 */
public class BSTIterator {

    private Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        stack = new Stack();
        while (null != root) {
            stack.push(root);
            root = root.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        if (!hasNext()) {
            return -1;
        }

        TreeNode current = stack.pop();
        int ret = current.val;

        if (null != current.right) {
            current = current.right;
            while (null != current) {
                stack.push(current);
                current = current.left;
            }
        }
        return ret;
    }
}