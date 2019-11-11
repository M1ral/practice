package interview.phone.twentyninteen.amazon;

import java.util.HashSet;
import java.util.Set;

public class UpdatePowerMinDaysAmazon {

    public static void main(String[] args) {
        System.out.println(countMinDays(new int[][]{
                {1, 0, 0, 1},
                {0, 1, 0, 0},
                {0, 0, 0, 0},
                {1, 0, 0, 0}
        }));
    }

    public static int countMinDays(int[][] grid) {
        if (null == grid || grid.length == 0) {
            return 0;
        }

        int m = grid.length, n = grid[0].length, days = 0;
        Set<String> set = new HashSet<>();
        boolean hasZeros = true;

        while (hasZeros) {
            hasZeros = false;
            days++;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    String index = i + "" + j;
                    if (grid[i][j] == 0 && (
                            (i > 0 && grid[i-1][j] == 1 && !set.contains((i-1) + "" + j)) ||
                            (i < m -1 && grid[i+1][j] == 1 && !set.contains((i+1) + "" + j)) ||
                            (j > 0 && grid[i][j-1] == 1 && !set.contains(i + "" + (j-1))) ||
                            (j < n - 1 && grid[i][j+1] == 1 && !set.contains(i + "" + (j+1)))
                    )) {
                        grid[i][j] = 1;
                        set.add(index);
                    }
                    if (grid[i][j] == 0) {
                        hasZeros = true;
                    }
                }
            }
            set.clear();
        }
        return days;
    }
}
