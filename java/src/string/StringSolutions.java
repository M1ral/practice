package string;

import java.util.*;

public class StringSolutions {

    public static void main(String[] args) {

        // reverse words in a string
        // https://www.programcreek.com/2014/05/leetcode-reverse-words-in-a-string-ii-java/
        System.out.println("reverseWords(\"the sky is blue\")" + reverseWords("the sky is blue"));
        System.out.println("reverseWords(\"the sky is blue\")" + reverseWords(" 1"));
        System.out.println("are isomorphic : " + areIsomorphic("ab", "aa"));
        System.out.println("is palindrome : " + isPalindrome("0P"));
        System.out.println("isValid(\"({})\") : " + isValidParenthesis("({})"));
        System.out.println("isValid(\"({})\") : " + isValidParenthesis("({}]"));
        System.out.println("lengthOfLongestSubstring(\"abcc\") = " + lengthOfLongestSubstring("abcc"));
        System.out.println("longestCommonPrefix(new String[]{\"leet\", \"leetcode\", \"lee\"}) = " +
                longestCommonPrefix(new String[]{"leet", "leetcode", "le", "length", "long", "legal"}));
        System.out.println("strIndexOf(\"miral\", \"ir\") = " + strIndexOf("miral", "ir"));
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

    /**
     * Check if given strings are isomorphic
     *
     * @param s
     * @param t
     * @return boolean
     */
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

    /**
     * Check if given string is palindrome
     *
     * @param s
     * @return boolean
     */
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

    /**
     * Check if given string has valid parenthesis
     *
     * @param s
     * @return boolean
     */
    public static boolean isValidParenthesis(String s) {
        if (null == s || s.isEmpty()) {
            return true;
        }

        String openBrackets = "([{";
        Stack<Character> stack = new Stack();
        char[] cArr = s.toCharArray();

        for (char c : cArr) {
            if (openBrackets.indexOf(c) > -1) {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                if (c == ')') {
                    if (stack.pop() != '(') return false;
                } else if (c == '}') {
                    if (stack.pop() != '{') return false;
                } else if (c == ']') {
                    if (stack.pop() != '[') return false;
                }
            }
        }

        return stack.isEmpty();
    }

    /**
     * Return the length of the longest substring that has non repeating characters
     *
     * @param s
     * @return int
     */
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int result = 0;
        int k = 0;
        HashSet<Character> set = new HashSet<Character>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!set.contains(c)) {
                set.add(c);
                result = Math.max(result, set.size());
            } else {
                // TODO - this works but don't exactly understand how
                while (k < i) {
                    if (s.charAt(k) == c) {
                        k++;
                        break;
                    } else {
                        set.remove(s.charAt(k));
                        k++;
                    }
                }
            }
        }

        return result;
    }

    /**
     * Returns the largest common prefix among given strings
     *
     * @param strs
     * @return String
     */
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }

        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {

            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        return prefix;
    }

    /**
     * Returns index of needle from given haystack
     * Works similar to indexOf(str) in java
     *
     * @param haystack
     * @param needle
     * @return
     */
    public static int strIndexOf(String haystack, String needle) {
        if ((null == haystack || haystack.isEmpty()) &&
                (null == needle || needle.isEmpty())) {
            return 0;
        }
        if (null == haystack || haystack.isEmpty()) {
            return -1;
        }
        if (null == needle || needle.isEmpty()) {
            return 0;
        }
        if (needle.length() > haystack.length()) {
            return -1;
        }

        int needleLength = needle.length();

        for (int i = 0; i < haystack.length(); i++) {
            if (i + needle.length() > haystack.length()) {
                return -1;
            }

            if (haystack.charAt(i) == needle.charAt(0)) {
                int temp = needleLength;
                int nIndex = 0;
                int hIndex = i;

                while (temp != 0) {
                    if (haystack.charAt(hIndex) != needle.charAt(nIndex)) {
                        break;
                    }
                    hIndex++;
                    nIndex++;
                    temp--;
                }
                if (temp == 0) { // complete needle was found
                    return i;
                }
            }
        }

        return -1;
    }

    /**
     * Print count and say - program creek
     * 1 is read off as "one 1" or 11.
     * 11 is read off as "two 1s" or 21.
     * 21 is read off as "one 2, then one 1" or 1211.
     *
     * @param n
     * @return
     */
    public String countAndSay(int n) {
        if (n <= 0)
            return null;

        String result = "1";
        int i = 1;

        while (i < n) {
            StringBuilder sb = new StringBuilder();
            int count = 1;
            for (int j = 1; j < result.length(); j++) {
                if (result.charAt(j) == result.charAt(j - 1)) {
                    count++;
                } else {
                    sb.append(count);
                    sb.append(result.charAt(j - 1));
                    count = 1;
                }
            }

            sb.append(count);
            sb.append(result.charAt(result.length() - 1));
            result = sb.toString();
            i++;
        }

        return result;
    }
}
