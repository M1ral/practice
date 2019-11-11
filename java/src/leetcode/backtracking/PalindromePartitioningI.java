package leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PalindromePartitioningI {

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(getPalindromes("aab").toArray()));
    }

    public static List<List<String>> getPalindromes(String s) {
        if (null == s || s.isEmpty()) {
            return Collections.emptyList();
        }

        List<List<String>> result = new ArrayList<>();
        List<String> list = new ArrayList<>();

        // backtrack
        backtrack(s, list, result);
        return result;
    }

    private static void backtrack(String s, List<String> list, List<List<String>> result) {
        if (s.length() == 0) {
            result.add(new ArrayList<>(list));
            return;
        }

        int n  = s.length();
        for (int i = 0; i < n; i++) {
            if (isPalindrome(s, 0, i)) {
                // choose
                list.add(s.substring(0, i+1));
                // explore
                backtrack(s.substring(i+1), list, result);
                // unchoose
                list.remove(list.size() - 1);
            }
        }
    }

    private static boolean isPalindrome(String s, int l, int r) {
        if (null == s || s.isEmpty() || l > r) {
            return false;
        }
        while (l <= r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++; r--;
        }
        return true;
    }
}
