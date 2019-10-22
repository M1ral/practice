package leetcode.tree;

public class LCA {

    public static void main(String[] args) {
        TreeNode root = Tree.createDummyTree();
        System.out.println("findLCAInBST(root, new TreeNode(1), new TreeNode(7)) = " +
                findLCAInBST(root, new TreeNode(1), new TreeNode(25)).val);
    }

    /**
     * Return the least common ancestor for given 2 leetcoce.tree nodes
     * in a binary search leetcoce.tree
     *
     * @param root
     * @param n1
     * @param n2
     * @return TreeNode
     *
     * Tushar Roy solution
     * https://github.com/mission-peace/interview/blob/master/src/com/interview/tree/LowestCommonAncestoryBinarySearchTree.java
     *
     * T(n) = O(h)
     * S(n) = O(h)
     */
    public static TreeNode findLCAInBST(TreeNode root, TreeNode n1, TreeNode n2) {
        if (root.val > Math.max(n1.val, n2.val)) {
            return findLCAInBST(root.left, n1, n2);
        } else if (root.val < Math.min(n1.val, n2.val)) {
            return findLCAInBST(root.right, n1, n2);
        } else {
            return root;
        }
    }

    /**
     * @param root
     * @param n1
     * @param n2
     * @return TreeNode
     *
     * Tushar Roy solution
     * https://github.com/mission-peace/interview/blob/master/src/com/interview/tree/LowestCommonAncestorInBinaryTree.java
     * https://www.youtube.com/watch?v=13m9ZCB8gjw
     *
     * T(n) = O(n)
     * S(n) = O(h)
     */
    public static TreeNode findLCABinaryTree(TreeNode root, TreeNode n1, TreeNode n2) {
        if (null == root) {
            return null;
        }
        if (root.val == n1.val || root.val == n2.val) {
            return root;
        }

        TreeNode left = findLCABinaryTree(root.left, n1, n2);
        TreeNode right = findLCABinaryTree(root.right, n1, n2);

        if (null != left && null != right) {
            return root;
        }
        return null != left ? left : right;
    }
}
