package leetcode.matrix.iterator;

import leetcode.matrix.MatrixUtils;

import java.util.Iterator;

public class ColumnWiseIterator implements Iterator {

    public static void main(String[] args) {
        int[][] matrix = MatrixUtils.generateMatrix(3, 3);
        MatrixUtils.print2D(matrix);

        ColumnWiseIterator iterator = new ColumnWiseIterator(matrix);
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
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
    }

    private int[][] matrix;
    private int rows, cols, i, j;

    public ColumnWiseIterator(int[][] matrix) {
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

        if (i < rows) {
            i++;
            if (i == rows) {
                j++;
                i = 0;
            }
        }
        return res;
    }
}
