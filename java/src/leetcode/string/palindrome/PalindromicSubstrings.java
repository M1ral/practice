package leetcode.string.palindrome;

// https://leetcode.com/problems/palindromic-substrings/
public class PalindromicSubstrings {
    public static void main(String[] args) {
        System.out.println("countSubstrings(\"aaa\") = " + countSubstrings("aaa"));
    }

    public static int countSubstrings(String s) {
        if (null == s || s.isEmpty()) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            count += expand(s, i, i, 0);
            count += expand(s, i, i+1, 0);
        }
        return count;
    }

    private static int expand(String s, int start, int end, int count) {
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            count++; start--; end++;
        }
        return count;
    }
}
