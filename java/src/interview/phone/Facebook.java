package interview.phone;

/**
 * August 2018
 *
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
                getNumberOfOnesInSubMatrix(
                        new int[][]{
                                {1, 2, 3},
                                {4, 5, 6},
                                {7, 8, 9}},
                        new int[]{1, 1},
                        new int[]{2, 2}));

        System.out.println("Number of 1's in sub-matrix (with pre-process):" +
                getSumWithPreProcessOnMatrix(
                        new int[][]{
                                {1, 2, 3},
                                {4, 5, 6},
                                {7, 8, 9}},
                        new int[]{1, 1},
                        new int[]{2, 2}));
    }

    /**
     * Count number of 1's in given matrix
     *
     * @param matrix
     * @param topLeft
     * @param bottomRight
     * @return int
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
    }

    public static int getSumWithPreProcessOnMatrix(int[][] matrix, int[] top, int[] bottom) {
        if (null == matrix || matrix.length == 0) {
            return 0;
        }
        if (null == top || top.length < 2 || null == bottom || bottom.length < 2) {
            return 0;
        }

        // preprocess the matrix and run SAT algorithm - sum at each element in the matrix
        matrix = fillWithSum(matrix);
        int topI = top[0];
        int topJ = top[1];
        int botI = bottom[0];
        int botJ = bottom[1];

        return matrix[botI][botJ]
                + matrix[topI-1][topJ-1]
                - matrix[topI -1][botJ]
                - matrix[botI][topJ - 1];
    }

    /**
     * Fill each element in the matrix with sumSoFar (sum up to that point)
     *
     * @param matrix
     */
    private static int[][] fillWithSum(int[][] matrix) {
        if (null == matrix || matrix.length == 0) {
            return null;
        }

        int M = matrix.length;
        int N = matrix[0].length;

        // fill matrix such that at given [i,j] it carries the sum from [0,0] to [i,j];
        int aux[][] = new int[M][N];

        // 1 2 3
        // 4 5 6
        // 7 8 9

        // 1. copy first row of matrix to aux
        for (int i = 0; i < N; i++) {
            aux[0][i] = matrix[0][i];
        }
        // after 1,
        // 1 2 3
        // 0 0 0
        // 0 0 0

        // 2. Do column wise sum
        for (int i = 1; i < M; i++) {
            for (int j = 0; j < N; j++) {
                aux[i][j] = matrix[i][j] + aux[i-1][j]; // column wise sum
            }
        }
        // after 2,
        // 1  2  3
        // 5  7  9
        // 12 15 18

        // 3. Do row wise sum
        for (int i = 0; i < M; i++) {
            for (int j = 1; j < N; j++) {
                aux[i][j] += aux[i][j-1];
            }
        }
        // after 3,
        // 1   3    6
        // 5   12   21
        // 12  27   45

        // sum between [1,1] to [2,2] = 45 + 1 - 12 - 6 = 46 - 18 = 28
        return aux;
    }
}
