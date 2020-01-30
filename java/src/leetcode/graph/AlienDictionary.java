package leetcode.graph;

public class AlienDictionary {

    public static void main(String[] args) {
        System.out.println("isAlienSorted = " + isAlienSorted(
                new String[]{"word", "world", "row"},
                "worldabcefghijkmnpqstuvxyz"));

        System.out.println("isAlienSorted = " + isAlienSorted(
                new String[]{"app", "apple"},
                "abcdefghijklmnopqrstuvwxyz"));
    }

    public static boolean isAlienSorted(String[] words, String order) {
        if (null == words || words.length == 0) {
            return false;
        }
        int[] map = new int[26];
        for (int i = 0; i < order.length(); i++) {
            map[order.charAt(i) - 'a'] = i;
        }

        for (int i = 1; i < words.length; i++) {
            if (compare(words[i-1], words[i], map) > 0) {
                return false;
            }
        }

        return true;
    }

    private static int compare(String s, String t, int[] map) {
        for (int i=0; i < s.length() && i < t.length(); i++) {
            int cmp = map[s.charAt(i) - 'a'] - map[t.charAt(i) - 'a'];
            if (cmp != 0) {
                return cmp;
            }
        }
        // if one word is the prefix of the other, compare their sizes
        return s.length() - t.length();
    }
}
