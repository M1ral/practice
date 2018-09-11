package tree;

public class BSTGreaterTree {

    public TreeNode convertBST(TreeNode root) {
        if (null == root) {
            return null;
        }
        //traverse(root);
        reverseInOrder(root, new int[1]); // use array to avoid using global variable
        return root;
    }

    int sum = 0;
    public void traverse(TreeNode root) {
        if (null == root) {
            return;
        }
        traverse(root.right);
        sum += root.val;
        root.val = sum;
        traverse(root.left);
    }

    public void reverseInOrder(TreeNode root, int[] sum) {
        if (null == root) {
            return;
        }
        reverseInOrder(root.right, sum);

        // access value here
        root.val += sum[0];
        sum[0] = root.val;

        reverseInOrder(root.left, sum);
    }
}
