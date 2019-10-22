package leetcode.array;

import java.util.*;

public class ThreeSum {

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(hasThreeSum(new int[]{-1, 0, 1, 2, -1, -4}).toArray()));
    }

    public static List<List<Integer>> hasThreeSum(int[] nums) {
        if (null == nums || nums.length == 0) {
            return Collections.emptyList();
        }

        // sort array
        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int j = i+1, k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    set.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++; k--;
                } else if (sum < 0) {
                    j++;
                } else if (sum > 0) {
                    k--;
                }
            }
        }

        return new ArrayList<>(set);
    }
}
