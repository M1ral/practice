package leetcode.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permute {

    public static void main(String[] args) {
        System.out.println("permute(new int[]{1,2,3}) = " + permute(new int[]{1, 2, 3}));
        System.out.println("permuteUnique(new int[]{1,2,2}) = " + permuteUnique(new int[]{1, 2, 2}));
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), nums);
        return list;
    }

    private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums){
        if(tempList.size() == nums.length){
            list.add(new ArrayList<>(tempList));
        } else{
            for(int i = 0; i < nums.length; i++){
                if(tempList.contains(nums[i])) continue; // element already exists, skip
                tempList.add(nums[i]);
                backtrack(list, tempList, nums);
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        if (null == nums || nums.length == 0) {
            return new ArrayList();
        }
        Set<List<Integer>> set = new HashSet();
        // to mark an item visited, will use boolean leetcoce.array
        boolean[] visited = new boolean[nums.length];
        backtrack(set, new ArrayList(), nums, visited);
        return new ArrayList(set);
    }

    public static void backtrack(Set<List<Integer>> set, List<Integer> temp, int[] nums, boolean[] visited) {
        if (temp.size() == nums.length) {
            set.add(new ArrayList(temp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                temp.add(nums[i]);
                backtrack(set, temp, nums, visited);
                temp.remove(temp.size() - 1);
                visited[i] = false;
            }
        }
    }
}
