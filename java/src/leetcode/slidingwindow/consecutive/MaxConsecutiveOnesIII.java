package leetcode.slidingwindow.consecutive;

public class MaxConsecutiveOnesIII {

    public static void main(String[] args) {
        System.out.println("longestOnes({1,1,1,0,0,0,1,1,1,1,0}, 2) = " +
                longestOnes(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2));
    }

    // https://leetcode.com/problems/max-consecutive-ones-iii/
    public static int longestOnes(int[] A, int k) {
        if (null == A || A.length == 0) {
            return 0;
        }

        int start = 0, max = 0, zeroCount = 0;

        for (int end = 0; end < A.length; end++) {
            if (A[end] == 0) {
                zeroCount++;
            }

            // drop the front zero when zeroCount > k
            if (zeroCount > k) {
                if (A[start] == 0) {
                    zeroCount--;
                }
                start++;
            }

            // at this point, sequence is valid
            max = Math.max(max, end - start + 1);
        }

        return max;
    }
}
