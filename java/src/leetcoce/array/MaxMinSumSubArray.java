package leetcoce.array;

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
        int sum = A[0];
        int max = A[0];

        for (int i = 1; i < A.length; i++) {
            sum = Math.max(sum + A[i], A[i]); // ignore the sum of (n-1) if n is greater than that sum
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
        int sum = A[0];
        int min = A[0];

        for (int i = 1; i < A.length; i++) {
            sum = Math.min(sum + A[i], A[i]); // ignore the sum of (n-1) if n is smaller than that sum
            min = Math.min(min, sum);
        }

        return min;
    }
}
