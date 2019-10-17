package programcreek.matrix;

public class WordSearch {

    public static void main(String[] args) {
        System.out.println(hasWord("Miral", new char[][]{
                {'a', 'b', 'c', 'd'},
                {'i', 'm', 'n', 'o'},
                {'j', 'i', 'r', 'a'},
                {'d', 'e', 'f', 'l'}
        }));
    }

    public static boolean hasWord(String word, char[][] grid) {
        if (null == grid || grid.length == 0 ||
            null == grid[0] || grid[0].length == 0 ||
            null == word || word.isEmpty()) {
            return false;
        }

        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == word.charAt(0) && search(grid, word, i, j, 0)) {
                        return true;
                }
            }
        }

        return false;
    }

    public static boolean search(char[][] grid, String word, int i, int j, int k) {
        if (k == word.length()) {
            return true;
        }

        if (i < 0 || i >= grid.length ||
            j < 0 || j >= grid[0].length || grid[i][j] != word.charAt(k)) {
            return false;
        }

        char temp = grid[i][j];
        grid[i][j] = '#';
        if (search(grid, word, i-1, j, k+1) ||
            search(grid, word, i+1, j, k+1) ||
            search(grid, word, i, j-1, k+1) ||
            search(grid, word, i, j+1, k+1)) {
            return true;
        }
        grid[i][j] = temp;
        return false;
    }
}
