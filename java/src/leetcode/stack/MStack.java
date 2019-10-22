package leetcode.stack;

public class MStack<E> {

    private Node top;
    private int capacity;
    private int size;

    public MStack(int capacity) {
        this.capacity = capacity;
        size = 0;
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
        Node n = new Node(e);
        n.next = top;
        top = n;

        size++;
        return true;
    }

    public E pop() {
        if (isEmpty()) {
            return null;
        }
        Node n = top;
        top = top.next;

        size--;
        return (E) n.data;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "Empty leetcoce.stack!";
        }

        StringBuilder sb = new StringBuilder();
        Node temp = top;

        while (null != temp) {
            sb.append(temp.data).append("->");
            temp = temp.next;
        }
        sb.append("end of leetcoce.stack");

        return sb.toString();
    }

    public static void main(String[] args) {
        MStack mStack = new MStack(4);
        mStack.push(new String("a"));
        mStack.push(new String("b"));
        mStack.push(new String("c"));
        mStack.push(new String("d"));

        System.out.println("mStack = " + mStack);
        System.out.println("mStack.pop() = " + mStack.pop());
        System.out.println("mStack = " + mStack);
        
        mStack.push(new String("e"));
        mStack.push(new String("f"));
        mStack.push(new String("g"));

        System.out.println("mStack.pop() = " + mStack.pop());
        System.out.println("After second pop : mStack = " + mStack);
    }
}
