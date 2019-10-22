package leetcode.array;

import java.util.Arrays;

public class ThreeSumClosest {
    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[]{1, 4, 7, -4, 9, 10, 101}, 3));
    }

    public static int threeSumClosest(int[] nums, int target) {
        if (null == nums || nums.length < 3) {
            return 0;
        }

        // Sort array
        Arrays.sort(nums);
        int result = 0, diff = Integer.MAX_VALUE;

        for (int i=0; i < nums.length; i++) {
            int start = i+1, end = nums.length - 1;
            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                if (sum < target) {
                    start++;
                } else {
                    end--;
                }

                int currentDiff = Math.abs(sum - target);
                if (currentDiff < diff) {
                    result = sum;
                    diff = currentDiff;
                }
            }
        }

        return result;
    }
}
