package leetcode.dp;

import leetcode.matrix.MatrixUtils;

public class DistinctSubsequence {

    public static void main(String[] args) {
        System.out.println("numDistinct(\"rabbbit\", \"rabbit\") = " + numDistinct("rabbbit", "rabbit"));
        System.out.println("numDistinctDP(\"rabbbit\", \"rabbit\") = " + numDistinctDP("rabbbit", "rabbit"));
    }

    public static int numDistinct(String s, String t) {
        int n = s.length(), m = t.length();
        int[] dp = new int[m + 1];
        dp[0] = 1;
        for (int j = 1; j <= n; j++) {
            for (int i = m; i >= 1; i--) {
                dp[i] += s.charAt(j - 1) == t.charAt(i - 1) ? dp[i - 1] : 0;
            }
        }
        return dp[m];
    }

    public static int numDistinctDP(String s, String t) {
        int dp[][] = new int[s.length()+1][t.length()+1]; //dp[i][j]: number of the sequences for i long s and j long t
        for (int i = 0; i < s.length(); i++)
            dp[i][0] = 1;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                if (s.charAt(i-1) == t.charAt(j-1))
                    dp[i][j] = dp[i-1][j] + dp[i-1][j-1];
                else
                    dp[i][j] = dp[i-1][j];
            }
            MatrixUtils.print2D(dp);
            System.out.println("\n");
        }
        return dp[s.length()][t.length()];
    }
}
