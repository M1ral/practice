package leetcode.design;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/add-and-search-word-data-structure-design/
class WordDictionary {

    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");

        System.out.println("wordDictionary.search(\"pad\") = " + wordDictionary.search("pad"));
        System.out.println("wordDictionary.search(\"bad\") = " + wordDictionary.search("bad"));
        System.out.println("wordDictionary.search(\"dad\") = " + wordDictionary.search("dad"));
        System.out.println("wordDictionary.search(\".ad\") = " + wordDictionary.search("ba."));
    }

    private TrieNode root;

    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        if (null == word || word.isEmpty()) {
            return;
        }

        TrieNode current = root;
        char[] chars = word.toCharArray();

        for (char ch : chars) {
            current.children.putIfAbsent(ch, new TrieNode());
            current.children.putIfAbsent('.', new TrieNode());
            current = current.children.get(ch);
        }
        current.endOfWord = true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        if (null == word || word.isEmpty()) {
            return false;
        }

        // return helper(word, 0, root);
        TrieNode current = root;
        char[] chars = word.toCharArray();

        for (char ch : chars) {
            if (! current.children.containsKey(ch)) {
                return false;
            }
            current = current.children.get(ch);
        }
        return current.endOfWord;
    }

    /*private boolean helper(String s, int index, TrieNode p) {
        if (index >= s.length()) return p.endOfWord;
        char c = s.charAt(index);
        if (c == '.') {
            for (Character key : p.children.keySet()) {
                if (helper(s, ))
            }
            for (int i = 0; i < p.children.size(); i++)
                if (p.child[i] != null && helper(s, index + 1, p.child[i]))
                    return true;
            return false;
        } else return (p.child[c - 'a'] != null && helper(s, index + 1, p.child[c - 'a']));
    }*/
}

class TrieNode {
    Map<Character, TrieNode> children;
    boolean endOfWord;

    public TrieNode() {
        this.children = new HashMap();
        endOfWord = true;
    }
}