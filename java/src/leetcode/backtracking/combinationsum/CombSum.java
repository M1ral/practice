package leetcode.backtracking.combinationsum;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// https://leetcode.com/problems/combination-sum/
public class CombSum {

    public static void main(String[] args) {
        System.out.println("combinationSum({2,3,6,7}, 7) = " +
                combinationSum(new int[]{2, 3, 6, 7}, 7));
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (null == candidates || candidates.length == 0) {
            return Collections.emptyList();
        }

        List<List<Integer>> lists = new ArrayList<>();
        backtrack(lists, new ArrayList<Integer>(), candidates, target, 0);
        return lists;
    }

    private static void backtrack(List<List<Integer>> lists, List<Integer> list,
                           int[] candidates, int target, int start) {
        if (target < 0) {
            return;
        } else if (target == 0) { // when target is found
            lists.add(new ArrayList(list));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            // choose
            list.add(candidates[i]);
            // explore
            backtrack(lists, list, candidates, target - candidates[i], i);
            // unchoose
            list.remove(list.size() - 1);
        }
    }
}
