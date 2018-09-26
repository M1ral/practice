package trie;

public class Trie {

    private final TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    /**
     * Test the Trie program.
     * @param args
     */
    public static void main(String[] args) {
        Trie trie = new Trie();
        // iterative
        System.out.println("-------- ITERATIVE --------");
        trie.insert("abcd");
        trie.insert("abceg");
        trie.insert("acd");
        trie.insert("acd");

        System.out.println("trie.search(\"ab\") = " + trie.search("ab"));
        System.out.println("trie.search(\"acd\") = " + trie.search("acd"));
        System.out.println("trie.search(\"abcd\") = " + trie.search("abcd"));

        // recursive
        System.out.println("\n\n-------- RECURSIVE --------");
        trie.insertRecursive("abcd", trie.root, 0);
        trie.insertRecursive("abceg", trie.root, 0);
        trie.insertRecursive("acd", trie.root, 0);
        trie.insertRecursive("acd", trie.root, 0);

        System.out.println("trie.search(\"ab\") = " + trie.searchRecursive("ab", trie.root, 0));
        System.out.println("trie.search(\"acd\") = " + trie.searchRecursive("acd", trie.root, 0));
        System.out.println("trie.search(\"abcd\") = " + trie.searchRecursive("abcd", trie.root, 0));
    }

    /**
     * Insert given word into Trie.
     * @param word
     */
    public void insert(String word) {
        if (null == word || word.isEmpty()) {
            return; // not a valid input
        }

        TrieNode current = root;
        char[] wordCharArray = word.toCharArray();

        // for each character, look for the character in the map of current,
        // if that exists, move on to next
        // else create a new node, put an entry for that character in the map and continue
        for (char ch : wordCharArray) {
            TrieNode node = current.children.get(ch);
            if (null == node) {
                node = new TrieNode();
                current.children.put(ch, node);
            }

            current = node;
        }

        current.endOfWord = true;
    }

    /**
     * Recursively insert word into the Trie.
     * @param word
     * @param current
     * @param index
     */
    public void insertRecursive(String word, TrieNode current, int index) {
        if (null == current) {
            return;
        }
        if (null == word || word.isEmpty()) {
            return;
        }
        if (word.length() == index) {
            current.endOfWord = true;
            return;
        }

        char ch = word.charAt(index);
        TrieNode node = current.children.get(ch);

        // if a TrieNode doesn't exist for character, create one and add it to current
        if (null == node) {
            node = new TrieNode();
            current.children.put(ch, node);
        }

        insertRecursive(word, current, index + 1);
    }

    /**
     * Search if given word exists in Trie.
     * @param word
     * @return boolean
     */
    public boolean search(String word) {
        if (null == word || word.isEmpty()) {
            return false;
        }

        TrieNode current = root;
        char[] wordChars = word.toCharArray();

        for (char ch : wordChars) {
            TrieNode node = current.children.get(ch);
            // if node doesn't exist for given character, return false
            if (null == node) {
                return false;
            }

            current = node;
        }
        // if current node has endOfWord = true, then return true, false otherwise
        return current.endOfWord;
    }

    /**
     * Search for given word in the Trie.
     *
     * @param word
     * @param current
     * @param index
     * @return boolean
     */
    public boolean searchRecursive(String word, TrieNode current, int index) {
        if (null == current) {
            return false;
        }
        if (null == word || word.isEmpty()) {
            return false;
        }
        if (word.length() == index) {
            return current.endOfWord;
        }

        char ch = word.charAt(index);
        TrieNode node = current.children.get(ch);
        if (null == node) {
            // if the current node is null for given character, return false
            return false;
        }

        return searchRecursive(word, node, index + 1);
    }

    /**
     * Deletes given word from the Trie.
     * @param word
     * @return boolean
     */
    public boolean delete(String word) {
        if (null == word || word.isEmpty()) {
            return false;
        }

        //TODO - understand this function - step by step debugging
        return delete(word, this.root, 0);
    }

    /**
     * Recursive delete function to remove word from the Trie.
     * @param word
     * @param current
     * @param index
     * @return boolean
     */
    private boolean delete(String word, TrieNode current, int index) {
        if (null == word || word.isEmpty() || null == current) {
            return false; // sanity check
        }

        if (word.length() == index) {
            // when end of word is reached, delete only when endOfWord is true
            if (!current.endOfWord) {
                return false;
            }
            current.endOfWord = false;
            return current.children.size() == 0;
        }

        char ch = word.charAt(index);
        TrieNode node = current.children.get(ch);
        // if there is no downstream trie node for given character, return false
        if (null == node) {
            return false;
        }

        boolean shouldDeleteCurrentNode = delete(word, node, index + 1);

        // if true is returned, delete the mapping of character
        if (shouldDeleteCurrentNode) {
            current.children.remove(ch);
            // return true if no mappings are left
            return current.children.size() == 0;
        }

        return false;
    }

    @Override
    public String toString() {
        if (null == root || null == root.children || root.children.isEmpty()) {
            return "Empty Trie!";
        }

        TrieNode current = root;
        for (Character c : root.children.keySet()) {

        }

        return "Trie is available, I need to figure out how to print it though!";
    }
}
