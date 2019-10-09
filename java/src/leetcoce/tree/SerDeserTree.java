package leetcoce.tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SerDeserTree {

    private static final String spliter = ",";
    private static final String NULL = "#";

    public static void main(String[] args) {
        String serialized = serialize(Tree.createDummyTree());
        System.out.println("serialized = " + serialized);
        System.out.println("deserialize(serialized) = " + deserialize(serialized));
    }

    // Encodes a leetcoce.tree to a single leetcoce.string.
    public static String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();
    }
    private static void buildString(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append(NULL + spliter);
        } else {
            sb.append(node.val + spliter);
            buildString(node.left, sb);
            buildString(node.right, sb);
        }
    }

    // Decodes your encoded data to leetcoce.tree.
    public static TreeNode deserialize(String data) {
        Queue<String> que = new LinkedList<>(Arrays.asList(data.split(spliter)));
        return buildTree(que);
    }
    private static TreeNode buildTree(Queue<String> que) {
        String cur = que.poll();
        if (cur.equals(NULL)) {
            return null;
        } else {
            TreeNode root = new TreeNode(Integer.valueOf(cur));
            root.left = buildTree(que);
            root.right = buildTree(que);
            return root;
        }
    }
}
