package leetcoce.string;

import java.util.Arrays;

public class Isomorphic {

    public static void main(String[] args) {
        System.out.println("are isomorphic : " + isIsomprphic("ab", "aa"));
        System.out.println("are isomorphic : " + isIsomprphic("aba", "dcd"));
        System.out.println("are isomorphic : " + isIsomprphic("abcda", "cdeff"));
    }

    /**
     * Check if given 2 strings are isomorphic
     *
     * @param s
     * @param t
     * @return boolean
     */
    public static boolean isIsomprphic(String s, String t) {
        if (null == s || null == t) {
            return false;
        }
        if (s.length() != t.length()) {
            return false;
        }

        boolean[] visited = new boolean[256];
        int[] mapping = new int[256];
        Arrays.fill(mapping, -1);

        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);

            if (mapping[sChar] == -1) {
                if (visited[tChar] == true) {
                    return false;
                }

                mapping[sChar] = tChar;
                visited[tChar] = true;
            } else {
                if (mapping[sChar] != tChar) {
                    return false;
                }
            }

        }
        return true;
    }
}
