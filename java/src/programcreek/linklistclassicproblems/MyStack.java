package programcreek.linklistclassicproblems;

import java.util.ArrayDeque;
import java.util.Queue;

// Stack using 2 queues
public class MyStack<E> {

    private Queue<E> q1;
    private Queue<E> q2;
    private int capacity;
    private int size;

    public MyStack(int capacity) {
        this.capacity = capacity;
        q1 = new ArrayDeque<>(capacity);
        q2 = new ArrayDeque<>(capacity);
        size = 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E pop() {
        if (isEmpty()) {
            return null;
        }

        E res = null;
        if (!q1.isEmpty()) {
            res = q1.poll();
        } else if (!q2.isEmpty()) {
            res = q2.poll();
        }
        size--;
        return res;
    }

    public boolean push(E e) {
        if (isFull()) {
            return false;
        }

        if (q1.isEmpty() && q2.isEmpty()) {
            q1.offer(e);
            size++;
            return true;
        } else {
            if (q2.isEmpty()) {
                q2.add(e);
                while (!q1.isEmpty()) {
                    q2.add(q1.poll());
                }
            } else if (q1.isEmpty()) {
                q1.add(e);
                while (!q2.isEmpty()) {
                    q1.add(q2.poll());
                }
            } else {
                return false;
            }
        }
        size++;
        return true;
    }

    public static void main(String[] args) {
        MyStack<Integer> stack = new MyStack<>(3);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println("leetcoce.stack.pop() = " + stack.pop());
        System.out.println("leetcoce.stack.pop() = " + stack.pop());
        stack.push(5);
        stack.push(6);
        System.out.println("leetcoce.stack.pop() = " + stack.pop());
        System.out.println("leetcoce.stack.pop() = " + stack.pop());
        System.out.println("leetcoce.stack.pop() = " + stack.pop());
    }
}
