package leetcode.sorting;

import java.util.Arrays;

// https://leetcode.com/problems/sort-colors/
public class SortColors {

    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};
        sortColors(nums);
        System.out.println("nums = " + Arrays.toString(nums));
    }

    public static void sortColors(int[] nums) {
        if (null == nums || nums.length == 0) {
            return;
        }

        int i = 0, start = 0, end = nums.length - 1;
        while (i <= end) {
            if (nums[i] == 0) {
                swap(nums, i++, start++);
            } else if (nums[i] == 2) {
                swap(nums, i, end--);
            } else {
                i++;
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
