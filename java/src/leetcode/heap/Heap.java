package leetcode.heap;

import java.util.Arrays;

public class Heap {
    private int[] heap;
    private int maxSize;
    private int currSize;

    public Heap(int maxSize) {
        this.heap = new int[maxSize];
        this.currSize = 0;
        this.maxSize = maxSize;
    }

    public boolean isFull() {
        return currSize == maxSize;
    }

    public boolean isEmpty() {
        return currSize == 0;
    }

    public boolean add(int value) {
        if (isFull()) return false;
        // new element at last
        heap[currSize] = value;
        // trickle up last index
        // increment currSize
        trickleUp(currSize++);
        return true;
    }

    public int remove() {
        if (isEmpty()) return -1;
        int ret = heap[0]; // remove root
        // bring last element to root
        // decrement currSize
        heap[0] = heap[--currSize];
        heap[currSize] = -1;
        // trickle down 0th index
        trickleDown(0);
        return ret;
    }

    public void trickleUp(int index) {
        if (index < 0 || index > maxSize) return;

        // bottom
        int bottom = heap[index];
        // parent
        int parent = index / 2;

        while (index > 0 && heap[parent] < bottom) {
            heap[index] = heap[parent];
            index = parent;
            parent = index / 2;
        }

        // put bottom at final index
        heap[index] = bottom;
    }

    public void trickleDown(int index) {
        if (index < 0 || index > maxSize) return;

        // top
        int top = heap[index];
        // larger child
        int largerChild;

        while (index < currSize / 2) {
            // left and right children
            int left = 2 * index, right = left + 1;

            if (right < currSize && heap[left] < heap[right]) {
                largerChild = right;
            } else {
                largerChild = left;
            }

            // come out if top element becomes larger
            if (top >= heap[largerChild]) {
                break;
            }

            heap[index] = heap[largerChild];
            index = largerChild;
        }

        // put top at final index
        heap[index] = top;
    }

    public static void main(String[] args) {
        Heap heap = new Heap(10);
        heap.add(12);
        heap.add(2);
        heap.add(3);
        heap.add(5);
        heap.add(7);
        heap.add(4);
        heap.add(24);
        heap.add(9);
        heap.add(21);
        heap.add(20);
        System.out.println("heap : " + heap);
        System.out.println("heap.remove() : " + heap.remove());
        System.out.println("heap : " + heap);
    }

    @Override
    public String toString() {
        return Arrays.toString(heap);
    }
}