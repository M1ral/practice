package interview.phone;

/**
 * Given M*N matrix
 * 1 0 0 0 1
 * 0 0 0 1 0
 * 0 0 0 0 0
 * 1 1 0 1 1
 * <p>
 * 1. Given two coordinates - top left and bottom right, find the count of 1's in that sub matrix.
 * Time - O(M*N), Space - O(1)
 * 2. If pre-processing is allowed, then what can be done to improve on time, if we can trade with space
 */
public class Facebook {
    public static void main(String[] args) {
        System.out.println("Number of 1's in sub-matrix:" +
                getNumberOfOnesInSubMatrix(new int[][]{{1, 0, 0, 1}, {0, 0, 0, 1}, {1, 1, 1, 1}},
                        new int[]{1, 1},
                        new int[]{2, 2}));
    }

    /**
     * Count number of 1's in given matrix
     * @param matrix
     * @param topLeft
     * @param bottomRight
     * @return
     */
    public static int getNumberOfOnesInSubMatrix(int[][] matrix, int[] topLeft, int[] bottomRight) {
        if (null == matrix || matrix.length == 0) {
            return -1;
        }
        if (null == topLeft || topLeft.length == 0 || null == bottomRight || bottomRight.length == 0) {
            return -1;
        }
        if (topLeft.length > 2 || bottomRight.length > 2) {
            return -1;
        }

        int topRow = topLeft[0];
        int topCol = topLeft[1];
        int bottomRow = bottomRight[0];
        int bottomCol = bottomRight[1];

        if (topRow > bottomRow || topCol > bottomCol) {
            return -1;
        }

        int count = 0;
        for (int i = topRow; i <= bottomCol; i++) {
            for (int j = topRow; j <= bottomCol; j++) {
                count += matrix[i][j];
            }
        }

        return count;
        // pre-process the matrix
        /*fillWithSum(matrix);

        int topSum = matrix[topRow][topCol];
        int bottomSum = matrix[bottomRow][bottomCol];

        return bottomSum - topSum;*/
    }

    /**
     * Fill each element in the matrix with sumSoFar (sum up to that point)
     * @param matrix
     */
    private static void fillWithSum(int[][] matrix) {
        if (null == matrix || matrix.length == 0) {
            return;
        }

        int sumSoFar = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                sumSoFar += matrix[row][col];
                matrix[row][col] = sumSoFar;
            }
        }
    }
}
