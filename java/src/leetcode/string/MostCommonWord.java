package leetcode.string;


import java.util.*;
import java.util.stream.Collectors;

public class MostCommonWord {
    public static void main(String[] args) {
        System.out.println("mostCommonWord(Bob. hIt, baLl, {bob, hit}) = " +
                mostCommonWord("Bob. hIt, baLl", new String[]{"bob", "hit"}));
    }

    public static String mostCommonWord(String paragraph, String[] banned) {
        if (null == paragraph || paragraph.isEmpty()) {
            return null;
        }

        Map<String, Integer> map = new HashMap<>();
        Set<String> bannedWords = new HashSet<>(Arrays.asList(banned).stream()
                .map(String::toLowerCase)
                .collect(Collectors.toList()));
        paragraph = paragraph.toLowerCase().replaceAll("\\pP", " ");
        String[] words = paragraph.split(" ");
        String mostCommon = "";
        int max = Integer.MIN_VALUE;

        for (String word : words) {
            if (!word.trim().isEmpty() && !bannedWords.contains(word)) {
                map.put(word, map.getOrDefault(word, 0) + 1);
                if (max < map.get(word)) {
                    mostCommon = word;
                    max = map.get(word);
                }
            }
        }

        return mostCommon;
    }
}
