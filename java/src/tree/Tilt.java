package tree;

public class Tilt {

    public static void main(String[] args) {
        System.out.println("findTilt(Tree.createDummyTree()) = " + findTilt(Tree.createBST(new int[]{1,2,3})));
    }

    private static int tilt = 0;
    public static int findTilt(TreeNode root) {
        if (null == root) {
            return 0;
        }
        traverse(root);
        return tilt;
    }

    private static int traverse(TreeNode root) {
        if (null == root) {
            return 0;
        }

        int leftTilt = traverse(root.left);
        int rightTilt = traverse(root.right);
        tilt += Math.abs(leftTilt - rightTilt);

        return leftTilt + rightTilt + root.val;
    }
}
