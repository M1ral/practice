package leetcoce.array;

public class BuyAndSellStock {

    public static void main(String[] args) {
        // Buy and Sell Stocks I
        System.out.println("Max profit (buy and sell stock once) : " +
                maxProfitByBuySellOnce(new int[]{12, 15, 10, 14, 16, 18, 9, 25, 23, 15, 10}));

        // Buy and Sell Stocks II
        System.out.println("maxProfitBuySellMultipleTimes({3,0,0,5,0,3,1,4}) = " +
                maxProfitBuySellMultipleTimes(new int[]{3, 0, 0, 5, 0, 3, 1, 4}));

        // Buy and Sell Stocks III
        System.out.println("Max profit (buy and sell stock twice) : " +
                maxProfitBuySellTwice(new int[]{2, 4, 6, 10, 20, 15, 13, 12, 30, 35, 40}));
    }

    /**
     * Return max profit if we were to exercise buy and sell of stock only once
     *
     * @param stockPrices
     * @return int maximum profit
     */
    public static int maxProfitByBuySellOnce(int[] stockPrices) {
        if (null == stockPrices || stockPrices.length < 2) {
            return 0;
        }

        int minPriceSoFar = stockPrices[0]; // keep track of min price during each iteration
        int currentProfit = 0; // calculate currentProfit during each iteration
        int maxProfit = Integer.MIN_VALUE;

        for (int stockPrice : stockPrices) {
            minPriceSoFar = Math.min(minPriceSoFar, stockPrice); // keep track of minSoFar in the iteration
            currentProfit = stockPrice - minPriceSoFar; // calculate currentProfit based on minSoFar and current stockPrice
            maxProfit = Math.max(currentProfit, maxProfit);
        }

        return maxProfit;
    }

    /**
     * Return max profit if we were to exercise buy and sell stocks multiple times.
     *
     * @param prices
     * @return int max profit
     */
    public static int maxProfitBuySellMultipleTimes(int[] prices) {
        if (null == prices || prices.length == 0) {
            return 0;
        }

        int sum = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - prices[i - 1] > 0) {
                sum += (prices[i] - prices[i - 1]);
            }
        }
        return sum;
    }

    /**
     * Return max profit if we were to exercise buy and sell of stock twice
     * <p>
     * A - [2   4   6   10  20  15  13   12   30  35  40]
     * F - [0   2   4   8   18  18  18  *18*  28  33  38] // calculate the current profit with minSoFar
     * B - [38  36  34  30  28  28  28  *28*  10  5    0] // calculate the current profit with maxSoFar from back
     * T - [38  38  38  38  46  46  46  *46*  38  38  38]
     *
     * @param prices
     * @return int maximum profit
     */
    public static int maxProfitBuySellTwice(int[] prices) {
        if (null == prices || prices.length == 0) {
            return 0;
        }

        int min = prices[0], max = prices[prices.length - 1];
        int profit = Integer.MIN_VALUE;
        int[] F = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            profit = Math.max(profit, prices[i] - min);
            F[i] = profit;
        }

        for (int i = prices.length - 1; i >= 0; i--) {
            max = Math.max(max, prices[i]);
            profit = Math.max(profit, (max - prices[i] + F[i]));
        }

        return profit;
    }
}
