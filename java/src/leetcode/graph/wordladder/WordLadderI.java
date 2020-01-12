package leetcode.graph.wordladder;

// https://leetcode.com/problems/word-ladder/

import javafx.util.Pair;

import java.util.*;

/**
 * Input:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * <p>
 * Output: 5
 * <p>
 * Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 */
public class WordLadderI {
    public static void main(String[] args) {
        System.out.println("findLadderLength(\"hit\", \"cog\", Arrays.asList(\"hot\",\"dot\",\"dog\",\"lot\",\"log\",\"cog\")) = " +
                findLadderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog")));
    }

    public static int findLadderLength(String beginWord, String endWord, List<String> wordList) {
        if (null == beginWord || beginWord.isEmpty() ||
                null == endWord || endWord.isEmpty() ||
                null == wordList || wordList.isEmpty()) {
            return 0;
        }
        if (!wordList.contains(endWord)) {
            return 0;
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
                        return level + 1;
                    }

                    if (! visited.contains(adjWord)) {
                        visited.add(adjWord);
                        Q.add(new Pair<>(adjWord, level + 1));
                    }
                }
            }
        }

        return 0;
    }


}
