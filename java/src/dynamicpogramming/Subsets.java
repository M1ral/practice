package dynamicpogramming;

import java.util.*;

public class Subsets {

    public static void main(String[] args) {
        // subsets 1 - iterative
        System.out.println("subsetsIter(new int[]{1,2,3}) = " + subsetsIter(new Integer[]{1, 2, 3}));
        System.out.println("subsetsIter(new int[]{1,2,3}) = " + subsetsIter(new String[]{"a", "b", "c"}));

        // subsets 1 - recursive
        System.out.println("subsetsRec(new int[]{1,2,3}) = " + subsetsRec(new int[]{1, 2, 3}));

        // subsets 2 - iterative
        System.out.println("subsets2Iter(new int[]{1,2,2}) = " + subsets2Iter(new Integer[]{1, 2, 2}));
        System.out.println("subsets2Iter(new int[]{1,2,2}) = " + subsets2Iter(new String[]{"a", "b", "b"}));

        // subsets 2 - recursive

    }

    public static <T> List<List<T>> subsetsIter(T[] elements) {
        List<List<T>> result = new ArrayList();
        if (elements == null || elements.length == 0) {
            return result;
        }

        result.add(new ArrayList());

        for (int i = 0; i < elements.length; i++) {
            T current = elements[i];
            int length = result.size();

            for (int j = 0; j < length; j++) {
                List<T> subset = new ArrayList<>(result.get(j));
                subset.add(current);
                result.add(subset);
            }
        }
        return result;
    }

    /**
     * Recursive - backtracking
     *
     * @param nums
     * @return List
     */
    public static List<List<Integer>> subsetsRec(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), nums, 0);
        return list;
    }

    private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start) {
        list.add(new ArrayList<>(tempList));
        for (int i = start; i < nums.length; i++) {
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }

    /**
     * Print subsetsIter without duplicates
     *
     * @param elements
     * @return List
     */
    public static <T> List<List<T>> subsets2Iter(T[] elements) {
        if (elements == null || elements.length == 0) {
            return new ArrayList<>();
        }

        Set<List<T>> result = new HashSet<>();
        result.add(new ArrayList());

        for (int i = 0; i < elements.length; i++) {

            List<List<T>> list = new ArrayList<>(result);
            int length = list.size();

            for (int j = 0; j < length; j++) {
                List<T> temp = new ArrayList<T>(list.get(j));
                temp.add(elements[i]);
                result.add(temp);
            }
        }
        return new ArrayList<>(result);
    }

    /**
     * Substes2 - recursive - backtracking
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> subsets2Rec(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums); // sort the array
        backtrackSubsets2(list, new ArrayList<>(), nums, 0);
        return list;
    }

    private static void backtrackSubsets2(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start) {
        list.add(new ArrayList<>(tempList));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) continue; // skip duplicates
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }
}
