package leetcoce.matrix;

import java.util.Arrays;

public class SpiralOrder2 {

    public static void main(String[] args) {
        int[][] matrix = generateMatrix(3);
        for (int[] arr : matrix) {
            System.out.println(Arrays.toString(arr));
        }
    }

    public static int[][] generateMatrix(int n) {
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
