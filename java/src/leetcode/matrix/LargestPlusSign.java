package leetcode.matrix;

public class LargestPlusSign {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {0, 0, 0, 0, 1, 0},
                {0, 0, 1, 0, 0, 1},
                {0, 0, 1, 0, 0, 1},
                {1, 1, 1, 1, 1, 1},
                {0, 0, 1, 0, 0, 1},
                {0, 0, 1, 0, 0, 0}
        };

        System.out.println("order: "+ orderOfLargestPlusSign(2, new int[][]{}));
    }

    public static int orderOfLargestPlusSign(int N, int[][] mines) {
        if (N < 0) {
            return 0;
        }

        int[][] grid = new int[N][N];
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                grid[i][j] = 1;
            }
        }

        if (null != mines && mines.length != 0)
            for (int[] mine: mines)
                grid[mine[0]][mine[1]] = 0;

        int order = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 1) {
                    int dir = 1;
                    int length = 1;

                    while ((i+dir) < N && grid[i+dir][j] == 1 &&
                            (i-dir) >= 0 && grid[i-dir][j] == 1 &&
                            (j+dir) < N && grid[i][j+dir] == 1 &&
                            (j-dir) >= 0 && grid[i][j-dir] == 1) {
                        dir++;
                        length++;
                    }
                    order = Math.max(order, length);
                }
            }
        }

        return order;
    }
}
