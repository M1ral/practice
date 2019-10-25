package programcreek.linklistclassicproblems;

import java.util.Stack;

// Queue using 2 stacks
public class MyQueue<E> {
    private int capacity;
    private int size;
    private Stack<E> s1;
    private Stack<E> s2;

    public MyQueue(int capacity) {
        this.capacity = capacity;
        size = 0;
        s1 = new Stack<E>();
        s2 = new Stack<E>();
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public boolean add(E e) {
        if (isFull()) {
            return false;
        }

        s1.push(e);
        size++;
        return true;
    }

    public E remove() {
        if (isEmpty()) {
            return null;
        }

        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }

        E res = s2.pop();
        size--;
        return res;
    }

    public static void main(String[] args) {
        MyQueue<Integer> queueUsingStack = new MyQueue<>(5);
        queueUsingStack.add(1);
        queueUsingStack.add(2);
        queueUsingStack.add(3);
        System.out.println("queueUsingStack.remove() = " + queueUsingStack.remove());
        System.out.println("queueUsingStack.remove() = " + queueUsingStack.remove());
        queueUsingStack.add(4);
        queueUsingStack.add(5);
        System.out.println("queueUsingStack.remove() = " + queueUsingStack.remove());
        System.out.println("queueUsingStack.remove() = " + queueUsingStack.remove());
        queueUsingStack.add(1);
        queueUsingStack.add(2);
        queueUsingStack.add(3);
        queueUsingStack.add(4);
        queueUsingStack.add(5);
        queueUsingStack.add(6);
        System.out.println("queueUsingStack.remove() = " + queueUsingStack.remove());
        System.out.println("queueUsingStack.remove() = " + queueUsingStack.remove());
        System.out.println("queueUsingStack.remove() = " + queueUsingStack.remove());
        System.out.println("queueUsingStack.remove() = " + queueUsingStack.remove());
        System.out.println("queueUsingStack.remove() = " + queueUsingStack.remove());
        System.out.println("queueUsingStack.remove() = " + queueUsingStack.remove());
    }
}
