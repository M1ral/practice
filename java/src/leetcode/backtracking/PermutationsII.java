package leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsII {

    // https://www.youtube.com/watch?v=78t_yHuGg-0
    // pick the letter, explore what comes after that and then un-pick
    // choose
    // explore
    // unchoose

    public static void main(String[] args) {
        // Handle duplicates
        System.out.println("====== DUP ARRAY ======");
        permuteDup(new int[]{1,2,2});
    }

    public static void permuteDup(int[] arr) {
        Arrays.sort(arr);
        backtrack(arr, new ArrayList<>(), new boolean[arr.length]);
    }

    public static void backtrack(int[] arr, List<Integer> chosen, boolean[] used) {
        if (chosen.size() == arr.length) {
            System.out.println("chosen = " + chosen);
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            // skip already selected element //TODO - understand this
            if (used[i] || (i > 0 && arr[i] == arr[i-1] && !used[i-1])) continue;

            // choose
            used[i] = true;
            chosen.add(arr[i]);

            // explore
            backtrack(arr, chosen, used);

            // un-choose
            used[i] = false;
            chosen.remove(chosen.size() - 1);
        }
    }
}
