package tree;

public class Subtree {

    public static void main(String[] args) {
        /*System.out.println("matchTree = " + matchTree(Tree.createDummyTree(), Tree.createBST(new int[] {1,2,3,4,5,6,7})));
        System.out.println("subTree(Tree.createDummyTree(), Tree.createBST(new int[]{1,2,3,4,5,6,7})) = " +
                subTree(Tree.createDummyTree(), Tree.createBST(new int[]{5,6,7})));*/
        System.out.println("subTree([1,1], [1]) = " +
                subTree(Tree.createBST(new int[]{1,1}), Tree.createBST(new int[]{1})));
    }

    /**
     * Check if given target tree is a subtree of source
     *
     * @param s
     * @param t
     * @return boolean
     *
     * T(n) = O(mn)
     * S(n) = O(log m + long n)
     */
    public static boolean subTree(TreeNode s, TreeNode t) {
        if (null == s) {
            return false;
        }
        if (s.val == t.val) {
            if (matchTree(s, t)) {
                return true;
            }
        }
        return subTree(s.left, t) || subTree(s.right, t);
    }

    public static boolean matchTree(TreeNode s, TreeNode t) {
        if (null == s && null == t) {
            return true;
        }
        if (null == s || null == t) {
            return false;
        }
        if (s.val != t.val) {
            return false;
        }
        return matchTree(s.left, t.left) && matchTree(s.right, t.right);
    }
}

