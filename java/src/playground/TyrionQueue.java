package playground;

public class TyrionQueue<E> {
    private E[] arr;
    private int capacity;
    private int size;
    private int first;
    private int last;

    public TyrionQueue(int capacity) {
        this.capacity = capacity;
        arr = (E[]) new Object[capacity];
        size = 0;
        first = -1;
        last = -1;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean add(E e) {
        if (isFull()) {
            return false;
        }

        first = (first + 1) % arr.length;
        arr[first] = e;
        size++;

        if (last == -1) {
            last = first;
        }
        return true;
    }

    public E remove() {
        if (isEmpty()) {
            return null;
        }

        E result = arr[last];
        arr[last] = null;
        size--;
        last = (last + 1) % arr.length;

        if (size == 0) {
            first = -1;
            last = -1;
        }

        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (E e : arr) {
            if (null == e) continue;
            sb.append(e).append("-");
        }
        return sb.append("|").toString();
    }

    public static void main(String[] args) {
        TyrionQueue<Integer> tq = new TyrionQueue<>(3);
        tq.add(1);
        tq.add(2);
        System.out.println("Q = " + tq);
        System.out.println("Q.remove() = " + tq.remove());
        System.out.println("Q.remove() = " + tq.remove());
        tq.add(3);
        tq.add(4);
        tq.add(5);
        tq.add(6);
        System.out.println("Q = " + tq);
    }
}
