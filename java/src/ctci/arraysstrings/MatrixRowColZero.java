package ctci.arraysstrings;

import java.util.Arrays;

public class MatrixRowColZero {

    public static void main(String[] args) {
        setZeros(new int[][]{
                {0, 1, 2},
                {3, 4, 5},
                {6, 7, 8}
        });
    }

    public static void setZeros(int[][] matrix) {
        if (null == matrix || matrix.length == 0) {
            return;
        }

        int n = matrix.length;
        boolean[] rows = new boolean[n];
        boolean[] cols = new boolean[n];

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (matrix[row][col] == 0) {
                    rows[row] = true;
                    cols[col] = true;
                }
            }
        }

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (rows[row] || cols[col]) {
                    matrix[row][col] = 0;
                }
            }
        }

        System.out.println(Arrays.deepToString(matrix));
    }
}
