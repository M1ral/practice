package trie;


import java.util.HashMap;
import java.util.Map;

class Trie2 {

    private final Node root;

    public Trie2() {
        root = new Node();
    }

    public void insert(String word) {
        if (word == null || word.isEmpty()) {
            return;
        }

        Node current = root;
        for (char ch : word.toCharArray()) {
            Node node = current.children.get(ch);
            if (node == null) {
                node = new Node();
                current.children.put(ch, node);
            }
            current = node;
        }
        current.endOfWord = true; // mark end of word
    }

    public boolean search(String word) {
        if (word == null || word.isEmpty()) {
            return false;
        }

        Node current = root;
        for (char ch : word.toCharArray()) {
            Node node = current.children.get(ch);
            if (node == null) {
                return false;
            }
            current = node;
        }
        return current.endOfWord; // return true only when endOfWord is true
    }

    public boolean searchPrefix(String prefix) {
        if (prefix == null || prefix.isEmpty()) {
            return false;
        }

        Node current = root;
        for (char ch : prefix.toCharArray()) {
            Node node = current.children.get(ch);
            if (node == null) {
                return false;
            }
            current = node;
        }
        return true; // return true at the end
    }

    public static void main(String[] args) {
        Trie2 t = new Trie2();
        t.insert("abc");
        t.insert("abcd");
        t.insert("lmh");
        t.insert("defg");
        System.out.println("word abc: " + t.search("abc"));
        System.out.println("word miral: " + t.search("miral"));
        System.out.println("prefix abc: " + t.searchPrefix("abc"));
        System.out.println("word lmn: " + t.search("lmn"));
        System.out.println("word lmh: " + t.search("lmh"));
    }
}

class Node {
    public Map<Character, Node> children;
    public boolean endOfWord;

    public Node() {
        children = new HashMap();
    }
}














