package tree;

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
            return new int[]{}; // return empty array
        }

        Map<Integer, Integer> map = new HashMap();

        // traverse tree and maintain map of value with respective count
        inorder(root, map);
        // add result to temp list to construct array
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
}
