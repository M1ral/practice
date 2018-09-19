package dynamicpogramming;

import java.util.Arrays;

public class SetZerosIn2dMatrix {


    //
    public static void main(String args[]) {
        int[][] matrix = new int[][]{{0,4,5,0},{1,2,3,2},{2,3,1,3}};
        setZeroes(matrix);

        for (int[] arr : matrix) {
            System.out.println("[" + Arrays.toString(arr) + "]");
        }
    }

    /**
     * https://leetcode.com/problems/set-matrix-zeroes/description/
     *
     * Input:
     * [
     *   [0,1,2,0],
     *   [3,4,5,2],
     *   [1,3,1,5]
     * ]
     * Output:
     * [
     *   [0,0,0,0],
     *   [0,4,5,0],
     *   [0,3,1,0]
     * ]
     *
     * @param matrix
     */
    public static void setZeroes(int[][] matrix) {
        if (null == matrix || matrix.length == 0) {
            return;
        }

        boolean[] rows = new boolean[matrix.length];
        boolean[] cols = new boolean[matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    rows[i] = true;
                    cols[j] = true;
                }
            }
        }

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (rows[row] || cols[col]) {
                    matrix[row][col] = 0;
                }
            }
        }
    }
}
