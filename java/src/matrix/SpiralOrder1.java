package matrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrder1 {

    public static void main(String[] args) {
        System.out.println("spiralOrder(new int[][]{{1,2,3},{8,9,4},{7,6,5}}) = " +
                spiralOrder(new int[][]{{1, 2, 3}, {8, 9, 4}, {7, 6, 5}}));
    }

    /**
     * Print matrix in spiral order
     *
     * @param matrix
     * @return List
     */
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList();
        if (null == matrix || matrix.length == 0) {
            return list;
        }

        int m = matrix.length;
        int n = matrix[0].length;

        int top = 0, bottom = m - 1, left = 0, right = n - 1;

        while (list.size() < m * n) {
            for (int j = left; j <= right; j++)
                list.add(matrix[top][j]);
            top++;

            for (int i = top; i <= bottom; i++)
                list.add(matrix[i][right]);
            right--;

            // avoid duplicate row
            if (bottom < top) break;

            for (int j = right; j >= left; j--)
                list.add(matrix[bottom][j]);
            bottom--;

            // avoid duplicate column
            if (right < left) break;

            for (int i = bottom; i >= top; i--)
                list.add(matrix[i][left]);
            left++;
        }
        return list;
    }
}
