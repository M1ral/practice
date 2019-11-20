package leetcode.matrix.traversal;

import static leetcode.matrix.MatrixUtils.generateMatrix;
import static leetcode.matrix.MatrixUtils.print2D;

public class DiagonalTraversal {

    public static void main(String[] args) {

        // watch this video that explains the code
        // https://www.youtube.com/watch?v=T8ErAYobcbc
        diagonalTraversal(generateMatrix(4, 4));
    }

    // at any given element (i,j), next element is (i-1, j+1)
    public static void diagonalTraversal(int[][] matrix) {
        if (null == matrix || matrix.length == 0) {
            return;
        }

        print2D(matrix);
        int m = matrix.length, n = matrix[0].length;

        for (int k = 0; k < m; k++) {
            int i = k;
            int j = 0;
            while (i >= 0) {
                System.out.println(matrix[i][j]);
                i = i - 1;
                j = j + 1;
            }
        }

        for (int k = 1; k < n; k++) {
            int i = m - 1;
            int j = k;
            while (j <= n - 1) {
                System.out.println(matrix[i][j]);
                i = i - 1;
                j = j + 1;
            }
        }
    }
}
