package leetcode.matrix.rotateflip;

import java.util.Arrays;

import static leetcode.matrix.MatrixUtils.generateMatrix;

public class RotateMatrix {

    public static void main(String[] args) {
        int[][] matrix = generateMatrix(3, 3);
        System.out.println("original: " + Arrays.deepToString(matrix));
        rotateInPlace(matrix, true);
        System.out.println("in place clockwise: " + Arrays.deepToString(matrix));
        rotateInPlace(matrix, false);
        System.out.println("in place counter clockwise: " + Arrays.deepToString(matrix));
        rotate(matrix, false);
        System.out.println("counter clockwise: " + Arrays.deepToString(matrix));
        rotate(matrix, true);
        System.out.println("clockwise: " + Arrays.deepToString(matrix));
    }

    // Rotate matrix by 90 degrees
    public static void rotateInPlace(int[][] matrix, boolean clockwise) {
        if (null == matrix || matrix.length == 0) {
            return;
        }

        int n = matrix.length;
        for (int layer = 0; layer < n / 2; layer++) {
            for (int j = layer; j < n - 1 - layer; j++) {
                int temp = matrix[layer][j];
                if (clockwise) {
                    matrix[layer][j] = matrix[n - 1 - j][layer];
                    matrix[n - 1 - j][layer] = matrix[n - 1 - layer][n - 1 - j];
                    matrix[n - 1 - layer][n - 1 - j] = matrix[j][n - 1 - layer];
                    matrix[j][n - 1 - layer] = temp;
                } else {
                    matrix[layer][j] = matrix[j][n - 1 - layer];
                    matrix[j][n - 1 - layer] = matrix[n - 1 - layer][n - 1 - j];
                    matrix[n - 1 - layer][n - 1 - j] = matrix[n - 1 - j][layer];
                    matrix[n - 1 - j][layer] = temp;
                }
            }
        }
    }

    public static void rotate(int[][] matrix, boolean clockwise) {
        if (null == matrix || matrix.length == 0) {
            return;
        }

        int n = matrix.length;
        if (clockwise) {
            for (int i = 0; i < n / 2; i++) {
                int[] temp = matrix[i];
                matrix[i] = matrix[n - 1 - i];
                matrix[n - 1 - i] = temp;
            }
        } else {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n / 2; j++) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[i][n - 1 - j];
                    matrix[i][n - 1 - j] = temp;
                }
            }
        }

        // swap diagonally
        for (int i = 0; i < n; i++) {
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
