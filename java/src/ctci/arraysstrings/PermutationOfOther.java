package ctci.arraysstrings;

import java.util.Arrays;

public class PermutationOfOther {

    public static void main(String[] args) {
        System.out.println("isPermutation(\"dog\", \"god\") = " + isPermutation("dog", "god"));
        System.out.println("isPermutation(\"cat\", \"act\") = " + isPermutation("cat", "act"));
        System.out.println("isPermutation(\"abc\", \"def\") = " + isPermutation("abc", "def"));
    }

    public static boolean isPermutation(String input, String other) {
        if (null == input || input.isEmpty() || null == other || other.isEmpty()) {
            return false;
        }
        if (input.length() != other.length()) {
            return false;
        }

        return sort(input).equals(sort(other));
    }

    private static String sort(String s) {
        char[] content = s.toCharArray();
        Arrays.sort(content);
        return new String(content);
    }
}
