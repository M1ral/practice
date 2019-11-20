package leetcode.dp.maximalsubsquare;

public class MaximalSubSquare {

    public static void main(String[] args) {
        System.out.println("Max square : " + maximalSubSquare(new int[][]{
                {0, 0, 1, 1, 0},
                {1, 0, 1, 1, 1},
                {0, 1, 1, 1, 1},
                {1, 1, 1, 1, 0},
                {0, 1, 1, 1, 1}
        }));
    }

    public static int maximalSubSquare(int[][] matrix) {
        if (null == matrix || matrix.length == 0 ||
                null == matrix[0] || matrix[0].length == 0) {
            return 0;
        }

        int m = matrix.length, n = matrix[0].length, numSquares = 0;
        int[][] b = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (matrix[i - 1][j - 1] == 1) {
                    b[i][j] = Math.min(Math.min(b[i - 1][j - 1], b[i][j - 1]), b[i - 1][j]) + 1;
                    numSquares = Math.max(numSquares, b[i][j]);
                }
            }
        }

        return numSquares * numSquares;
    }
}
