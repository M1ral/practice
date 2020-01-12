package leetcode.graph.wordladder;

import javafx.util.Pair;

import java.util.*;

// https://leetcode.com/problems/word-ladder-ii/
public class WordLadderII {

    public static void main(String[] args) {

    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result = new ArrayList<>();
        if (null == beginWord || beginWord.isEmpty() ||
                null == endWord || endWord.isEmpty() ||
                null == wordList || wordList.isEmpty()) {
            return result;
        }
        if (!wordList.contains(endWord)) {
            return result;
        }

        // build transformations map
        int l = beginWord.length();
        Map<String, List<String>> combMap = new HashMap<>();
        wordList.forEach(
                word -> {
                    for (int i = 0; i < l; i++) {
                        String combWord = word.substring(0, i) + "_" + word.substring(i + 1, l);
                        List<String> transformations = combMap.getOrDefault(combWord, new ArrayList<>());
                        transformations.add(word);
                        combMap.put(combWord, transformations);
                    }
                });

        // Queue for BFS
        Deque<Pair<String, Integer>> Q = new ArrayDeque<>();
        Q.add(new Pair<>(beginWord, 1));
        // visited words
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        while (!Q.isEmpty()) {
            Pair<String, Integer> node = Q.remove();
            String word = node.getKey();
            int level = node.getValue();

            for (int i = 0; i < l; i++) {
                String newWord = word.substring(0, i) + "_" + word.substring(i+1, l);
                // transformations for word's current combination
                for (String adjWord : combMap.getOrDefault(newWord, new ArrayList<>())) {
                    if (adjWord.equals(endWord)) {
                        return result;
                    }

                    if (! visited.contains(adjWord)) {
                        visited.add(adjWord);
                        Q.add(new Pair<>(adjWord, level + 1));
                    }
                }
            }
        }

        return result;
    }
}
