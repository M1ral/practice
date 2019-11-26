package leetcode.priorityqueue;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

// https://leetcode.com/problems/sort-characters-by-frequency/
public class SortCharsByFrequency {
    public static void main(String[] args) {
        System.out.println("frequencySort(\"tree\") = " + frequencySort("tree"));
    }

    public static String frequencySort(String s) {
        if (null == s || s.isEmpty()) {
            return s;
        }

        Map<Character, Integer> map = new HashMap();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(
                (a, b) -> Integer.compare(b.getValue(), a.getValue())
        );

        for (Map.Entry<Character, Integer> e : map.entrySet()) {
            pq.offer(e);
        }

        StringBuilder result = new StringBuilder();
        while (!pq.isEmpty()) {
            Map.Entry<Character, Integer> entry = pq.peek();
            int count = entry.getValue();

            while (count > 0) {
                result.append(entry.getKey());
                count--;
            }
            pq.poll();
        }

        return result.toString();
    }
}
