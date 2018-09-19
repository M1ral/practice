package dynamicpogramming;

import java.util.Arrays;

public class RotateImage {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
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
                for (int j = 0; j < n; j++) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[n - 1 - i][j];
                    matrix[n - 1 - i][j] = temp;
                }
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
                    matrix[i][j] = matrix[i][n-1-j];
                    matrix[i][n-1-j] = temp;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j > i) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
        }

        // CTCI solutuion -

        /*for (int layer = 0; layer < n/2; layer++) {
            int first = layer;
            int last = n - 1 - layer;

            for (int j = first; j < last; j++) {
                int offset = j - first;
                // save top
                int top = matrix[first][j];

                // left > top
                matrix[first][j] = matrix[last-offset][first];

                // bottom > left
                matrix[last-offset][first] = matrix[last][last-offset];

                // right > bottom
                matrix[last][last-offset] = matrix[j][last];

                // top > right
                matrix[j][last] = top;
            }
        }*/
    }
}
