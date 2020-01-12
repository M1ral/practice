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
        for (int currentAmt = 1; currentAmt <= n; currentAmt++) {
            int minCoins = Integer.MAX_VALUE;

            // Try removing each coin from the
            // total and see which requires
            // the fewest additional coins
            for (int coin : coins) {
                if (currentAmt >= coin && dp[currentAmt - coin] >= 0) {
                    minCoins = Math.min(minCoins, dp[currentAmt - coin]);
                }
            }

            dp[currentAmt] = minCoins == Integer.MAX_VALUE
                    ? -1
                    : 1 + minCoins;
        }

        return dp[n];
    }
}
