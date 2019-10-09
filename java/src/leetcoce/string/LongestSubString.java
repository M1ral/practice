package leetcoce.string;

import java.util.HashSet;
import java.util.Set;

public class LongestSubString {

    public static void main(String[] args) {
        System.out.println("lengthOfLongestSubstring(\"abcc\") = " + lengthOfLongestSubstring("abcc"));
        System.out.println("lengthOfLongestSubstring(\"abcabcd\") = " + lengthOfLongestSubstring("abcabcd"));
        System.out.println("lengthOfLongestSubstring(\"ababcdabc\") = " + lengthOfLongestSubstring("ababcdabc"));
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
                    if (s.charAt(k) == ch) {
                        k++;
                        break;
                    } else {
                        set.remove(s.charAt(k));
                        k++;
                    }
                }
            }
            i++;
        }
        return result;
    }
}
