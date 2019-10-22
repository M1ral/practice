package leetcode.matrix;

import static leetcode.matrix.MatrixUtils.generateMatrix;
import static leetcode.matrix.MatrixUtils.print2D;

public class RotateImage {

    public static void main(String[] args) {
        int[][] matrix = generateMatrix(3, 3);

        System.out.println("MATRIX");
        print2D(matrix);

        System.out.println("\nCLOCKWISE ROTATION:");
        // clockwise
        rotate(matrix, true);
        print2D(matrix);

        System.out.println("\nRESTORING MATRIX BY COUNTER-CLOCKWISE ROTATION:");
        // anti-clock wise
        rotate(matrix, false);
        print2D(matrix);

        System.out.println("\nCTCI ROTATION");
        rotateCTCI(matrix);
        print2D(matrix);
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
        for (int layer = 0; layer < N / 2; layer++) {
            // Consider elements in group of 4 in current square
            for (int j = layer; j < N - layer - 1; j++) {
                // store current cell in temp variable
                int temp = matrix[layer][j];
                // move values from right to top
                matrix[layer][j] = matrix[j][N - 1 - layer];
                // move values from bottom to right
                matrix[j][N - 1 - layer] = matrix[N - 1 - layer][N - 1 - j];
                // move values from left to bottom
                matrix[N - 1 - layer][N - 1 - j] = matrix[N - 1 - j][layer];
                // assign temp to left
                matrix[N - 1 - j][layer] = temp;
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
                matrix[i] = matrix[n - 1 - i];
                matrix[n - 1 - i] = temp;
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
