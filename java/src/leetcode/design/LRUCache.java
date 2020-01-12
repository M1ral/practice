package leetcode.design;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    private int capacity;
    private DoublyLinkedList list;
    private Map<Integer, DoublyNode> map;

    public LRUCache(int capacity) {
        list = new DoublyLinkedList();
        map = new HashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        DoublyNode node = map.get(key);
        if (node != null) {
            list.remove(node);
            list.addFirst(node);
            return node.value;
        } else
            return -1;
    }

    public void put(int key, int value) {
        DoublyNode node = map.get(key);
        if (node != null) {
            list.remove(node);
            node.value = value;
            list.addFirst(node);
        } else {
            if (list.size() == capacity) {
                map.remove(list.removeLast().key); // LRU remove
            }
            node = new DoublyNode(key, value);
            list.addFirst(node);
            map.put(key, node);
        }
    }

    class DoublyNode {
        int key;
        int value;
        DoublyNode prev;
        DoublyNode next;

        DoublyNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    class DoublyLinkedList {
        DoublyNode head;
        DoublyNode tail;
        int size = 0;

        void addFirst(DoublyNode node) {
            if (head == null) {
                head = node;
                tail = node;
            } else {
                node.next = head;
                head.prev = node;
                head = node;
            }
            size++;
        }

        void remove(DoublyNode node) {
            if (node == head) {
                head = head.next;
                if (head == null)
                    tail = null;
                else
                    head.prev = null;
            } else if (node == tail) {
                tail = tail.prev;
                if (tail == null)
                    head = null;
                else
                    tail.next = null;
            } else {
                DoublyNode prev = node.prev;
                DoublyNode next = node.next;
                prev.next = next;
                next.prev = prev;
            }
            size--;
        }

        DoublyNode removeLast() {
            DoublyNode lastNode = tail;
            this.remove(this.tail);
            return lastNode;
        }

        int size() {
            return size;
        }
    }
}
