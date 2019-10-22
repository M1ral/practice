package leetcode.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordBreak {

    public static void main(String[] args) {
        System.out.println("wordBreak(\"applepen\", ) = " +
                wordBreak("applepenapple", new ArrayList(Arrays.asList("apple", "pen", "len"))));
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                String check = s.substring(j, i);
                if (dp[j] && wordDict.contains(check)) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
