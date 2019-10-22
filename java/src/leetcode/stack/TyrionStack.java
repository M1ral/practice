package leetcode.stack;

public class TyrionStack<E> {

    private E[] arr;
    private int top = -1;
    private int size = 0;
    private int capacity;

    public TyrionStack(int capacity) {
        this.capacity = capacity;
        this.arr = (E[]) new Object[capacity];
    }

    public boolean isFull() {
        return this.size == this.capacity;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public boolean push(E e) {
        if (isFull()) {
            return false;
        }
        this.arr[++top] = e;
        this.size++;
        return true;
    }

    public E pop() {
        if (this.isEmpty()) {
            return null;
        }
        E e = this.arr[top];
        this.arr[top] = null;
        this.top--;
        this.size--;
        return e;
    }

    @Override
    public String toString() {
        if (this.isEmpty()) {
            return "Empty leetcoce.stack!";
        }
        StringBuilder result = new StringBuilder();
        for (int i=this.arr.length-1; i >= 0; i--) {
            if (null == arr[i]) continue;
            result.append(arr[i]).append("-");
        }
        return result.append("|").toString();
    }

    public static void main(String[] args) {
        TyrionStack<Integer> tyrionStack = new TyrionStack<>(5);
        tyrionStack.push(1);
        tyrionStack.push(2);
        tyrionStack.push(3);
        System.out.println("tyrionStack = " + tyrionStack);
        System.out.println("tyrionStack.pop() = " + tyrionStack.pop());
        System.out.println("tyrionStack.pop() = " + tyrionStack.pop());
        System.out.println("tyrionStack.pop() = " + tyrionStack.pop());
        System.out.println("tyrionStack.pop() = " + tyrionStack.pop());
        tyrionStack.push(4);
        tyrionStack.push(5);
        tyrionStack.push(6);
        tyrionStack.push(7);
        tyrionStack.push(8);
        tyrionStack.push(9);
        tyrionStack.push(10);
        System.out.println("tyrionStack = " + tyrionStack);
    }
}
