package leetcoce.dp;

public class WildcardMatching {

    public static void main(String[] args) {
        System.out.println("isMatch(\"acdcb\", \"a?c*b\") = " + isMatch("acdcb", "a*c?b"));
        System.out.println("isMatch(\"abczy\", \"a?c*\") = " + isMatch("abczy", "a?c*"));
        System.out.println("isMatch(\"abczy\", \"a?cd*\") = " + isMatch("abczy", "a?cd*"));
        System.out.println("isMatch(\"xaylmz\", \"x?y*z*\") = " + isMatch("xaylmz", "x?y*z"));
    }

    // https://www.youtube.com/watch?v=3ZDZ-N0EPV0
    public static boolean isMatch(String s, String p) {
        if (null == s || null == p) {
            return false;
        }

        int m = s.length(), n = p.length();
        char[] source = s.toCharArray(), pattern = p.toCharArray();

        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0] = true;

        // empty source text
        for (int j = 1; j <= n; j++) {
            if (pattern[j-1] == '*') {
                dp[0][j] = dp[0][j-1];
            }
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (source[i-1] == pattern[j-1] || pattern[j-1] == '?') {
                    dp[i][j] = dp[i-1][j-1];
                } else if (pattern[j-1] == '*') {
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
                }
            }
        }
        return dp[m][n];
    }
}
