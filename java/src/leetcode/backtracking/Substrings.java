package leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Substrings {

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(getSubstrings("abcde").toArray()));
    }

    public static List<List<String>> getSubstrings(String s) {
        if (null == s || s.isEmpty()) {
            return Collections.emptyList();
        }

        List<List<String>> result = new ArrayList<>();
        backtrack(s, new ArrayList<String>(), result);

        System.out.println("Result size: " + result.size());
        return result;
    }

    public static void backtrack(String s, List<String> list, List<List<String>> result) {
        if (s.length() == 0) {
            result.add(new ArrayList<>(list));
            return;
        }

        int n  = s.length();
        for (int i = 0; i < n; i++) {
            // choose
            list.add(s.substring(0, i+1));
            // explore
            backtrack(s.substring(i+1), list, result);
            // unchoose
            list.remove(list.size() - 1);
        }
    }
}
