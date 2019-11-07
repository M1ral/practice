package leetcode.dp;

public class MinimumEditDistance {

    public static void main(String[] args) {
        System.out.println("minEditDistance(\"hosrse\", \"ors\") = " + minEditDistance("hosrse", "ors"));
    }

    // best explanation: https://www.youtube.com/watch?v=b6AGUjqIPsA
    public static int minEditDistance(String word1, String word2) {
        if (null == word1 || null == word2) {
            return 0;
        }

        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                // first cell
                if (i == 0 && j == 0) {
                    dp[i][j] = 0;
                } else if (i == 0) { // first row
                    dp[i][j] = dp[i][j-1] + 1;
                } else if (j == 0) { // first column
                    dp[i][j] = dp[i-1][j] + 1;
                } else { // rest of the matrix
                    if (word1.charAt(i-1) == word2.charAt(j-1)) {
                        dp[i][j] = dp[i-1][j-1];
                    } else {
                        dp[i][j] = Math.min(dp[i][j-1] ,
                                Math.min(dp[i-1][j], dp[i-1][j-1])) + 1;
                    }
                }
            }
        }

        return dp[m][n];
    }
}
