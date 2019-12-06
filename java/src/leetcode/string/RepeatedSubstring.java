package leetcode.string;

public class RepeatedSubstring {

    // https://leetcode.com/problems/repeated-substring-pattern/ (Google)
    public static void main(String[] args) {
        System.out.println("isRepeatedSubstring(\"abab\") = " + isRepeatedSubstring("abab"));
        System.out.println("isRepeatedSubstring(\"abcd\") = " + isRepeatedSubstring("abcd"));
        System.out.println("isRepeatedSubstring(\"abcabc\") = " + isRepeatedSubstring("abcabc"));
    }

    public static boolean isRepeatedSubstring(String s) {
        if (null == s || s.isEmpty()) {
            return false;
        }

        String t = s + s;
        return t.substring(1, t.length() - 1).contains(s);
    }
}
