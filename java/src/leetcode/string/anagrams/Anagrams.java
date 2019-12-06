package leetcode.string.anagrams;

public class Anagrams {

    public static void main(String[] args) {
        anagrams("", "abc");
        backtrackAnagrams("abc");
    }

    public static void anagrams(String prefix, String s) {
        if (null == s || null == prefix) {
            return;
        }
        if (s.isEmpty()) {
            System.out.println("anagram = " + prefix);
        }

        for (int i = 0; i < s.length(); i++) {
            anagrams(prefix + s.charAt(i), s.substring(0, i) + s.substring(i+1));
        }
    }

    public static void backtrackAnagrams(String s) {
        backtrack("", s);
    }

    public static void backtrack(String s, String chosen) {
        if (null == s || s.isEmpty()) {
            System.out.println(chosen);
            return;
        }

        for (int i = 0; i < s.length(); i++) {
            // choose
            chosen += s.charAt(i);
            // call
            backtrack(s.substring(0, i) + s.substring(i+1), chosen);
            // unchoose
            chosen = chosen.substring(0, chosen.length() - 1);
        }
    }
}
