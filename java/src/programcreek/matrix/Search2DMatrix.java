package programcreek.matrix;

import static leetcoce.matrix.MatrixUtils.generateMatrix;

public class Search2DMatrix {

    public static void main(String[] args) {
        System.out.println(search(generateMatrix(10, 10), 82));
    }

    // https://www.youtube.com/watch?v=dsPdwhRR_84
    public static boolean search(int[][] matrix, int target) {
        if (null == matrix || matrix.length == 0 || null == matrix[0]) {
            return false;
        }

        int m = matrix.length, n = matrix[0].length;
        int i = 0, j = n-1;

        while (j >= 0 && i < m) {
            if (target == matrix[i][j]) {
                return true;
            } else if (matrix[i][j] > target) {
                j--;
            } else {
                i++;
            }
        }

        return false;
    }
}
