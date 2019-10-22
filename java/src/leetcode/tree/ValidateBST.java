package leetcode.tree;

public class ValidateBST {

    public static void main(String[] args) {
        ValidateBST validateBST = new ValidateBST();
        System.out.println(validateBST.check(Tree.createDummyTree()));
    }

    private TreeNode prev = null;

    private boolean check(TreeNode root) {
        if (null == root) {
            return true;
        }

        if (!check(root.left)) {
            return false;
        }

        TreeNode current = root;
        if (prev != null) {
            if (current.val <= prev.val) {
                return false;
            }
        }
        prev = current;

        if (!check(root.right)) {
            return false;
        }

        return true;
    }
}
