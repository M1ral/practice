package leetcode.dp.decodeways;

// https://leetcode.com/problems/decode-ways/
public class DecodeWaysII {
    public static void main(String[] args) {
        System.out.println("numDecodings(\"226\") = " + numDecodings("226"));
        System.out.println("numDecodingsDP(\"226\") = " + numDecodingsDP("226"));
    }

    public static int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;

        for (int i = 2; i <= n; i++) {
            int first = Integer.valueOf(s.substring(i - 1, i));
            int second = Integer.valueOf(s.substring(i - 2, i));
            if (first >= 1 && first <= 9) {
                dp[i] += dp[i - 1];
            }
            if (second >= 10 && second <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[n];
    }

    public static int numDecodingsDP(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') return 0;
        int n = s.length();
        int a = 1, b = 1;
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == '0') a = 0;
            if (s.charAt(i - 1) == '1' ||
                    (s.charAt(i - 1) == '2' && s.charAt(i) <= '6')) {
                int sum = a + b;
                b = a;
                a = sum;
            } else {
                b = a;
            }
        }
        return a;
    }
}
