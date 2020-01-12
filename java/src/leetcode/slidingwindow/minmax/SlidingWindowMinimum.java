package leetcode.slidingwindow.minmax;

// https://leetcode.com/problems/minimum-window-substring/
public class SlidingWindowMinimum {

    public static void main(String[] args) {
        System.out.println("minSlidingWindow(\"ADOBECODEBANC\", \"ABC\") = " +
                minSlidingWindow("ADOBECODEBANC", "ABC"));
    }

    public static String minSlidingWindow(String s, String t) {
        if (null == s || null == t || s.isEmpty() || t.isEmpty()) {
            return "";
        }

        int[] map = new int[126];
        for (char c : t.toCharArray())
            map[c]++;

        int start = 0, end = 0, minStart = 0, count = 0, minLen = Integer.MAX_VALUE;
        while (end < s.length()) {
            if (map[s.charAt(end++)]-- > 0) {
                // char in t is found, increment count
                count++;
            }

            // when all characters in t are found, try to shrink window
            while (count == t.length()) {
                if (end - start < minLen) {
                    minLen = end - start;
                    minStart = start;
                }

                // shrink winddow by putting back characters from start
                if (map[s.charAt(start++)]++ >= 0) {
                    count--;
                }
            }
        }
        return minLen == Integer.MAX_VALUE
                ? ""
                : s.substring(minStart, minStart + minLen);
    }
}
