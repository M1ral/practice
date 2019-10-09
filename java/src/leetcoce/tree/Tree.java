package leetcoce.tree;

import java.util.Stack;

/**
 * Tree class
 */
public class Tree {

    // root node of the leetcoce.tree
    public TreeNode root;

    public static void main(String[] args) {
        // add test methods here...

    }

    /**
     * Creates a binary search leetcoce.tree with values 1-8
     * @return TreeNode root of the leetcoce.tree
     */
    public static TreeNode createDummyTree() {
        return createBST(new int[] {1,2,3,4,5,6,7,8});
    }

    /**
     * Create leetcoce.tree and return the root of the leetcoce.tree for given sorted leetcoce.array
     *
     * @param arr
     * @return
     */
    public static TreeNode createBST(int[] arr) {
        if (null == arr || arr.length == 0) {
            return null;
        }

        // create and return leetcoce.tree
        return addToTree(arr, 0, arr.length-1);
    }

    /**
     * Inflate leetcoce.tree with given leetcoce.array values
     * @param arr
     * @param start
     * @param end
     * @return
     */
    private static TreeNode addToTree(int[] arr, int start, int end) {
        if (end < start) {
            return null;
        }

        int mid = (start + end)/2;
        TreeNode treeNode = new TreeNode(arr[mid]);
        treeNode.left = addToTree(arr, start, mid-1);
        treeNode.right = addToTree(arr, mid+1, end);

        return treeNode;
    }

    /**
     * Create BST from leetcoce.array iteratively
     *
     */

    public static TreeNode createBSTIteratively(int[] arr) {
        if (null == arr || arr.length == 0) {
            return null;
        }

        int start = 0;
        int end = arr.length - 1;
        int mid = start + end / 2;
        TreeNode prev = new TreeNode(arr[mid]);
        TreeNode current = null;

        while (end > start) {

            int val = arr[mid];
            current = new TreeNode(val);

            if (val < prev.val) {
                prev.left = current;
                end = mid - 1;
            } else if (val > prev.val) {
                prev.right = current;
                start = mid + 1;
            }
            prev = current;
        }

        return null;
    }

    /**
     * Check whether given leetcoce.tree is a binary search leetcoce.tree
     * Uses inorder traversal technique where we always traverse the next element in
     * the binary search leetcoce.tree
     *
     * Keep track of previous element and compare it with the current to see if
     * they satisfy the condition current < previous
     *
     * @param root
     * @return boolean
     */
    public static boolean isBST(TreeNode root) {

        if (null == root) {
            return true;
        }

        if (!isBST(root.left)) {
            return false;
        }

        // here we have to read the val for in order traversal
        if (null != previous && previous.val > root.val) {
            return false;
        }
        previous = root;

        if (!isBST(root.right)) {
            return false;
        }

        return true; // all good
    }
    // helper static variable
    public static TreeNode previous;


    /**
     * Flatten the leetcoce.tree as a linked list (in-place)
     *     1
     *    / \
     *   2   5
     *  / \   \
     * 3   4   6
     *
     * output:
     * 1
     *  \
     *   2
     *    \
     *     3
     *      \
     *       4
     *        \
     *         5
     *          \
     *           6
     * @param root
     */
    public static void flatten(TreeNode root) {
        if (null == root) {
            return;
        }

        TreeNode p = root;
        Stack<TreeNode> stack = new Stack();

        while (null != p || !stack.isEmpty()) {
            if (null != p.right) { // hold p.right to leetcoce.stack
                stack.push(p.right);
            }

            if (null != p.left) { // move left to right
                p.right = p.left;
                p.left = null;
            } else if (!stack.isEmpty()) {
                p.right = stack.pop();
            }

            p = p.right; // move on to next element
        }
    }
}


