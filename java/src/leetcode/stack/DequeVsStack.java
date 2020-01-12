package leetcode.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class DequeVsStack {

    public static void main(String[] args) {
        Deque<Integer> dequeStack = new ArrayDeque<>();
        dequeStack.addFirst(1);
        dequeStack.addFirst(2);
        System.out.println("dequeStack = " + dequeStack);
        System.out.println("dequeStack.pop() = " + dequeStack.removeFirst());
        System.out.println("dequeStack.pop() = " + dequeStack.removeFirst());

        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        System.out.println("stack = " + stack);
        System.out.println("stack.pop() = " + stack.pop());
        System.out.println("stack.pop() = " + stack.pop());
    }
}
