package leetcode.dp.regex;

public class WildcardMatching {

    // https://leetcode.com/problems/wildcard-matching/
    public static void main(String[] args) {
        System.out.println("isMatch(\"acdcb\", \"a?c*b\") = " + isMatch("acdcb", "a*c?b"));
        System.out.println("isMatch(\"abczy\", \"a?c*\") = " + isMatch("abczy", "a?c*"));
        System.out.println("isMatch(\"abczy\", \"a?cd*\") = " + isMatch("abczy", "a?cd*"));
        System.out.println("isMatch(\"xaylmz\", \"x?y*z*\") = " + isMatch("xaylmz", "x?y*z"));
    }

    // https://www.youtube.com/watch?v=3ZDZ-N0EPV0
    public static boolean isMatch(String s, String p) {
        if (null == s || null == p) {
            return true;
        }

        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0] = true; // empty string and pattern

        // empty source text
        for (int j = 1; j <= n; j++) {
            if (p.charAt(j-1) == '*') {
                dp[0][j] = dp[0][j-1];
            }
        }

        for (int i = 1; i <= m; i++) {
            char sChar = s.charAt(i-1);

            for (int j = 1; j <= n; j++) {
                char pChar = p.charAt(j-1);

                if (pChar == '?' || sChar == pChar) {
                    dp[i][j] = dp[i-1][j-1];
                } else if (pChar == '*') {
                    dp[i][j] = dp[i][j-1] || dp[i-1][j];
                }
            }
        }

        return dp[m][n];
    }
}
