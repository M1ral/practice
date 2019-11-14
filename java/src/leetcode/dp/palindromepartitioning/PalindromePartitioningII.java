package leetcode.dp.palindromepartitioning;

public class PalindromePartitioningII {

    public static void main(String[] args) {
        System.out.println("minCut(\"abcbm\") = " + minCut("abcbm"));
    }

    public static int minCut(String s) {
        if (null == s || s.isEmpty()) {
            return 0;
        }

        int[] dp = new int[s.length() + 1];
        for (int i = 0; i < s.length(); i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        dp[s.length()] = -1;

        for (int i = s.length() - 1; i >= 0; i--) {
            // odd length palindrome
            for (int start = i, end = i; start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end); start--, end++) {
                dp[start] = Math.min(dp[start], 1 + dp[end + 1]);
            }
            // even length palindrome
            for (int start = i, end = i+1; start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end); start--, end++) {
                dp[start] = Math.min(dp[start], 1 + dp[end + 1]);
            }
        }

        return dp[0];
    }

    /* public static int minCut(String s) {
        if (s.length() == 0) return 0;
        int[] c = new int[s.length() + 1];
        for (int i = 0; i < s.length(); i++) c[i] = Integer.MAX_VALUE;
        c[s.length()] = -1;
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int a = i, b = i; a >= 0 && b < s.length() && s.charAt(a) == s.charAt(b); a--, b++)
                c[a] = Math.min(c[a], 1 + c[b + 1]);
            for (int a = i, b = i + 1; a >= 0 && b < s.length() && s.charAt(a) == s.charAt(b); a--, b++)
                c[a] = Math.min(c[a], 1 + c[b + 1]);
        }
        return c[0];
    }*/
}
