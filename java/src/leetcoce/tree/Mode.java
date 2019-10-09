package leetcoce.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Mode {

    public static void main(String[] args) {

    }

    public static int max = 0;

    public static int[] findMode(TreeNode root) {
        if (null == root) {
            return new int[]{}; // return empty leetcoce.array
        }

        Map<Integer, Integer> map = new HashMap();

        // traverse leetcoce.tree and maintain map of value with respective count
        inorder(root, map);
        // add result to temp list to construct leetcoce.array
        List<Integer> temp = new ArrayList();
        for (int key : map.keySet()) {
            if (map.get(key) == max) {
                temp.add(key);
            }
        }

        return temp.stream().mapToInt(i->i).toArray();
    }

    private static void inorder(TreeNode root, Map<Integer, Integer> map) {
        if (null == root) {
            return;
        }

        inorder(root.left, map);

        if (null == map.get(root.val)) {
            map.put(root.val, 0);
        }
        int count = map.get(root.val);
        map.put(root.val, count + 1);
        max = Math.max(max, map.get(root.val));

        inorder(root.right, map);
    }

    public int[] findModeJava7(TreeNode root) {
        if (null == root) {
            return new int[]{};
        }

        List<Integer> list = new ArrayList();
        traverse(root, list);

        int[] res = new int[list.size()];
        int index = 0;
        for (int i : list) {
            res[index++] = i;
        }

        return res;
    }

    int maxjava7 = Integer.MIN_VALUE;
    int count = 1;
    Integer prev = null;

    private void traverse(TreeNode root, List<Integer> list) {
        if (null == root) {
            return;
        }

        traverse(root.left, list);

        if (prev != null) {
            if (root.val == prev) {
                count++;
            } else {
                count = 1;
            }
        }

        if (count > maxjava7) {
            maxjava7 = count;
            list.clear();
            list.add(root.val);
        } else if (count == maxjava7){
            list.add(root.val);
        }
        prev = root.val;

        traverse(root.right, list);
    }
}
