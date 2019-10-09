package leetcoce.tree;

public class Closest {

    public static void main (String[] args) {
        findClosestValueInBST(Tree.createDummyTree(), 4);
        System.out.println("goal = " + goal);

        findClosestValueInBST(Tree.createBST(new int[] {1,4,6,7,9,10}), 5);
        System.out.println("goal = " + goal);
    }

    public static int findClosestValueInBST(TreeNode root, int target) {
        traverse(root, target);
        return goal;
    }

    private static int min = Integer.MAX_VALUE;
    private static int goal;

    /**
     * Pre-order traverse the leetcoce.tree and
     *      when the target is less than the root val, go to left
     *      when the target is greater than the root val, go to right
     *
     * @param root
     * @param target
     */
    private static void traverse(TreeNode root, int target) {
        if (null == root) {
            return;
        }

        if (root.val - target < min) {
            min = root.val - target;
            goal = root.val;
        }

        if (target < root.val) {
            traverse(root.left, target);
        } else {
            traverse(root.right, target);
        }
    }
}
