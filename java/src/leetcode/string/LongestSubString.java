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
    }

    /**
     * Return the length of the longest substring that has non repeating characters
     *
     * @param s
     * @return int
     */
    public static int lengthOfLongestSubstring(String s) {
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
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }

            while (map.size() > k) {
                char toRemove = temp.charAt(0);
                temp = temp.substring(1);
                map.put(toRemove, map.get(toRemove) - 1);

                if (map.get(toRemove) == 0) {
                    map.remove(toRemove);
                }
            }

            temp += ch;
            if (temp.length() > max) {
                result = temp;
                max = result.length();
            }
        }

        return result;
    }

}
