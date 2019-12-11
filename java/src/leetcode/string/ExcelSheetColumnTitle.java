package leetcode.string;

// https://leetcode.com/problems/excel-sheet-column-title/
public class ExcelSheetColumnTitle {

    public static void main(String[] args) {
        System.out.println("getCsvColumn(1) = " + getCsvColumnHeader(1));
        System.out.println("getCsvColumn(2) = " + getCsvColumnHeader(2));
        System.out.println("getCsvColumn(25) = " + getCsvColumnHeader(25));
        System.out.println("getCsvColumn(26) = " + getCsvColumnHeader(26));
        System.out.println("getCsvColumn(27) = " + getCsvColumnHeader(27));
        System.out.println("getCsvColumn(52) = " + getCsvColumnHeader(52));
        System.out.println("getCsvColumn(129) = " + getCsvColumnHeader(129));
        System.out.println("getCsvColumn(130) = " + getCsvColumnHeader(130));
        System.out.println("getCsvColumn(2600) = " + getCsvColumnHeader(2600));
    }

    private static final String SEED = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static String getCsvColumnHeader(int column) {
        if (column <= 0) {
            return null; // or throw exception
        }

        StringBuilder sb = new StringBuilder();

        while (column != 0) {
            int letter = column % 26;
            column = column / 26;
            if (letter == 0) {
                letter = 26;
                column -= 1;
            }
            sb.append(SEED.charAt(letter - 1));
        }
        return sb.reverse().toString();
    }
}
