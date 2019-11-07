package leetcode.dp;

public class Fibonacci {

    public static void main(String[] args) {
        System.out.println("bruteforce fib(7) = " + fib(7));
        System.out.println("fibDP(7) = " + fibdp(7));
        System.out.println("fib DP Rec(7) = " + fibdp(7, new int[8]));
    }

    public static int fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fib(n-1) + fib(n - 2);
    }

    public static int fibdp(int n) {
        int[] dp = new int[n+1];
        dp [1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }

    public static int fibdp(int n, int[] dp) {
        if (dp[n] == 0) {
            if (n == 0) return 0;
            if (n == 1) return 1;
            return fibdp(n-1, dp) + fibdp(n-2, dp);
        }
        return dp[n];
    }
}
