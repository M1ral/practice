package leetcode.backtracking.subsets;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SubsetsII {

    // https://leetcode.com/problems/subsets/
    public static void main(String[] args) {
        System.out.println("========== DUPLICATE - BACKTRACK =========");
        subsetsDup(new int[]{1, 2, 2});
        System.out.println("========== DUPLICATE - ITERATIVE =========");
        subsetsIterDup(new int[]{1, 2, 2});
    }

    public static void subsetsDup(int[] nums) {
        backtrack(new ArrayList<>(), nums, 0);
    }

    private static void backtrack(List<Integer> chosen, int[] nums, int start) {
        System.out.println(new ArrayList<>(chosen));

        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i-1]) continue;
            // chose
            chosen.add(nums[i]);

            // explore
            backtrack(chosen, nums, i + 1);

            // un-choose
            chosen.remove(chosen.size() - 1);
        }
    }

    public static void subsetsIterDup(int[] arr) {
        if (null == arr || arr.length == 0) {
            return;
        }

        List<List<Integer>> lists = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>(); // to avoid duplicates
        List<Integer> empty = new ArrayList<>();

        lists.add(empty); // [] - empty set at the beginning
        set.add(empty);

        for (int n : arr) {
            int length = lists.size();
            for (int i = 0; i < length; i++) {
                List<Integer> subset = new ArrayList<>(lists.get(i));
                subset.add(n);
                if (!set.contains(subset)) {
                    lists.add(subset);
                    set.add(subset);
                }
            }
        }
        for (List<Integer> list : lists) {
            System.out.println("list = " + list);
        }
    }
}
