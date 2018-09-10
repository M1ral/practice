package tree;

import java.util.ArrayList;
import java.util.List;

public class Treepath {

    public static void main(String[] args) {
        System.out.println("binaryTreePaths(Tree.createDummyTree()) = " + binaryTreePaths(Tree.createDummyTree()));
    }

    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList();
        if (null == root) {
            return list;
        }
        String s = "";
        traverse(root, s, list);
        return list;
    }

    private static void traverse(TreeNode root, String s, List<String> list) {
        if (null == root) {
            return;
        }

        s = s + "->" + root.val; // add val to string

        if (null == root.left && null == root.right) {
            list.add(s.substring(2));
        }

        if (null != root.left) {
            traverse(root.left, s, list);
        }
        if (null != root.right) {
            traverse(root.right, s, list);
        }
    }
}

