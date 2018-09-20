package dynamicpogramming;

import java.util.HashMap;
import java.util.Map;

public class NumberOfIslands {

    public static void main(String[] args) {
        System.out.println("numIslands = " + numIslands(
                new char[][]{{'1', '1', '1'}, {'1', '0', '0'}, {'1', '0', '1'}}));

        Map<Character, Integer> map = getIslandsByCount(new char[][]{{'a', 'a', 'b'}, {'a', 'b', 'b'}, {'a', 'b', 'c'}});
        map.forEach((k, v) -> System.out.println((k + ":" + v)));
    }

    /**
     * Input:
     * 11000
     * 11000
     * 00100
     * 00011
     *
     * Output: 3
     *
     * @param grid
     * @return int
     */
    public static int numIslands(char[][] grid) {
        if (null == grid || grid.length == 0) {
            return 0;
        }

        int count = 0;
        int rowLength = grid.length;
        int colLength = grid[0].length;

        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                if (grid[i][j] == '1') {
                    check(grid, i, j);
                    ++count;
                }
            }
        }

        return count;
    }

    public static void check(char[][] grid, int i, int j) {
        if (i >= grid.length || i < 0 || j >= grid[0].length || j < 0 || grid[i][j] != '1') {
            return;
        }

        grid[i][j] = 'X';
        check(grid, i+1, j);
        check(grid, i-1, j);
        check(grid, i, j+1);
        check(grid, i, j-1);
    }

    /**
     * Input:
     * a a b
     * a b b
     * a b c
     *
     * Output:
     * a : 4
     * b : 4
     * c : 1
     *
     * @param grid
     * @return int
     */
    public static Map<Character, Integer> getIslandsByCount(char[][] grid) {
        Map<Character, Integer> map = new HashMap<>();
        if (null == grid || grid.length == 0) {
            return map;
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != '*' && !map.containsKey(grid[i][j])) {
                    map.put(grid[i][j], 0);
                    fillMap(grid, i, j, map, grid[i][j]);
                }
            }
        }
        return map;
    }

    public static void fillMap(char[][] grid, int i, int j, Map<Character, Integer> map, char c) {
        if (i >= grid.length || i < 0 || j >= grid[0].length || j < 0 || grid[i][j] != c) {
            return;
        }

        int count = map.get(c);
        map.put(c, count + 1);

        grid[i][j] = '*';
        fillMap(grid, i+1, j, map, c);
        fillMap(grid, i-1, j, map, c);
        fillMap(grid, i, j+1, map, c);
        fillMap(grid, i, j-1, map, c);
    }
}
