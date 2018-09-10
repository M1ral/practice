package stack;

import java.util.Stack;

public class StackWithMin<T> extends Stack<Integer> {

    public int min;
    private Stack<Integer> ms;

    public StackWithMin() {
        ms = new Stack<>();
        min = java.lang.Integer.MAX_VALUE;
    }

    public void push(int x) {
        super.push(Integer.valueOf(x));
        if (x < min) {
            min = x;
        }
        ms.push(x);
    }

    public Integer pop() {
        int n = super.peek();
        if (n == min) {
            ms.pop();
            min = ms.pop();
        }
        return super.pop();
    }

    @Override
    public synchronized String toString() {
        if (super.isEmpty()) {
            return "Empty stack";
        }

        return super.peek().toString();
    }

    public static void main(String[] args) {
        StackWithMin stackWithMin = new StackWithMin();
        stackWithMin.push(2);
        stackWithMin.push(12);
        stackWithMin.push(1);

        System.out.println(stackWithMin);
        System.out.println(stackWithMin.min);

        stackWithMin.pop();
        stackWithMin.pop();

        System.out.println(stackWithMin);
        System.out.println(stackWithMin.min);
    }
}
