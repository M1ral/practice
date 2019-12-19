package leetcode.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubString {

    public static void main(String[] args) {
        System.out.println("lengthOfLongestSubstring(\"abcc\") = " + lengthOfLongestSubstring("abcc"));
        System.out.println("lengthOfLongestSubstring(\"abcabcd\") = " + lengthOfLongestSubstring("abcabcd"));
        System.out.println("lengthOfLongestSubstring(\"ababcdabc\") = " + lengthOfLongestSubstring("ababcdabc"));
        System.out.println("withKUniqueChars(\"ababcdabc\") = " + withKUniqueChars("ababcddddccabc", 2));
        System.out.println("with2UniqueChars(\"ababcdabc\") = " + with2UniqueChars("ababcddddccabc"));
        // https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/
        System.out.println("with2UniqueChars(\"ababcdabc\") = " + withAtleastKRepeatingChars("ababcddddccabc"));
    }

    public static int lengthOfLongestSubstring(String s) {
        if (null == s || s.isEmpty()) {
            return 0;
        }

        Map<Character, Integer> map = new HashMap();
        char[] chars = s.toCharArray();
        int start = 0, end = s.length(), max = Integer.MIN_VALUE;
        String temp = "";

        while (start < end) {
            char ch = chars[start++];
            temp += ch;
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            while (map.get(ch) > 1) {
                char toRemove = temp.charAt(0);
                temp = temp.substring(1);
                map.put(toRemove, map.get(toRemove) - 1);
            }

            max = Math.max(max, temp.length());
        }

        return max;
    }

    /**
     * Return the length of the longest substring that has non repeating characters
     *
     * @param s
     * @return int
     */
    public static int lengthOfLongestSubstringWithSet(String s) {
        if (null == s || s.isEmpty()) {
            return -1;
        }

        int result = Integer.MIN_VALUE;
        Set<Character> set = new HashSet<>();
        char[] chars = s.toCharArray();
        int i = 0, k = 0;

        for (char ch : chars) {
            if (!set.contains(ch)) {
                set.add(ch);
                result = Math.max(set.size(), result);
            } else {
                while (k < i) {
                    if (chars[k] == ch) {
                        k++;
                        break;
                    } else {
                        set.remove(chars[k]);
                        k++;
                    }
                }
            }
            i++;
        }
        return result;
    }

    public static String withKUniqueChars(String input, int k) {
        if (null == input || input.isEmpty()) {
            return input;
        }

        Map<Character, Integer> map = new HashMap<>();
        char[] chars = input.toCharArray();
        String result = "", temp = "";
        int max = Integer.MIN_VALUE;

        for (char ch : chars) {
            // 1. add current char to map
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            // 2. if map size > 2, remove chars until map size = 2
            while (map.size() > k) {
                char toRemove = temp.charAt(0);
                temp = temp.substring(1);
                map.put(toRemove, map.get(toRemove) - 1);

                if (map.get(toRemove) == 0) {
                    map.remove(toRemove);
                }
            }
            // 3. add current char to candidate and compute max
            temp += ch;
            if (temp.length() > max) {
                result = temp;
                max = result.length();
            }
        }

        return result;
    }

    /**
     * Map (char -> count)
     * 1. add ch to map
     * 2. if map size > 2, remove chars until map size becomes 2
     * 3. add ch to candidate and compute max length candidate
     *
     * @param s
     * @return
     */
    public static int with2UniqueChars(String s) {
        if (null == s || s.isEmpty()) {
            return 0;
        }

        Map<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        String candidate = "";
        int max = Integer.MIN_VALUE;

        for (char ch : chars) {
            // 1. add current char to map
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            // 2. check map size and remove until map size = 2
            while (map.size() > 2) {
                char toRemove = candidate.charAt(0);
                candidate = candidate.substring(1);
                map.put(toRemove, map.get(toRemove) - 1);

                if (map.get(toRemove) == 0) {
                    map.remove(toRemove);
                }
            }
            // 3. add current char to candidate and compute max length
            candidate += ch;
            max = Math.max(max, candidate.length());
        }
        return max;
    }

    public static int withAtleastKRepeatingChars(String str) {
        return 0;
    }
}
