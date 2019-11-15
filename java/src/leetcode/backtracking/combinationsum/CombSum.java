package leetcode.backtracking.combinationsum;

import java.util.ArrayList;
import java.util.List;

public class CombSum {

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> lists = new ArrayList();
        if (candidates == null || candidates.length == 0) {
            return lists;
        }
        backtrack(candidates, lists, new ArrayList<Integer>(), target, 0);
        return lists;
    }

    public static void backtrack(int[] nums, List<List<Integer>> lists, List<Integer> temp, int remain, int start) {
        if (remain < 0) {
            return;
        } else if (remain == 0) {
            lists.add(new ArrayList(temp));
            return;
        } else {
            for (int i = 0; i < nums.length; i++) {
                // choose
                temp.add(nums[i]);
                // explore
                backtrack(nums, lists, temp, remain - nums[i], i); // i - because same element can be used again
                // un-choose
                temp.remove(temp.size() - 1);
            }
        }
    }
}
