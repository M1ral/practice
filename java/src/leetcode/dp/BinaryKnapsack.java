package leetcode.dp;

import java.util.Arrays;

public class BinaryKnapsack {

    public static void main(String[] args) {
        System.out.println("findMaxProfitForWeight({3,4,6,5}, {2,3,1,4}, 8) = " +
                findMaxProfitForWeight(new int[]{3, 4, 6, 5}, new int[]{2, 3, 1, 4}, 8));
    }

    // explanation https://www.youtube.com/watch?v=PfkBS9qIMRE
    public static int findMaxProfitForWeight(int[] weights, int[] profits, int weight) {
        if (null == weights || weights.length == 0 ||
                null == profits || profits.length == 0 || weight < 1) {
            return 0;
        }
        int m = weights.length;
        Item[] items = getItems(weights, profits);

        int[][] dp = new int[m + 1][weight+1];
        for (int i = 1; i <= m; i++) {
            Item currentItem = items[i-1];

            for (int j = 1; j <= weight; j++) {
                int currentProfit = currentItem.profit;
                int previousProfit = dp[i-1][j];
                int remainingWeight = j - currentItem.weight;

                if (items[i-1].weight > j) {
                    dp[i][j] = previousProfit;
                } else {
                    dp[i][j] = Math.max(previousProfit, currentProfit + dp[i-1][remainingWeight]);
                }
            }
        }

        return dp[m][weight];
    }

    public static Item[] getItems(int[] weights, int[] profits) {
        if (null == weights || weights.length == 0 ||
                null == profits || profits.length == 0) {
            return new Item[]{};
        }

        Item[] ret = new Item[weights.length];
        for (int i = 0; i < weights.length; i++) {
            ret[i] = new Item(weights[i], profits[i]);
        }

        Arrays.sort(ret);
        return ret;
    }

    private static class Item implements Comparable<Item> {
        int weight;
        int profit;

        public Item(int weight, int profit) {
            this.weight = weight;
            this.profit = profit;
        }

        public int compareTo(Item other) {
            return this.weight - other.weight;
        }
    }
}
