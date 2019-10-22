package leetcode.array;

public class MaxMinSumSubArray {
    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-1,2,3,-5,7,8,-2,10}));
        System.out.println(minSubArray(new int[]{-1,2,3,-5,7,8,-2,-6,10}));
    }

    /**
     * Find the max sum in a sequence of the leetcoce.array
     *
     * @param A
     * @return int max sum
     */
    public static int maxSubArray(int[] A) {
        int sum = 0, max = Integer.MIN_VALUE;

        for (int i : A) {
            // ignore the sum of (n-1) if n is greater than that sum
            sum = Math.max(sum + i, i);
            max = Math.max(max, sum);
        }

        return max;
    }

    /**
     * Find the min sum in a sequence of the leetcoce.array
     *
     * @param A
     * @return int min sum
     */
    public static int minSubArray(int[] A) {
        int sum = 0, min = Integer.MAX_VALUE;

        for (int i : A) {
            // ignore the sum of (n-1) if n is greater than that sum
            sum = Math.min(sum + i, i);
            min = Math.min(min, sum);
        }

        return min;
    }
}
