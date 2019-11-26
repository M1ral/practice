package leetcode.priorityqueue;

import java.util.*;

public class TopKFrequentElements {

    // https://leetcode.com/problems/top-k-frequent-elements/
    public static void main(String[] args) {

    }

    public static List<Integer> topKFrequentElements(int[] nums, int k) {
        if (null == nums || nums.length == 0) {
            return Collections.emptyList();
        }

        Map<Integer, Integer> map = new HashMap();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> pq =
                new PriorityQueue<>((a, b) -> Integer.compare(a.getValue(), b.getValue()));

        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            pq.offer(e);
            if (pq.size() > k) pq.poll();
        }

        List<Integer> list = new ArrayList();
        while (!pq.isEmpty()) {
            list.add(pq.poll().getKey());
        }

        return list;
    }
}
