package leetcode.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class WordBreak {

    public static void main(String[] args) {
        System.out.println("wordBreak(\"applepen\", ) = " +
                wordBreak("applepenapple", new ArrayList(Arrays.asList("apple", "pen", "len"))));

        System.out.println("wordBreakII(\"catsanddog\", ) = " +
                wordBreakII("catsanddog", new ArrayList(Arrays.asList("cat", "cats", "sand", "and", "dog"))));
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

    public static List<String> wordBreakII(String word, List<String> dict) {
        if (null == word || word.isEmpty() ||
                null == dict || dict.isEmpty()) {
            return Collections.emptyList();
        }

        // dp array
        List<String>[] dp = new ArrayList[word.length() + 1];
        dp[0] = new ArrayList<>();

        for (int i = 1; i <= word.length(); i++) {
            for (int j = 0; j < i; j++) {
                // form a word and check if it is in dict
                String check = word.substring(j, i);
                if (null != dp[j] && dict.contains(check)) {
                    if (null == dp[i]) {
                        dp[i] = new ArrayList<>();
                    }
                    dp[i].add(check);
                }
            }
        }

        // if dictionary words cannot join to given word
        if (null == dp[word.length()]) {
            return Collections.emptyList();
        }

        List<String> result = new ArrayList<>();
        // start dfs from back
        dfs(dp, result, "", word.length());
        return result;
    }

    // perform dfs from the end of the dp array to form the result list
    public static void dfs(List<String>[] dp, List<String> result, String current, int i) {
        if (i == 0) {
            result.add(current.trim());
            return;
        }

        for (String s : dp[i]) {
            // append string to previous result
            String combined = s + " " + current;
            dfs(dp, result, combined, i - s.length());
        }
    }
}
