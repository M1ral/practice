package leetcode.slidingwindow.substring.distinct;

import java.util.HashMap;
import java.util.Map;

// Leetcode premium (Google 2018)
public class LengthWithAtMost2DistinceCharacters {
    public static void main(String[] args) {
        System.out.println("withAtMost2DistinctCharacters(\"ABABBBACDDCAB\") = " +
                withAtMost2DistinctCharacters("ABABBBACDDCAB"));
    }

    // ABABBBACDDCAB - ABABBBA, AC, CDDC, CD, AB
    public static int withAtMost2DistinctCharacters(String s) {
        if (null == s || s.isEmpty()) {
            return 0;
        }

        Map<Character, Integer> map = new HashMap();
        int max = 0;
        String temp = "";

        for (char ch : s.toCharArray()) {
            // add char to map
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            // remove element when map size > 2
            while (map.size() > 2) {
                char toRemove = temp.charAt(0);
                temp = temp.substring(1);
                map.put(toRemove, map.get(toRemove) - 1);

                // remove excess char from map and substring
                if (map.get(toRemove) == 0) {
                    map.remove(toRemove);
                }
            }

            // add char to temp
            temp += ch;
            max = Math.max(max, temp.length());
        }

        return max;
    }
}
