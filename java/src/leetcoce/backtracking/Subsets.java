package leetcoce.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    // https://leetcode.com/problems/subsets/
    public static void main(String[] args) {
        System.out.println("========== BACKTRACK =========");
        subsets(new int[]{1, 2, 3});
        System.out.println("========== ITERATIVE =========");
        subsetsIter(new int[]{1, 2, 3});
    }

    public static void subsets(int[] nums) {
        backtrack(new ArrayList<>(), nums, 0);
    }

    private static void backtrack(List<Integer> chosen, int[] nums, int start) {
        System.out.println(new ArrayList<>(chosen));

        for (int i = start; i < nums.length; i++) {
            chosen.add(nums[i]);
            backtrack(chosen, nums, i + 1);
            chosen.remove(chosen.size() - 1);
        }
    }

    public static void subsetsIter(int[] arr) {
        if (null == arr || arr.length == 0) {
            return;
        }

        List<List<Integer>> lists = new ArrayList<>();
        lists.add(new ArrayList<>()); // [] - empty set at the beginning

        for (int n : arr) {
            int length = lists.size();
            for (int i = 0; i < length; i++) {
                List<Integer> subset = new ArrayList<>(lists.get(i));
                subset.add(n);
                lists.add(subset);
            }
        }
        for (List<Integer> list : lists) {
            System.out.println("list = " + list);
        }
    }
}
