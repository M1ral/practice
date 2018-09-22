package specials;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    private int capacity;
    private Node head = null;
    private Node end = null;
    private Map<Integer, Node> map = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    /**
     * Get Node from the cache
     *
     * @param key
     * @return int
     */
    public int get(int key) {
        if (map.containsKey(key)) {
            Node n = map.get(key);
            remove(n); // remove from current position in the list
            setHead(n); //
            return n.value;
        }
        return -1;
    }

    /**
     * Set Node in the cache
     *
     * @param key
     * @param value
     */
    public void set(int key, int value) {
        // if key is present
        if (map.containsKey(key)) {
            Node old = map.get(key);
            old.value = value;
            remove(old); // remove from the list
            setHead(old); // bring to front
        } else {
            Node n = new Node(key, value);
            if (map.size() >= capacity) {
                map.remove(end.key);
                remove(end); // REMOVE LEAST RECENTLY USED ITEM
            }
            setHead(n); // bring to front
            map.put(key, n);
        }
    }

    /**
     * Set head of the doubly LinkedList
     * @param n
     */
    private void setHead(Node n) {
        // previous and next
        n.next = head;
        n.previous = null;

        // if head is present
        if (head != null) {
            head.previous = n;
        }

        head = n;

        // if there are no other nodes
        if (end == null) {
            end = head;
        }
    }

    /**
     * Remove node from the doubly LinkedList
     * @param n
     */
    private void remove(Node n) {
        // handle previous
        if (n.previous != null) {
            n.previous.next = n.next;
        } else { // previous is head
            head.next = n.next;
        }

        // handle next
        if (n.next != null) {
            n.next.previous = n.previous;
        } else { // next is end
            end = n.previous;
        }
    }
}

// Doubly-LinkedList Node
class Node {
    public int key;
    public int value;
    public Node previous;
    public Node next;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
