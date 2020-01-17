package leetcode.design;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

// https://leetcode.com/problems/maximum-frequency-stack/
public class MaxFreqStack {
    public static void main(String[] args) {
        MaxFreqStack stack = new MaxFreqStack();
        stack.push(5);
        stack.push(7);
        stack.push(5);
        stack.push(7);
        stack.push(4);
        stack.push(5);

        System.out.println("stack.pop() = " + stack.pop());
        System.out.println("stack.pop() = " + stack.pop());
        System.out.println("stack.pop() = " + stack.pop());
        System.out.println("stack.pop() = " + stack.pop());
    }

    private PriorityQueue<Node> freqStack;
    private Map<Integer, Integer> counter;
    private int offset;

    public MaxFreqStack() {
        freqStack = new PriorityQueue<Node>();
        counter = new HashMap<>();
        offset = 1;
    }

    public void push(int x) {
        counter.put(x, counter.getOrDefault(x, 0) + 1);
        Node toAdd = new Node(x, counter.get(x), offset++);
        freqStack.offer(toAdd); // log n
    }

    public int pop() {
        if (freqStack.isEmpty()) {
            return -1;
        }

        Node toReturn = freqStack.remove();
        counter.put(toReturn.val, counter.get(toReturn.val) - 1);
        if (counter.get(toReturn.val) == 0) {
            counter.remove(toReturn.val);
        }

        return toReturn.val; // log n
    }
}

class Node implements Comparable<Node> {
    int val;
    int count;
    int offset;

    public Node(int val, int count, int offset) {
        this.val = val;
        this.count = count;
        this.offset = offset;
    }

    @Override
    public int compareTo(Node other) {
        return this.count == other.count
                ? other.offset - this.offset
                : other.count - this.count;
    }

    @Override
    public String toString() {
        return val + " : " + count + ", " + offset;
    }
}
