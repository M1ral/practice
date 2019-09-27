package stack;

import java.util.Arrays;

public class TyrionStack<T> {

    private int[] elements = null;
    private int size;
    private int currentIndex = 0;

    public TyrionStack(int size) {
        this.size = size;
        elements = new int[size];
        currentIndex = -1;
    }

    public boolean isEmpty() {
        return currentIndex == -1;
    }

    public boolean isFull() {
        return currentIndex == size-1;
    }

    public int pop() {
        if (this.isEmpty()) {
            return -1;
        }
        int ret = elements[currentIndex];
        elements[currentIndex] = -1;
        currentIndex--;

        if (currentIndex < size / 4) {
            deflate();
        }
        return ret;
    }

    public boolean push(int num) {
        if (this.isFull()) {
            return false;
        }
        if (currentIndex > size/2) {
            inflate();
        }
        elements[++currentIndex] = num;
        return true;
    }

    private void inflate() {
        size *= 2;
        int[] inflated = Arrays.copyOf(this.elements, size);
        this.elements = inflated;
    }

    private void deflate() {
        size /= 2;
        int[] deflated = Arrays.copyOf(this.elements, size);
        this.elements = deflated;
    }

    public String toString() {
        if (isEmpty()) {
            return "Empty stack!";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = elements.length -1;  i >= 0; i--) {
            sb.append(elements[i]).append("::");
        }
        sb.append("||");
        return sb.toString();
    }

    public static void main(String[] args) {
        TyrionStack tyrionStack = new TyrionStack(3);
        tyrionStack.push(1);
        tyrionStack.push(2);
        tyrionStack.push(3);
        tyrionStack.push(4);
        tyrionStack.push(5);
        System.out.println("tyrionStack = " + tyrionStack);
        System.out.println("tyrionStack.pop() = " + tyrionStack.pop());
        System.out.println("tyrionStack.pop() = " + tyrionStack.pop());
        tyrionStack.push(4);
        tyrionStack.push(5);
        tyrionStack.push(6);
        tyrionStack.push(7);
        tyrionStack.push(8);
        System.out.println("tyrionStack.pop() = " + tyrionStack.pop());
        System.out.println("tyrionStack.pop() = " + tyrionStack.pop());
        System.out.println("tyrionStack.pop() = " + tyrionStack.pop());
        System.out.println("tyrionStack = " + tyrionStack);
    }
}
