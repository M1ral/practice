package leetcoce.matrix;

import java.util.Arrays;

public class RotateImage {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        System.out.println("MATRIX");
        for (int[] arr : matrix) {
            System.out.println("[" + Arrays.toString(arr) + "]");
        }

        System.out.println("\nCLOCKWISE ROTATION:");
        // clockwise
        rotate(matrix, true);
        for (int[] arr : matrix) {
            System.out.println("[" + Arrays.toString(arr) + "]");
        }

        System.out.println("\nRESTORING MATRIX BY COUNTER-CLOCKWISE ROTATION:");
        // anti-clock wise
        rotate(matrix, false);
        for (int[] arr : matrix) {
            System.out.println("[" + Arrays.toString(arr) + "]");
        }

        System.out.println("CTCI ROTATION");
        rotateCTCI(matrix);
        for (int[] arr : matrix) {
            System.out.println("[" + Arrays.toString(arr) + "]");
        }
    }

    /**
     * Rotate leetcoce.matrix in place (as per CTCI)
     *
     * @param matrix
     */
    public static void rotateCTCI(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }

        int N = matrix.length;
        for (int i = 0; i < N / 2; i++) {
            // Consider elements in group of 4 in current square
            for (int j = i; j < N - i - 1; j++) {
                // store current cell in temp variable
                int temp = matrix[i][j];

                // move values from right to top
                matrix[i][j] = matrix[j][N - 1 - i];

                // move values from bottom to right
                matrix[j][N - 1 - i] = matrix[N - 1 - i][N - 1 - j];

                // move values from left to bottom
                matrix[N - 1 - i][N - 1 - j] = matrix[N - 1 - j][i];

                // assign temp to left
                matrix[N - 1 - j][i] = temp;
            }
        }
    }

    public static void rotate(int[][] matrix, boolean clockwise) {
        if (matrix == null || matrix.length == 0) {
            return;
        }

        int n = matrix.length;
        if (clockwise) {
            // clockwise rotation
            // First flip up and down, then swap the symmetry elements
            // 1 2 3       7 8 9       7 4 1
            // 4 5 6  =>   4 5 6  =>   8 5 2
            // 7 8 9       1 2 3       9 6 3
            for (int i = 0; i < n / 2; i++) {
                int[] temp = matrix[i];
                matrix[i] = matrix[n-1-i];
                matrix[n-1-i] = temp;
            }
        } else {
            // Counterclockwise rotation
            // First flip left and right, then press the symmetrical element to exchange
            // 1 2 3       3 2 1       3 6 9
            // 4 5 6  =>   6 5 4  =>   2 5 8
            // 7 8 9       9 8 7       1 4 7
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n / 2; j++) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[i][n - 1 - j];
                    matrix[i][n - 1 - j] = temp;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            // start from the point after (i = j)
            for (int j = i + 1; j < n; j++) {
                if (j > i) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
        }
    }
}
