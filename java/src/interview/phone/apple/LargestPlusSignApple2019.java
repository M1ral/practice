package interview.phone.apple;

public class LargestPlusSignApple2019 {

    public static void main(String[] args) {
        System.out.println(getLengthOfLargestPlusSign(new int[][] {
                {0,0,0,0,1,0},
                {0,0,1,0,0,1},
                {0,0,1,0,0,1},
                {1,1,1,1,1,1},
                {0,0,1,0,0,1},
                {0,0,1,0,0,0}
        }));
    }

    private static int getLengthOfLargestPlusSign(int[][] grid) {
        if (null == grid || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int maxLength = Integer.MIN_VALUE;
        int gridLength = grid.length;

        for (int row = 1; row < grid.length; row++) {
            for (int col = 1; col < grid[0].length; col++) {
                if (grid[row][col] == 1) {
                    int dir = 1;
                    int length = 0;

                    while((row + dir) < gridLength && grid[row+dir][col] == 1
                            && (row - dir) >= 0 && grid[row-dir][col] == 1
                            && (col + dir) < gridLength && grid[row][col+dir] == 1
                            && (col - dir) >= 0 && grid[row][col-dir] == 1) {
                        dir++;
                        length++;
                    }
                    maxLength = Math.max(length, maxLength);
                }
            }
        }

        return maxLength;
    }
}

