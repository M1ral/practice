package leetcode.slidingwindow.substring.distinct;

import java.util.HashMap;
import java.util.Map;

// Leetcode premium
public class LengthWithAtMostKDistinctCharacters {

    public static void main(String[] args) {
        System.out.println("withAtMost2DistinctCharacters(\"ABABBBACDDCAB\") = " +
                withAtMostKDistinctCharacters("ABABBBACDDCAB", 2));

        System.out.println("withAtMost2DistinctCharacters(\"ABABBBACDDCAB\") = " +
                withAtMostKDistinctCharacters("ABABBBACDDCAB", 3));
    }

    // ABABBBACDDCAB - ABABBBA, AC, CDDC, CD, AB (K = 2)
    // ABABBBACDDCAB - ABABBBAC, (K = 3)
    public static int withAtMostKDistinctCharacters(String s, int K) {
        if (null == s || s.isEmpty()) {
            return 0;
        }

        Map<Character, Integer> map = new HashMap();
        int max = 0;
        String temp = "";

        for (char ch : s.toCharArray()) {
            // add char to map
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            // remove element when map size > K
            while (map.size() > K) {
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
