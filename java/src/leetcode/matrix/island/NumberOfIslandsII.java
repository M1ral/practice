package leetcode.matrix.island;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// https://leetcode.com/problems/number-of-islands-ii/
public class NumberOfIslandsII {

    public static void main(String[] args) {
        System.out.println("numIslands2(3, 3, {{0,0}, {0,1}, {1,2}, {2,1}}) = " +
                numIslands2(3, 3, new int[][]{{0, 0}, {0, 1}, {1, 2}, {2, 1}}));
    }

    public static List<Integer> numIslands2(int m, int n, int[][] positions) {
        if (m < 0 || n < 0) {
            return Collections.emptyList();
        }

        List<Integer> list = new ArrayList();
        int[][] grid = new int[m][n];

        for (int[] p : positions) {
            grid[p[0]][p[1]] = 1;
            int[][] copy = Arrays.stream(grid).map(int[]::clone).toArray(int[][]::new);
            int count = 0;

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 1) {
                        visitIsland(i, j, grid);
                        count++;
                    }
                }
            }
            list.add(count);
            grid = copy;
        }

        return list;
    }

    private static void visitIsland(int i, int j, int[][] grid) {
        if (i < 0 || i >= grid.length ||
                j < 0 || j >= grid[0].length ||
                grid[i][j] != 1) {
            return;
        }

        grid[i][j] = -1;

        visitIsland(i + 1, j, grid);
        visitIsland(i - 1, j, grid);
        visitIsland(i, j + 1, grid);
        visitIsland(i, j - 1, grid);
    }
}
