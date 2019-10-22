package leetcode.tree;

public class BalancedAndBST {

    public static void main(String[] args) {
        TreeNode root = Tree.createDummyTree();
        System.out.println("isBalancedTree(root) = " + isBalancedTree(root));
        System.out.println("Tree.isBST(Tree.createDummyTree()) = " + Tree.isBST(Tree.createDummyTree()));
    }

    /**
     * Check if given binary leetcoce.tree is balanced
     *
     * if a node's left height and right height differs by more than 1,
     * then it is NOT balanced leetcoce.tree
     *
     * @param root
     * @return boolean
     */
    public static boolean isBalancedTree(TreeNode root) {
        if (null == root) {
            return false;
        }

        return checkHeight(root) != -1;
    }

    /**
     * Checks left and right height difference for given treeNode,
     * returns -1 if the diff is greater than 1
     *
     * @param treeNode
     * @return
     */
    public static int checkHeight(TreeNode treeNode) {
        if (null == treeNode) {
            return 0;
        }

        int leftHeight = checkHeight(treeNode.left);
        if (leftHeight == -1) {
            return -1;
        }

        int rightHeight = checkHeight(treeNode.right);
        if (rightHeight == -1) {
            return -1;
        }

        int heightDiff = Math.abs(leftHeight - rightHeight);
        if (heightDiff > 1) {
            return -1;
        }

        return 1 + Math.max(leftHeight, rightHeight);
    }
}
