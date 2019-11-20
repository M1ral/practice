package leetcode.matrix.iterator;

import leetcode.matrix.MatrixUtils;

import java.util.Iterator;

public class RowWiseIterator implements Iterator {

    public static void main(String[] args) {
        int[][] matrix = MatrixUtils.generateMatrix(3, 3);
        RowWiseIterator iterator = new RowWiseIterator(matrix);
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
    }

    private int[][] matrix;
    private int rows, cols, i, j;

    public RowWiseIterator(int[][] matrix) {
        this.matrix = matrix;
        rows = matrix.length;
        cols = matrix[0].length;
        i = 0;
        j = 0;
    }

    @Override
    public boolean hasNext() {
        return (i < rows) && (j < cols);
    }

    @Override
    public Object next() {
        if (!hasNext()) {
            return null;
        }

        int res = matrix[i][j];

        if (j < cols) {
            j++;
            if (j == cols) {
                i++;
                j = 0;
            }
        }
        return res;
    }
}
