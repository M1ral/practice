package interview.phone.walmartlabs;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Find number of ways you can reach to bottom right from top left
 *
 * 1 1 0
 * 0 1 1
 * 1 1 1
 *
 * result
 */
public class NumberOfUniquePaths {
    public static void main(String[] args) {
        System.out.println("Unique paths = " + findUniquePaths(new int[][]{
                {1, 1, 0},
                {0, 1, 1},
                {1, 1, 1}
        }));
    }

    // number of ways we can reach to bottom right from top left
    // can only travel right or bottom if there is 1
    public static int findUniquePaths(int[][] grid) {
        if (null == grid || grid.length == 0 || null == grid[0]) {
            return 0;
        }

        if (grid[0][0] == 0) {
            return 0;
        }

        int count = 0, m = grid.length, n = grid[0].length;
        Deque<Point> stack = new ArrayDeque<>();
        stack.push(new Point(0, 0));

        while (! stack.isEmpty()) {
            Point point = stack.pop();
            if (point.row == (m-1) && point.col == (n-1)) {
                count++;
                continue;
            }

            // right
            if (point.right().isValid(m, n) && point.right().value(grid) == 1) {
                stack.push(point.right());
            }
            // bottom
            if (point.bottom().isValid(m, n) && point.bottom().value(grid) == 1) {
                stack.push(point.bottom());
            }
        }

        return count;
    }
}

class Point {
    int row;
    int col;

    public Point(int r, int c) {
        this.row = r;
        this.col = c;
    }

    public Point right() {
        return new Point(this.row, this.col + 1);
    }

    public Point bottom() {
        return new Point(this.row + 1, this.col);
    }

    public boolean isValid(int m, int n) {
        return this.row < m && this.col < n;
    }

    public int value(int[][] grid) {
        if (this.isValid(grid.length, grid[0].length)) {
            return grid[row][col];
        }
        return -1;
    }
}
