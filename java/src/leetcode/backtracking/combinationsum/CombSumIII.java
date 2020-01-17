package leetcode.backtracking.combinationsum;

import java.util.*;

// https://leetcode.com/problems/combination-sum-iii/
public class CombSumIII {
    public static void main(String[] args) {
        System.out.println("combinationSum3(3, 7) = " + combinationSum3(3, 7));
    }

    public static List<List<Integer>> combinationSum3(int k, int n) {
        if (k <= 0) {
            return Collections.emptyList();
        }

        Set<List<Integer>> lists = new HashSet<>();
        backtrack(lists, new HashSet<Integer>(), n, 1, k);
        return new ArrayList(lists);
    }

    private static void backtrack(Set<List<Integer>> lists,
                                  Set<Integer> list, int n, int start, int k) {
        if (n < 0) {
            return;
        } else if (n == 0 && list.size() == k) {
            lists.add(new ArrayList(list));
            return;
        }

        for (int i = start; i <= 9; i++) {
            if (list.contains(i)) {
                continue;
            }
            // choose
            list.add(i);
            // explore
            backtrack(lists, list, n - i, start + 1, k);
            // un-choose
            list.remove(i);
        }
    }
}
