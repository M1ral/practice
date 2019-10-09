package leetcoce.queue;

public class TyrionQueue<E> {

    private E[] arr;
    private int capacity;
    private int first;
    private int last;
    private int size;

    public TyrionQueue(int capacity) {
        this.capacity = capacity;
        this.arr = (E[]) new Object[capacity];
        this.first = -1;
        this.last = -1;
        this.size = 0;
    }

    public boolean isFull() {
        return this.size == capacity;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public boolean enqueue(E e) {
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

    public E dequeue() {
        if (isEmpty()) {
            return null;
        }
        E e = arr[last];
        arr[last] = null;
        size--;
        last = (last + 1) % arr.length;

        if (size == 0) {
            first = -1;
            last = -1;
        }
        return e;
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
        tq.enqueue(1);
        tq.enqueue(2);
        System.out.println("tq = " + tq);
        System.out.println("tq.dequeue() = " + tq.dequeue());
        System.out.println("tq.dequeue() = " + tq.dequeue());
        tq.enqueue(3);
        tq.enqueue(4);
        tq.enqueue(5);
        tq.enqueue(6);
        System.out.println("tq = " + tq);
    }
}
