package programcreek.matrix;

public class UniquePathsII {

    public static void main(String[] args) {
        int[][] obstagleGrid = new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };
        System.out.println(uniquePathsWithObstacles(obstagleGrid));
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (null == obstacleGrid || obstacleGrid.length == 0 ||
                null == obstacleGrid[0] || obstacleGrid[0].length == 0) {
            return 0;
        }

        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1) {
            return 0;
        }

        int[][] dp = new int[m][n];

        // first column
        for (int i = 1; i < m; i++) {
            dp[i][0] = obstacleGrid[i][0] == 1 ? 0 : 1;
        }

        // top row
        for (int j = 1; j < n; j++) {
            dp[0][j] = obstacleGrid[0][j] == 1 ? 0 : 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = obstacleGrid[i][j] == 1
                        ? 0
                        : dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];
    }
}
