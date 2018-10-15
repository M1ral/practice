package specials;

public class Sudoku {

    public static void main(String[] args) {
        System.out.println("isValid(new char[][]{}) = " + isValid(new char[][]{
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}
        }));
    }

    public static boolean isValid(char[][] board) {
        if (board == null || board.length == 0) {
            return false;
        }

        short[] rows = new short[9];
        short[] cols = new short[9];
        short[] squares = new short[9];

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (board[row][col] == '.')
                    continue;

                short value = (short) (1 << (board[row][col] - '1'));

                if ((value & rows[row]) > 0) return false;
                if ((value & cols[col]) > 0) return false;
                if ((value & squares[3*(row/3) + (col/3)]) > 0) return false;

                rows[row] |= value;
                cols[col] |= value;
                squares[3*(row/3) + (col/3)] |= value;
            }
        }
        return true;
    }
}
