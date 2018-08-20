package string;

import java.util.*;

public class StringSolutions {

    public static void main(String[] args) {

        // reverse words in a string
        // https://www.programcreek.com/2014/05/leetcode-reverse-words-in-a-string-ii-java/
        System.out.println("reverseWords(\"the sky is blue\")" + reverseWords("the sky is blue"));
        System.out.println("reverseWords(\"the sky is blue\")" + reverseWords(" 1"));
        System.out.println("are isomorphic : " + areIsomorphic("ab","aa"));
        System.out.println("is palindrome : " + isPalindrome("0P"));
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
    public static String reverseWords(String input) {
        if (null == input || input.isEmpty()) {
            return null;
        }

        String[] words = input.split(" ");
        StringBuilder output = new StringBuilder();

        for (int i = words.length - 1; i >= 0; i--) {
            String word = words[i].trim();
            if (word.isEmpty()) {
                continue;
            }

            output.append(word);

            if (i > 0) {
                output.append(" ");
            }
        }

        String o = output.toString().trim();
        return output.toString().trim();
    }

    public static boolean areIsomorphic(String s, String t) {
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

    public static boolean isPalindrome(String s) {
        if (null == s || s.isEmpty()) {
            return true;
        }

        int i = 0;
        int j = s.length() - 1;

        while (i < j) {
            // ignore non-alphabet characters
            char si = Character.toLowerCase(s.charAt(i));
            if (!(Character.isDigit(si) || Character.isLetter(si))) {
                i++;
                continue;
            }

            char sj = Character.toLowerCase(s.charAt(j));
            if (!(Character.isDigit(sj) || Character.isLetter(sj))) {
                j--;
                continue;
            }

            if (si != sj) {
                return false;
            }

            i++;
            j--;
        }

        return true;
    }
}
