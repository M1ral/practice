package leetcode.dp.lclis;

public class LongestCommonSubsequence {

    public static void main(String[] args) {
        System.out.println("lengthOfLongestSubsequence(\"abcd\", \"aebd\") = " +
                lengthOfLongestSubsequence("abcd", "aebd"));
    }

    public static int lengthOfLongestSubsequence(String a, String b) {
        if (null == a || null == b ||
                a.isEmpty() || b.isEmpty()) {
            return 0;
        }
        int m = a.length(), n = b.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (a.charAt(i-1) == b.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return dp[m][n];
    }
}
