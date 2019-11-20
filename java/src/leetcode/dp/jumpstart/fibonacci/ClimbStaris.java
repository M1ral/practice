package leetcode.dp.jumpstart.fibonacci;

public class ClimbStaris {

    // https://leetcode.com/problems/climbing-stairs/description/
    public static void main(String[] args) {
        System.out.println("climbStairs(5) = " + climbStairs(5));
    }

    /**
     * You are climbing a stair case. It takes n steps to reach to the top.
     * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
     * Note: Given n will be a positive integer.
     * <p>
     * Input: 2
     * Output: 2
     * Explanation: There are two ways to climb to the top.
     * 1. 1 step + 1 step
     * 2. 2 steps
     * <p>
     * It is fibonacci series
     *
     * @param n
     * @return
     */
    public static int climbStairs(int n) {
        if (n <= 1) {
            return n;
        }

        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;

        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n - 1];
    }
}
