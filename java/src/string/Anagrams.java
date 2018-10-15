package string;

public class Anagrams {

    public static void main(String[] args) {
        anagrams("", "abc");
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
}
