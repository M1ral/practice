package leetcode.backtracking.combinationsum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombSumII {

    public static void main(String[] args) {
        System.out.println("combinationSum2(new int[]{10,1,2,7,6,1,5}, 8) = " +
                combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> lists = new ArrayList();
        if (candidates == null || candidates.length == 0) {
            return lists;
        }
        Arrays.sort(candidates); // important
        backtrack(candidates, lists, new ArrayList<Integer>(), target, 0);
        return lists;
    }

    public static void backtrack(int[] nums, List<List<Integer>> lists, List<Integer> temp, int remain, int start) {
        if (remain < 0) {
            return;
        } else if (remain == 0) {
            lists.add(new ArrayList(temp));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) continue;
            // choose
            temp.add(nums[i]);
            // explore
            backtrack(nums, lists, temp, remain - nums[i], i + 1); // i+1 - because same element cannot be used again
            // un-choose
            temp.remove(temp.size() - 1);
        }
    }
}
