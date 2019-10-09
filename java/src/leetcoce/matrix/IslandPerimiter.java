package leetcoce.matrix;

public class IslandPerimiter {

    /**
     * Return the perimiter of the island
     *
     * perimiter = 4*islands - 2*neighbors
     * @param grid
     * @return int
     */
    public static int islandPerimeter(int[][] grid) {
        if (null == grid || grid.length == 0) {
            return 0;
        }
        int islands = 0;
        int neighbours = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    islands++; // count islands
                    if (i < grid.length - 1 && grid[i + 1][j] == 1) neighbours++; // count down neighbours
                    if (j < grid[i].length - 1 && grid[i][j + 1] == 1) neighbours++; // count right neighbours
                }
            }
        }

        return (islands * 4 ) - (neighbours * 2);
    }
}
