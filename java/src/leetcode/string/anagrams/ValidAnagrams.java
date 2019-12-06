package leetcode.string.anagrams;

public class ValidAnagrams {

    public static void main(String[] args) {
        System.out.println(isAnagram("miral", "iraml"));
    }

    public static boolean isAnagram(String s, String t) {
        if (null == s || null == t) {
            return false;
        }
        if (s.length() != t.length()) {
            return false;
        }
        if (s.isEmpty() && t.isEmpty()) {
            return true;
        }

        int[] chars = new int[26];
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();

        for (char ch : sChars)
            chars[ch - 'a']++;

        for (char ch : tChars)
            chars[ch - 'a']--;

        for (int n : chars)
            if (n != 0)
                return false;

        return true;
    }
}
