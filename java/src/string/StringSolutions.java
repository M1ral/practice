package string;

import java.util.*;

public class StringSolutions {

    public static void main(String[] args) {

        // reverse words in a string
        // https://www.programcreek.com/2014/05/leetcode-reverse-words-in-a-string-ii-java/
        System.out.println("reverseWords(\"the sky is blue\")" + reverseWords("the sky is blue"));
        System.out.println("are isomorphic : " + areIsomorphic("ab","aa"));
    }

    /**
     * Reverse given input string
     * For example,
     * Given s = "the sky is blue",
     * return "blue is sky the".
     *
     * @param input
     * @return
     */
    private static String reverseWords(String input) {
        if (null == input || input.isEmpty()) {
            return null;
        }

        String[] words = input.split(" ");
        StringBuilder output = new StringBuilder();

        for (int i = words.length - 1; i >= 0; i--) {
            output.append(words[i]);
            if (i > 0) {
                output.append(" ");
            }
        }

        return output.toString();
    }

    private static boolean areIsomorphic(String s, String t) {
        if (null == s || null == t) {
            return false;
        }
        if (s.length() != t.length()) {
            return false;
        }

        final int SIZE = 256;
        boolean[] visited = new boolean[SIZE]; // to check visited characters in t
        int[] mapping = new int[SIZE];
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
