package leetcode.dp.jumpstart;

public class ArrayComb {

    public static void main(String[] args) {
        System.out.println(comb(new int[]{1, 2, 3, 4, 5}));
        System.out.println(combDP(new int[]{1, 2, 3, 4, 5}));
    }

    public static int comb(int[] arr) {
        return comb(arr, 0);
    }

    public static int comb(int[] arr, int i) {
        if (i == arr.length) return 1;
        int include = comb(arr, i + 1);
        int exclude = comb(arr, i + 1);

        return include + exclude;
    }

    public static int combDP(int[] arr) {
        int[] dp = new int[arr.length + 1];
        dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {
            dp[i] = dp[i-1] + dp[i-1];
        }

        return dp[arr.length];
    }
}
