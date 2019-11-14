package leetcode.dp.jumpstart;

public class CoinChange {

    public static void main(String[] args) {
        System.out.println("coinChange({1,2,5}, 11) = " + coinChange(new int[]{1, 2, 5}, 11));
        System.out.println("coinChange({1,6,10}, 12) = " + coinChange(new int[]{1, 6, 10}, 12));
    }

    public static int coinChange(int[] coins, int n) {
        if (null == coins || coins.length == 0 || n < 0) {
            return 0;
        }

        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;

            // Try removing each coin from the
            // total and see which requires
            // the fewest additional coins
            for (int coin : coins) {
                if (i - coin >= 0 && dp[i - coin] != -1) {
                    min = Math.min(min, dp[i - coin]);
                }
            }
            dp[i] = min == Integer.MAX_VALUE ? -1 : min + 1;
        }

        return dp[n];
    }
}
