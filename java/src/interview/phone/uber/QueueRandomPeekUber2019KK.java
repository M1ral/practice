package interview.phone.uber;

import java.util.NoSuchElementException;
import java.util.Random;

public class QueueRandomPeekUber2019KK {
    public static void main(String[] args) {
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>(5);
        arrayQueue.add(1);
        arrayQueue.add(2);
        arrayQueue.add(3);
        arrayQueue.add(4);
        arrayQueue.add(5);
        System.out.println("arrayQueue.peek() = " + arrayQueue.peek());
        System.out.println("arrayQueue.peekRandom() = " + arrayQueue.peekRandom());
        System.out.println("arrayQueue.remove() = " + arrayQueue.remove());
        arrayQueue.add(4);

        NodeQueue<Integer> nodeQueue = new NodeQueue<Integer>();
        nodeQueue.add(1);
        nodeQueue.add(2);
        nodeQueue.add(3);
        nodeQueue.add(4);
        nodeQueue.add(5);
        System.out.println("nodeQueue.peek() = " + nodeQueue.peek());
        System.out.println("nodeQueue.remove() = " + nodeQueue.remove());
        nodeQueue.add(4);
        System.out.println("nodeQueue.remove() = " + nodeQueue.remove());
    }
}

class ArrayQueue<T> {
    // add (T)
    // T remove()
    // T peek()
    // T peekRandom() - In order to do a randomPeek, we should consider array as an underlying data structure

    int size;
    int capacity;
    int first = -1;
    int last = -1;
    T[] arr = null;

    public ArrayQueue(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        arr = (T[]) new Object[capacity]; // initialize
    }

    public boolean isFull() {
        return this.size == capacity;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void add(T element) {
        if (this.isFull()) {
            throw new RuntimeException("Queue is full, cannot add more elements.");
        }

        first = (first + 1) % arr.length;
        arr[first] = element;
        size++;

        if (last == -1) {
            last = first;
        }
    }

    public T remove() {
        if (this.isEmpty()) {
            throw new NoSuchElementException("Empty queue");
        }

        T element = arr[last];
        arr[last] = null;
        size--;

        last = (last + 1) % arr.length;

        if (size == 0) {
            first = -1;
            last = -1;
        }
        return element;
    }

    public T peek() {
        if (this.isEmpty()) {
            return null;
        }
        return this.arr[last];
    }

    public T peekRandom() {
        if (this.isEmpty()) {
            return null;
        }
        int randomIndex = Math.min(first, last) + new Random().nextInt(Math.abs(last - first) + 1);
        return this.arr[randomIndex];
    }
}

class NodeQueue<T> {
    int size;
    Node first, last;

    public NodeQueue() {
        this.size = 0;
        first = null;
        last = null;
    }

    public void add(T val) {
        Node newNode = new Node(val);
        if (first == null) {
            first = newNode;
            last = newNode;
        } else {
            last.next = newNode;
            last = newNode;
        }
        size++;
    }

    public T remove() {
        if (size == 0) {
            return null;
        }

        Node toRemove = first;
        size--;
        if (size == 0) {
            first = null;
            last = null;
        } else {
            first = first.next;
        }
        return (T) toRemove.val;
    }

    public T peek() {
        if (size == 0) {
            return null;
        }
        return (T) first.val;
    }
}

class Node<T> {
    T val;
    Node next;

    public Node(T val) {
        this.val = val;
        next = null;
    }
}
