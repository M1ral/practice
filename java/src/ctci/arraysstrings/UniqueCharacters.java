package ctci.arraysstrings;

public class UniqueCharacters {

    public static void main(String[] args) {
        System.out.println("uniqueChars(\"abcddefgh\") = " + uniqueChars("abcddefgh"));
        System.out.println("uniqueChars(\"abcdefg\") = " + uniqueChars("abcdefg"));
        System.out.println("uniqueChars(\"aabbbccc\") = " + uniqueChars("aabbbccc"));
        System.out.println("uniqueChars(\"abcc\") = " + uniqueChars("abcc"));
    }

    public static boolean uniqueChars(String s) {
        if (null == s || s.isEmpty()) {
            return true;
        }
        if (s.length() > 128) {
            // characters more than ASCII chars length, there must
            // be duplicate characters in string
            return false;
        }

        boolean[] chars = new boolean[128];
        char[] sChars = s.toCharArray();
        for (char c : sChars) {
            if (chars[c] == true) {
                return false;
            }
            chars[c] = true;
        }
        return true;
    }
}
