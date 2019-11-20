package leetcode.matrix.search;

public class Search2DMatrixII {
    public static void main(String[] args) {
        System.out.println(search2(new int[][]{
                {1, 6, 11, 16, 21},
                {2, 7, 12, 17, 22},
                {3, 8, 13, 18, 23},
                {4, 9, 14, 19, 24},
                {5, 10, 15, 20, 25}

        }, 24));
    }

    // https://www.youtube.com/watch?v=dsPdwhRR_84
    public static boolean search2(int[][] matrix, int target) {
        if (null == matrix || matrix.length == 0 || null == matrix[0]) {
            return false;
        }

        int m = matrix.length, n = matrix[0].length;
        int i = m-1, j = 0;

        while (i >= 0 && j < n) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] < target) {
                j++;
            } else {
                i--;
            }
        }

        return false;
    }
}
