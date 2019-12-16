package leetcode.matrix.island;

import java.util.*;

public class WordSearchII {

    public static void main(String[] args) {
        WordSearchII ws = new WordSearchII();

        System.out.println("findWords() = " + ws.findWords(new char[][]{
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}
        }, new String[]{"oath", "pea", "eat", "rain"}));
    }

    TrieNode root = null;
    List<String> result = new ArrayList<>();
    char[][] board = null;

    public List<String> findWords(char[][] board, String[] words) {
        if (null == words || words.length == 0 ||
                null == board || board.length == 0) {
            return Collections.emptyList();
        }

        // build trie
        buildTrie(words);
        this.board = board;

        // find words in board
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                // letter is present in given words
                if (root.children.containsKey(board[i][j])) {
                    search(i, j, root);
                }
            }
        }

        return result;
    }

    // recursively search for word
    private void search(int row, int col, TrieNode parent) {
        char letter = this.board[row][col];
        TrieNode current = parent.children.get(letter);

        // check if word present on current node
        if (current.word != null) {
            result.add(current.word);
            current.word = null; // remove word
        }

        // mark current letter used
        this.board[row][col] = '#';

        // check neighbouring elements
        int[] rowsOffset = {-1, 0, 1, 0};
        int[] colsOffset = {0, 1, 0, -1};
        for (int i = 0; i < 4; i++) {
            int r = row + rowsOffset[i], c = col + colsOffset[i]; // Important
            if (r < 0 || r >= board.length || c < 0 || c >= board[0].length) {
                continue;
            }
            if (current.children.containsKey(this.board[r][c])) {
                search(r, c, current);
            }
        }

        // update current letter back
        this.board[row][col] = letter;

        // optimize - remove the leaf nodes
        if (current.children.isEmpty()) {
            parent.children.remove(letter);
        }
    }

    // build trie for given words
    private void buildTrie(String[] words) {
        if (null == words || words.length == 0) {
            return;
        }

        root = new TrieNode();
        for (String word : words) {
            char[] chars = word.toCharArray();
            TrieNode current = root;
            for (char ch : chars) {
                if (! current.children.containsKey(ch)) {
                    current.children.put(ch, new TrieNode());
                }
                current = current.children.get(ch);
            }
            current.word = word;
        }
    }
}

class TrieNode {
    Map<Character, TrieNode> children;
    String word;

    public TrieNode() {
        this.children = new HashMap<>();
        word = null;
    }
}