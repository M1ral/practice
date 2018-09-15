package tree;

public class TreeToStr {

    private StringBuilder sb;

    /**
     * Convert given tree to string
     *
     * @param t
     * @return String
     *
     * Input: Binary tree: [1,2,3,4]
     *        1
     *      /   \
     *     2     3
     *    /
     *   4
     *
     * Output: "1(2(4))(3)"
     *
     * Explanation: Originallay it needs to be "1(2(4)())(3()())",
     * but you need to omit all the unnecessary empty parenthesis pairs.
     * And it will be "1(2(4))(3)".
     *
     *
     * Input: Binary tree: [1,2,3,null,4]
     *        1
     *      /   \
     *     2     3
     *      \
     *       4
     *
     * Output: "1(2()(4))(3)"
     *
     * Explanation: Almost the same as the first example,
     * except we can't omit the first parenthesis pair to break the one-to-one mapping relationship between the input and the output.
     *
     */
    public String tree2str(TreeNode t) {
        if (null == t) {
            return "";
        }
        sb = new StringBuilder();
        traverse(t);
        return sb.toString();
    }

    /**
     * Traverse the tree and implement this -
     *
     * @param root
     */
    public void traverse(TreeNode root) {
        if (null == root) {
            return;
        }
        sb.append(root.val);
        if (null == root.left && null == root.right) {
            return;
        }
        // add left child
        sb.append("(");
        traverse(root.left);
        sb.append(")");

        // add right child only when it is not null
        if (null != root.right) {
            sb.append("(");
            traverse(root.right);
            sb.append(")");
        }
    }
}
