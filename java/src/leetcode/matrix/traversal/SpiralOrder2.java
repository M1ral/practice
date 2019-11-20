package leetcode.matrix.traversal;

import static leetcode.matrix.MatrixUtils.print2D;

public class SpiralOrder2 {

    public static void main(String[] args) {
        int[][] matrix = generateSpiralMatrix(3);
        print2D(matrix);
    }

    public static int[][] generateSpiralMatrix(int n) {
        if (n < 1) {
            return new int[0][0];
        }

        int[][] matrix = new int[n][n];
        int top = 0, left = 0, bottom = n-1, right = n-1;
        int count = 0;

        while (count < n*n) {
            for (int j = left; j <= right; j++)
                matrix[top][j] = ++count;
            top++;

            for (int i = top; i <= bottom; i++)
                matrix[i][right] = ++count;
            right--;

            // duplicate row
            if (bottom < top) break;

            for (int j = right; j >= left; j--)
                matrix[bottom][j] = ++count;
            bottom--;

            // duplicate column
            if (right < left) break;

            for (int i = bottom; i >= top; i--)
                matrix[i][left] = ++count;
            left++;
        }
        return matrix;
    }
}
