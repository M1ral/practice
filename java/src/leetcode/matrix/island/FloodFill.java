package leetcode.matrix.island;

import java.util.Arrays;

// https://leetcode.com/problems/flood-fill/
public class FloodFill {

    public static void main(String[] args) {
        int[][] image = new int[][]{
                {1, 1, 1},
                {1, 1, 0},
                {1, 0, 1}
        };

        floodFill(image, 1, 1, 2);
        System.out.println("image = " + Arrays.deepToString(image));
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (null == image || image.length == 0 || sr < 0 || sc < 0) {
            return image;
        }
        if (image[sr][sc] == newColor) {
            return image;
        }

        fill(image, sr, sc, image[sr][sc], newColor);
        return image;
    }

    private static void fill(int[][] image, int i, int j, int color, int newColor) {
        if (i < 0 || i >= image.length ||
                j < 0 || j >= image[0].length ||
                image[i][j] != color) {
            return;
        }

        image[i][j] = newColor;

        fill(image, i+1, j, color, newColor);
        fill(image, i-1, j, color, newColor);
        fill(image, i, j+1, color, newColor);
        fill(image, i, j-1, color, newColor);
    }
}
