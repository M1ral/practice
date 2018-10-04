package specials;

import java.util.*;

/**
 * start = "hit"
 * end = "cog"
 * dict = ["hot","dot","dog","lot","log"]
 * <p>
 * One shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * the program should return its length 5.
 */
public class WordLadder {
    public static void main(String[] args) {
        System.out.println("ladderLength = " + ladderLength("hit", "cog",
                new ArrayList<String>(Arrays.asList("hot", "dot", "dog", "lot", "log", "het", "cog"))));
    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Deque<String> toVisit = new ArrayDeque<>();
        Set<String> wordSet = new HashSet<>(wordList.size());

        // change to hashset.
        wordSet.addAll(wordList);
        if (!wordSet.contains(endWord)) {
            return 0;  // no solution if endword not in wordSet.
        }

        toVisit.add(beginWord);
        int dist = 1;
        while (!toVisit.isEmpty()) {

            int num = toVisit.size();
            for (int i = 0; i < num; i++) {
                String word = toVisit.pollFirst();
                if (word.equals(endWord)) {
                    return dist;
                }
                // bfs - add next set of words for current word
                // i.e, hot -> dot, lot
                addNextWord(word, wordSet, toVisit);
            }

            // next vertex
            dist++;
        }
        return 0;
    }


    /**
     * add adjacent vertex to the queue.
     *
     * @param word
     * @param wordSet
     * @param toVisit
     */
    private static void addNextWord(String word, Set<String> wordSet, Deque<String> toVisit) {
        wordSet.remove(word);
        char[] data = word.toCharArray();
        for (int i = 0; i < data.length; i++) {
            char c = data[i];
            for (int j = 0; j < 26; j++) {
                data[i] = (char) ('a' + j);
                String temp = String.valueOf(data);
                if (wordSet.contains(temp)) {
                    toVisit.addLast(temp);
                    wordSet.remove(temp);
                }
            }
            data[i] = c;
        }
    }
}
