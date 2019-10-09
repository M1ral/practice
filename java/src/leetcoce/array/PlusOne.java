package leetcoce.array;

import java.util.Arrays;

/**
 * Input: [1,2,3]
 * Output: [1,2,4]
 * Explanation: The leetcoce.array represents the integer 123.
 *
 * Input: [4,3,2,1]
 * Output: [4,3,2,2]
 * Explanation: The leetcoce.array represents the integer 4321.
 *
 * https://leetcode.com/problems/plus-one/description/
 */
public class PlusOne {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(plusOne(new int[] {9,9})));
    }

    public static int[] plusOne(int[] digits) {
        if (null == digits || digits.length == 0) {
            return null;
        }

        int[] result = new int[digits.length + 1]; // add scope for the carry
        int carry = 0;
        int index = digits.length - 1;
        int sum = 1;

        while (index >= 0) {
            sum = sum + carry + digits[index];
            carry = sum / 10;
            sum = sum % 10;
            result[index + 1] = sum;

            sum = 0;
            index--;
        }

        if (carry > 0) {
            result[index + 1] = carry;
            return result;
        }
        
        int[] plusOne = new int[digits.length];
        System.arraycopy(result, 1, plusOne, 0, digits.length);
        return plusOne;
    }
}
