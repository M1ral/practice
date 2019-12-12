package leetcode.string;

// https://leetcode.com/problems/string-to-integer-atoi/
public class StringToIntegerATOI {

    public static void main(String[] args) {

    }

    public int myAtoi(String str) {
        if (null == str || str.trim().isEmpty()) {
            return 0;
        }

        str = str.trim(); // remove leading and trailing spaces
        char[] chars = str.toCharArray();
        int sum = 0, sign = 1;

        if (chars[0] == '-' || chars[0] == '+') {
            sign = chars[0] == '-' ? -1 : 1;
        }

        int i = 0;
        while (i < chars.length) {
            char ch = chars[i];
            if (i == 0 && (ch == '-' || ch == '+')) {
                i++;
                continue;
            }
            if (! Character.isDigit(ch)) {
                break;
            }

            int value = Character.getNumericValue(ch);
            //check if sum will be overflow after 10 times and add digit
            if(Integer.MAX_VALUE / 10 < sum ||
                    Integer.MAX_VALUE / 10 == sum && Integer.MAX_VALUE % 10 < value) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            sum = (sum * 10) + value;
            i++;
        }

        return sum * sign;
    }
}
