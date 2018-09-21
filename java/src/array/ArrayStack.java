package array;

public class ArrayStack {

    private int[] data;
    private int top = -1;
    private int capacity;

    public ArrayStack(int capacity) {
        data = new int[capacity];
        this.capacity = capacity;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == capacity - 1;
    }

    public boolean push(int n) {
        if (isFull()) {
            return false;
        }
        top++;
        data[top] = n;
        return true;
    }

    public int pop() {
        if (isEmpty()) {
            return -1;
        }

        int temp = data[top];
        data[top] = 0;
        top--;
        return temp;
    }

    public String toString() {
        if (isEmpty()) {
            return "Empty Stack, give some push!";
        }

        StringBuilder sb = new StringBuilder();
        for (int i = top; i >= 0; i--) {
            sb.append(data[i]).append("->");
        }
        sb.append("end of stack");
        return sb.toString();
    }

    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(10);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.push(7);
        stack.push(8);
        stack.push(9);
        stack.push(10);
        stack.push(11);

        System.out.println("stack = " + stack);

        System.out.println("pop() : " + stack.pop());
        System.out.println("pop() : " + stack.pop());
        System.out.println("pop() : " + stack.pop());

        System.out.println("stack = " + stack);
    }
}
