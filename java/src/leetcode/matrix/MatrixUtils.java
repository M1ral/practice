package leetcode.matrix;

import java.util.Arrays;

public class MatrixUtils {

    public static int[][] generateMatrix(int rows, int colums) {
        if (rows < 0 || colums < 0) {
            return new int[][]{{}};
        }

        int[][] matrix = new int[rows][colums];
        int element = 1;
        for (int row=0; row < rows; row++) {
            for (int col=0; col < colums; col++) {
                matrix[row][col] = element;
                element++;
            }
        }

        return matrix;
    }
    // print 2D matrix
    public static void print2D(int mat[][]) {
        for (int[] row : mat)
            System.out.println(Arrays.toString(row));
    }
}
