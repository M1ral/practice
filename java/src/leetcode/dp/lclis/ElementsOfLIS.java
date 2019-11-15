package leetcode.dp.lclis;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ElementsOfLIS {

    public static void main(String[] args) {
        System.out.println("getElementsOfLIS({3, 5, 6, 2, 5, 4, 19, 5, 6, 7, 12, 2, 3}) = " +
                getElementsOfLIS(new int[]{3, 5, 6, 2, 5, 4, 19, 5, 6, 7, 12, 2, 3}));
    }
    public static List<Integer> getElementsOfLIS(int[] nums) {
        if (null == nums || nums.length == 0) {
            return Collections.emptyList();
        }

        List<Node> piles = new ArrayList<>();
        for (int n : nums) {
            Node node = new Node(n);

            int index = Collections.binarySearch(piles, node);
            if (index < 0) {
                index = - (index + 1);
            }

            if (index != 0) {
                node.prev = piles.get(index - 1);
            }

            if (index == piles.size()) {
                piles.add(node);
            } else {
                piles.set(index, node);
            }
        }

        // extract nodes
        return extractLIS(piles);
    }

    public static List<Integer> extractLIS(List<Node> piles) {
        if (null == piles || piles.isEmpty()) {
            return Collections.emptyList();
        }

        List<Integer> result = new ArrayList<>();
        for (Node curr = piles.get(piles.size() - 1); curr != null; curr = curr.prev) {
            result.add(curr.val);
        }

        // reverse list
        Collections.reverse(result);
        return result;
    }

}

class Node implements Comparable<Node> {
    public int val;
    public Node prev;

    public int getVal() {
        return this.val;
    }

    public Node(int val) {
        this.val = val;
        this.prev = null;
    }

    @Override
    public int compareTo(Node o) {
        return Integer.compare(this.val, o.val);
    }
}
