package programcreek.matrix;

import java.util.Arrays;

public class DiagonalTraversal {

    public static void main(String[] args) {

        // watch this video that explains the code
        // https://www.youtube.com/watch?v=T8ErAYobcbc
        diagonalTraversal(new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        });
    }

    // at any given element (i,j), next element is (i-1, j+1)
    public static void diagonalTraversal(int[][] matrix) {
        if (null == matrix || matrix.length == 0) {
            return;
        }

        int m = matrix.length, n = matrix[0].length;

        for (int k = 0; k < m; k++) {
            int i = k;
            int j = 0;
            while (i >= 0) {
                System.out.println(matrix[i][j]);
                i = i-1;
                j = j+1;
            }
        }

        for (int k = 1; k < n; k++) {
            int i = m-1;
            int j = k;
            while (j <= n-1) {
                System.out.println(matrix[i][j]);
                i = i-1;
                j = j+1;
            }
        }

        print2D(matrix);
    }

    // print 2D matrix
    public static void print2D(int mat[][]) {
        for (int[] row : mat)
            System.out.println(Arrays.toString(row));
    }
}
