package leetcoce.dp;

import java.util.*;

public class WordBreakII {

    public static void main(String[] args) {
        WordBreakII wb2 = new WordBreakII();
        System.out.println("wb2.wordBreak(\"catsanddog\", (\"cat\", \"cats\", \"and\", \"sand\", \"dog\")) = " +
                wb2.wordBreak("catsanddog", new ArrayList<>(Arrays.asList("cat", "cats", "and", "sand", "dog"))));
    }

    //TODO - understand this shit
    public List<String> wordBreak(String s, List<String> wordDict) {
        TrieNode root = buildTrie(wordDict);
        // memorization
        Map<String, List<String>> map = new HashMap<>();
        return backtrack(s, map, root);
    }

    private List<String> backtrack(String s, Map<String, List<String>> map, TrieNode root) {
        if (map.containsKey(s)) return map.get(s);
        List<String> res = new ArrayList<>();
        if (s.isEmpty()) {
            res.add(s);
            map.put(s, res);
            return res;
        }
        char[] chars = s.toCharArray();
        TrieNode curr = root;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (curr.next[c - 'a'] == null) break;
            curr = curr.next[c - 'a'];
            if (curr.word != null) {
                List<String> tmp = backtrack(s.substring(curr.word.length()), map, root);
                for (String tmps : tmp) {
                    res.add(curr.word + (tmps.isEmpty() ? "" : (" " + tmps)));
                }
            }
        }
        map.put(s, res);
        return res;
    }

    class TrieNode {
        String word;
        TrieNode[] next = new TrieNode[26];
    }

    public TrieNode buildTrie(List<String> words) {
        TrieNode root = new TrieNode();
        for (String w : words) {
            TrieNode p = root;
            for (char c : w.toCharArray()) {
                int i = c - 'a';
                if (p.next[i] == null) p.next[i] = new TrieNode();
                p = p.next[i];
            }
            p.word = w;
        }
        return root;
    }
}
