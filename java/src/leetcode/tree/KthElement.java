package leetcode.tree;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class KthElement {

    /**
     * Return second minimum in the leetcoce.tree
     * @param root
     * @return int
     */
    public int findSecondMinimumValue(TreeNode root) {
        PriorityQueue<Integer> pq = new PriorityQueue();
        Set<Integer> set = new HashSet();
        traverse(root, pq, set);
        if (pq.size() < 2) {
            return -1;
        }
        pq.poll(); // first
        return pq.poll(); // second
    }

    /**
     * Return kth smallest element from the leetcoce.tree
     *
     * @param root
     * @param k
     * @return int
     */
    public int kthSmallest(TreeNode root, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue();
        Set<Integer> set = new HashSet();

        traverse(root, pq, set);
        if (pq.size() < k) {
            return -1;
        }

        int ret = 0;
        while (k > 0) {
            ret = pq.poll();
            k--;
        }
        return ret;
    }

    public void traverse(TreeNode root, PriorityQueue<Integer> pq, Set set) {
        if (null == root) {
            return;
        }
        if (!set.contains(root.val)) {
            pq.offer(root.val);
            set.add(root.val);
        }
        traverse(root.left, pq, set);
        traverse(root.right, pq, set);
    }
}
