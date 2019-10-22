package leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    // https://www.youtube.com/watch?v=78t_yHuGg-0
    // pick the letter, explore what comes after that and then un-pick
    // choose
    // explore
    // un-choose

    public static void main(String[] args) {
        // String
        System.out.println("====== STRING ======");
        permute("abc");
        System.out.println("====== DUP STRING (now working) ======");
        permute("rrp"); // doesn't handle duplicate chars

        // Integer
        System.out.println("====== ARRAY ======");
        permute(new int[]{1,2,3});
        permute(new int[]{1,2,2}); // won't work because leetcoce.array has duplicate elements
    }

    public static void permute(String s) {
        if (null == s || s.isEmpty()) {
            return;
        }
        backtrack(s, "");
    }

    public static void backtrack(String s, String chosen) {
        if (null == s || s.isEmpty()) {
            System.out.println("chosen = " + chosen);
            return;
        }

        for (int i = 0; i < s.length(); i++) {
            // choose
            char ch = s.charAt(i);
            chosen += ch;

            // explore
            backtrack(s.substring(0, i) + s.substring(i+1), chosen);

            // un-choose
            chosen = chosen.substring(0, chosen.length() - 1);
        }
    }

    public static void permute(int[] arr) {
        backtrack(arr, new ArrayList<>());
    }

    public static void backtrack(int[] arr, List<Integer> chosen) {
        if (chosen.size() == arr.length) {
            System.out.println("chosen = " + chosen);
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            // skip already selected element // because we are not sending modified source to backtrack
            if (chosen.contains(arr[i])) continue;

            // choose
            chosen.add(arr[i]);

            // explore
            backtrack(arr, chosen);

            // un-choose
            chosen.remove(chosen.size() - 1);
        }
    }
}
