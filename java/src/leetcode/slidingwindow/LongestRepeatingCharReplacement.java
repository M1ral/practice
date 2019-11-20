package leetcode.slidingwindow;

public class LongestRepeatingCharReplacement {

    public static void main(String[] args) {
        System.out.println("characterReplacement(\"ABACDEBEFD\", 1) = " + characterReplacement("ABACDEBEFD", 2));
    }

    public static int characterReplacement(String s, int k) {
        if (null == s || s.isEmpty()) {
            return 0;
        }

        int start = 0, max = 0, uniqueCount = 0, replaceCount = 0;
        int[] count = new int[26];

        for (int end = 0; end < s.length(); end++) {
            char c = s.charAt(end); // current char
            count[c - 'A']++;
            uniqueCount = Math.max(uniqueCount, count[c - 'A']);
            replaceCount = (end - start + 1) - uniqueCount;

            // if replace chars are more than k,
            // slide the window from start
            if (replaceCount > k) {
                count[s.charAt(start) - 'A']--;
                start++;
            } else {
                max = Math.max(max, end - start + 1);
            }
        }

        return max;
    }
}
