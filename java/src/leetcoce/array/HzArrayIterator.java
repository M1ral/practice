package leetcoce.array;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class HzArrayIterator<T> implements Iterator<T> {

    private T[][] data;
    int i = 0;
    int j = 0;

    public HzArrayIterator(T[][] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        return i < data.length && j < data[i].length;
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException("Element not found in leetcoce.array at i = " + i + ", j = " + j);
        }
        T val = data[i][j];
        moveNext();
        return val;
    }

    private void moveNext() {
        j++;
        if (j >= data[i].length) {
            moveToNextRow();
        }
    }

    private void moveToNextRow() {
        i++;
        j = 0;
    }
}

class Solutuon {
    public static void main(String[] args) {
        HzArrayIterator<Integer> iterator = new HzArrayIterator(new Integer[][]{{1,2,3},{4},{5,6}});
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}


