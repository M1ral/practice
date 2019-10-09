package leetcoce.array;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class VtArrayIterator<T> implements Iterator<T> {

    private T[][] data;
    private int i;
    private int j;

    public VtArrayIterator(T[][] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        return i < data.length && j < data[i].length;
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException("No more elements!");
        }

        T val = data[i][j];
        moveNext();
        return val;
    }

    private void moveNext() {
        i++;
        if (i >= data.length) {
            moveToFirstRow();
        }
        if (i < data.length && j >= data[i].length) {
            moveNext();
        }
    }

    private void moveToFirstRow() {
        i = 0;
        j++; // move to next column
    }
}

class Solution {
    public static void main(String[] args) {
        VtArrayIterator<Integer> iterator = new VtArrayIterator<>(new Integer[][]{{1,4,6},{2},{3,5,7,8}});

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
