package array;

public class ArrayStackElements<E> {

    private int first = 0;
    private int last = 0;
    private int capacity;
    private E[] data = null;
    private int size;

    public ArrayStackElements(int capacity) {
        this.capacity = capacity;
        data = (E[]) new Object[capacity];
        size = 0;
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

        if (isEmpty()) {
            data[first] = e;
            last = first;
        } else {
            data[++last] = e;
        }
        size++;
        return true;
    }

    public E remove() {
        if (isEmpty()) {
            return null;
        }
        E temp = data[last];
        data[last] = null;
        last--;
        size--;
        return temp;
    }

    public String toString() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
        }

        StringBuilder sb = new StringBuilder();
        for (int i = first; i <= last; i++) {
            sb.append(data[i]).append("->");
        }
        sb.append("end of queue");
        return sb.toString();
    }

    public static void main(String[] args) {
        ArrayStackElements<Integer> queue = new ArrayStackElements<>(5);
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        queue.add(6);

        System.out.println("queue = " + queue);

        queue.remove();
        queue.remove();
        queue.remove();

        System.out.println("queue = " + queue);
    }
}
