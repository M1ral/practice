package array;

public class MaxSumSubArray {
    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-1,2,3,-5,7,8,-2,10}));
    }

    public static int maxSubArray(int[] A) {
        int newsum = A[0];
        int max = A[0];

        for (int i = 1; i < A.length; i++) {
            newsum = Math.max(newsum + A[i], A[i]); // ignore the sum of (n-1) if n is greater than that sum
            max = Math.max(max, newsum);
        }

        return max;
    }
}
