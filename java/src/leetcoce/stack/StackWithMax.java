package leetcoce.stack;

import java.util.Stack;

public class StackWithMax extends Stack<Integer> {
    private Stack<Integer> maxStack;
    private int max;

    public StackWithMax() {
        max = Integer.MIN_VALUE;
        maxStack = new Stack<>();
    }

    public void push(int value) {
        super.push(value);
        if (value > max) {
            max = value;
            maxStack.push(value);
        }
    }

    public Integer pop() {
        int ret = super.peek();
        if (ret == max) {
            maxStack.pop();
            max = maxStack.pop();
        }
        return super.pop();
    }

    public static void main(String[] args) {
        StackWithMax stackWithMax = new StackWithMax();
        stackWithMax.push(2);
        stackWithMax.push(12);
        stackWithMax.push(1);

        System.out.println(stackWithMax);
        System.out.println(stackWithMax.max);

        stackWithMax.pop();
        stackWithMax.pop();

        System.out.println(stackWithMax);
        System.out.println(stackWithMax.max);
    }
}
