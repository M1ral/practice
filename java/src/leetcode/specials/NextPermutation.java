package leetcode.specials;

import java.util.Arrays;

public class NextPermutation {

    public static void main(String[] args) {

        int[] nums = new int[]{1, 2, 3, 4, 1};
        nextPermutation(nums);
        System.out.println("next permutation: " + Arrays.toString(nums));
    }

    public static void nextPermutation(int[] nums) {
        int pivot;
        for (pivot = nums.length - 1; pivot > 0; pivot--) {
            if (nums[pivot] > nums[pivot - 1]) break;
        }
        if (pivot != 0) {
            swap(nums, pivot - 1);
        }
        inverse(nums, pivot);
    }

    private static void swap(int[] nums, int piv) {
        int j = nums.length - 1;
        while (j > piv) {
            if (nums[j--] > nums[piv]) {
                int tmp = nums[piv];
                nums[piv] = nums[++j];
                nums[j] = tmp;
                break;
            }
        }
    }

    private static void inverse(int[] nums, int piv) {
        int i = piv, j = nums.length - 1;
        while (i < j) {
            int tmp = nums[i];
            nums[i++] = nums[j];
            nums[j--] = tmp;
        }
    }
}
