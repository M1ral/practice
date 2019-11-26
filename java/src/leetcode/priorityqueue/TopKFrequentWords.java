package leetcode.priorityqueue;

import java.util.*;

// https://leetcode.com/problems/top-k-frequent-words/
public class TopKFrequentWords {
    public static void main(String[] args) {
        System.out.println("topKFrequentWords(daily interview pro pro for  daily pro problems) = " +
                topKFrequentWords(new String[]{"daily", "interview", "pro", "pro", "for", "daily", "pro", "problems"}, 2));
    }

    public static List<String> topKFrequentWords(String[] words, int k) {
        if (null == words || words.length == 0) {
            return Collections.emptyList();
        }

        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        // create a double value comparator
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
                (a, b) -> (a.getValue() == b.getValue()
                        ? b.getKey().compareTo(a.getKey())
                        : a.getValue().compareTo(b.getValue())));

        for (Map.Entry entry : map.entrySet()) {
            pq.offer(entry);
            if (pq.size() > k)
                pq.poll();
        }

        List<String> result = new ArrayList<>();
        while (!pq.isEmpty())
            result.add(0, pq.poll().getKey());

        return result;
    }
}
