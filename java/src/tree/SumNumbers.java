package tree;

public class SumNumbers {

    public static void main(String[] args) {
        System.out.println("sumNumbers(Tree.createBST(1,2,3)) = " + sumNumbers(Tree.createBST(new int[] {1, 2, 3})));
    }

    public static int sumNumbers(TreeNode root) {
        if (null == root) {
            return 0;
        }
        traverse(root, 0);
        return total;
    }

    private static int total = 0;

    public static void traverse(TreeNode root, int sum) {
        if (null == root) {
            return;
        }

        sum = (sum * 10) + root.val;
        // leaf node - add to total
        if (null == root.left && null == root.right) {
            total += sum;
            return;
        }

        traverse(root.left, sum);
        traverse(root.right, sum);

        sum -= root.val;
        sum = sum / 10; // may be not needed here
    }
}
