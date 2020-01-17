package leetcode.dp.maximalsubsquare;

import java.util.Arrays;

public class MaximalSubRectangle {

    public static void main(String[] args) {
        System.out.println("getMaxRetangle(new char[][]{}) = " + getMaxRetangle(new char[][]{
                {'0', '1', '1', '1'},
                {'0', '1', '1', '1'},
                {'0', '1', '0', '1'}
        }));
    }

    public static int getMaxRetangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0)
            return 0;

        int m = matrix.length, n = matrix[0].length, maxArea = 0;
        int[] left = new int[n], right = new int[n], height = new int[n];
        Arrays.fill(right, n - 1);

        for (int i = 0; i < m; i++) {
            int lB = 0, rB = n - 1;

            // right to left, fill right[]
            for (int j = n - 1; j >= 0; j--) {
                if (matrix[i][j] == '1') {
                    right[j] = Math.min(right[j], rB);
                } else {
                    right[j] = n - 1;
                    rB = j - 1;
                }
            }

            // left to right, fill left[] and height[]
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    left[j] = Math.max(left[j], lB);
                    height[j]++;
                    maxArea = Math.max(maxArea, height[j] * (right[j] - left[j] + 1));
                } else {
                    height[j] = 0;
                    left[j] = 0;
                    lB = j + 1;
                }
            }
        }
        return maxArea;
    }

    //TODO - learn this
    public static int getMaxRectFromHistogram(int[] arr) {
        if (null == arr || arr.length == 0) {
            return 0;
        }
        return 0;
    }
}
