package leetcode.array.leftrightpointers;

import java.util.Arrays;

// https://leetcode.com/problems/product-of-array-except-self/submissions/
public class ProructExceptSelf {

    public static void main(String[] args) {
        System.out.println("productExceptSelf({1,2,3,4}) = " +
                Arrays.toString(productExceptSelf(new int[]{1, 2, 3, 4})));
        System.out.println("productExceptSelf({0, 1}) = " +
                Arrays.toString(productExceptSelf(new int[]{0, 1})));
        System.out.println("productExceptSelf({1, 0}) = " +
                Arrays.toString(productExceptSelf(new int[]{1, 0})));
        System.out.println("productExceptSelf({0, 0}) = " +
                Arrays.toString(productExceptSelf(new int[]{0, 0})));
    }

    public static int[] productExceptSelf(int[] nums) {
        if (null == nums || nums.length == 0) {
            return new int[]{};
        }

        int n = nums.length, left = 1, right = 1;
        int[] result = new int[n];

        // product of left to current index
        for (int i = 0; i < n; i++) {
            result[i] = left;
            left *= nums[i];
        }

        // product of right to current index
        for (int i = n-1; i >= 0; i--) {
            result[i] *= right; // multiply right
            right *= nums[i];
        }

        return result;
    }
}
