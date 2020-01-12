package interview.onsite;

import java.util.*;

public class Google2018 {

    // map for dictionary - Question 1
    private static Map<String, Set<String>> dict = new HashMap<>();

    public static void main(String[] args) {
        // Question 1
        Combination c1 = new Combination("A", Arrays.asList(new String[]{"B", "C"}));
        Combination c2 = new Combination("B", Arrays.asList(new String[]{"D"}));
        Combination c3 = new Combination("E", Arrays.asList(new String[]{"F"}));
        buildCombDict(Arrays.asList(new Combination[]{c1, c2, c3}));

        System.out.println("areEqual(\"A\", \"D\") = " + areEqual("A", "D"));
        System.out.println("areEqual(\"B\", \"F\") = " + areEqual("B", "F"));

        // Question 2
        System.out.println("longestSubstrWith2UniqueChars(\"ababbabccde\") = " +
                longestSubstrWith2UniqueChars("ababbabccde"));

        System.out.println("longestSubstrWithKUniqueChars(\"ababbabccde\") = " +
                findLongestStringWithKUniqueChars("ababbabccde", 3));
    }

    // Question 1
    public static void buildCombDict(List<Combination> combinations) {
        if (combinations == null || combinations.isEmpty()) {
            return;
        }

        for (Combination c : combinations) {
            if (!dict.containsKey(c.source)) {
                dict.put(c.source, new HashSet<>());
            }
            for (String v : c.values) {
                dict.get(c.source).add(v);

                if (!dict.containsKey(v)) {
                    dict.put(v, new HashSet<>());
                }
                dict.get(v).add(c.source);
            }
        }
    }

    public static boolean areEqual(String word1, String word2) {
        if (null == word1 || word1.isEmpty() || null == word2 || word2.isEmpty()) {
            return false;
        }
        if (!dict.containsKey(word1) || !dict.containsKey(word2)) {
            return false;
        }
        return helper(word1, word2, new HashSet<String>());
    }

    private static boolean helper(String w1, String w2, Set<String> visited) {
        if (dict.get(w1).contains(w2)) {
            return true;
        }

        visited.add(w1);
        Set<String> values = dict.get(w1);

        for (String v : values) {
            if (visited.contains(v)) {
                continue;
            }
            return helper(v, w2, visited);
        }
        return false;
    }

    // Question 2
    public static String longestSubstrWith2UniqueChars(String input) {
        if (input == null || input.isEmpty()) {
            return null;
        }

        int max = Integer.MIN_VALUE;
        String temp = "";
        String candidate = "";
        char[] chars = input.toCharArray();
        Map<Character, Integer> map = new HashMap();

        for (int i = 0; i < chars.length; i++) {
            char current = chars[i];

            if (!map.containsKey(current)) {
                map.put(current, 1);
            } else {
                map.put(current, map.get(current)+1);
            }

            while (map.size() > 2) { // remove first character
                char toRemove = temp.charAt(0);
                temp = temp.substring(1);
                map.put(toRemove, map.get(toRemove)-1);

                if (map.get(toRemove) == 0) {
                    map.remove(toRemove);
                }
            }

            temp += current;
            if (temp.length() > max) {
                max = temp.length();
                candidate = temp;
            }
        }
        return candidate;
    }

    private static String findLongestStringWithKUniqueChars(String s, int k) {
        if (null == s || s.isEmpty()) {
            return null;
        }
        if (s.length() < k) {
            return s;
        }

        Map<Character, Integer> map = new HashMap<>();
        String temp = "";
        String candidate = "";
        int max = Integer.MIN_VALUE;
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }

            while (map.size() > k) {
                char toRemove = temp.charAt(0);
                temp = temp.substring(1);
                map.put(toRemove, map.get(toRemove) - 1);

                if (map.get(toRemove) == 0) {
                    map.remove(toRemove);
                }
            }

            temp += c;
            if (temp.length() > max) {
                candidate = temp;
                max = candidate.length();
            }
        }

        return candidate;
    }
}

class Combination {
    public String source;
    public List<String> values;

    public Combination(String source, List<String> values) {
        this.source = source;
        this.values = values;
    }
}