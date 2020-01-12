package leetcode.trie;

import java.util.*;

class AutocompleteSystem {

    public static void main(String[] args) {
        AutocompleteSystem autocompleteSystem = new AutocompleteSystem(
                new String[]{"i love you", "island", "iroman", "i love leetcode"},
                new int[]{5, 3, 3, 2});
        System.out.println("autocompleteSystem.searchTrie(\"i\") = " + autocompleteSystem.search("i"));
        System.out.println("autocompleteSystem.searchTrie(\"i \") = " + autocompleteSystem.search("i "));
        System.out.println("autocompleteSystem.searchTrie(\"i a\") = " + autocompleteSystem.search("i a"));
        System.out.println("autocompleteSystem.searchTrie(\"i a#\") = " + autocompleteSystem.search("i a#"));
    }

    TrieAC root;
    StringBuilder searchTerm;

    private void add(String s, int count) {
        TrieAC curr = root;
        for (char c : s.toCharArray()) {
            curr.children.putIfAbsent(c, new TrieAC());
            curr = curr.children.get(c);
            curr.counts.put(s, curr.counts.getOrDefault(s, 0) + count);
            // curr.hotTerms.add(new Term(s, count)); - alternate approach
        }
    }

    public List<String> search(String term) {
        if (null == term || term.isEmpty()) {
            return Collections.emptyList();
        }

        TrieAC curr = root;
        for (char cc : term.toCharArray()) {
            if (! curr.children.containsKey(cc)) {
                return new ArrayList<String>();
            }
            curr = curr.children.get(cc);
        }

        // curr.hotTerms.forEach(System.out::println); - alternate approach

        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
                (a, b) -> (a.getValue() == b.getValue()
                        ? a.getKey().compareTo(b.getKey())
                        : b.getValue() - a.getValue()
                ));
        pq.addAll(curr.counts.entrySet());

        List<String> res = new ArrayList<String>();
        int k = 3;
        while (!pq.isEmpty() && k > 0) {
            res.add((String) pq.poll().getKey());
            k--;
        }
        return res;
    }

    public AutocompleteSystem(String[] sentences, int[] times) {
        root = new TrieAC();
        searchTerm = new StringBuilder();

        int i = 0;
        for (String sentence : sentences) {
            add(sentence, times[i++]);
        }
    }

    public List<String> input(char c) {
        if (c == '#') {
            add(searchTerm.toString(), 1);
            searchTerm = new StringBuilder();
            return Collections.emptyList();
        }
        searchTerm.append(c);
        return search(searchTerm.toString());
    }
}

class TrieAC {
    Map<Character, TrieAC> children;
    Map<String, Integer> counts;
    // Set<Term> hotTerms; - alternate approach

    public TrieAC() {
        children = new HashMap();
        counts = new HashMap<>();
        // hotTerms = new TreeSet<>(); - alternate approach
    }
}

class Term implements Comparable<Term> {
    String word;
    int count;
    public Term(String word, int count) {
        this.word = word;
        this.count = count;
    }

    @Override
    public int compareTo(Term o) {
        return this.count == o.count
                ? this.word.compareTo(o.word)
                : o.count - this.count;
    }

    @Override
    public boolean equals(Object obj) {
        return this.word.equals(((Term)obj).word);
    }

    @Override
    public int hashCode() {
        return this.word.hashCode();
    }

    @Override
    public String toString() {
        return word + " : " + count;
    }
}
