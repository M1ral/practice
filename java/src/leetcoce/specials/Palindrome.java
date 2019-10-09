package leetcoce.specials;

import java.util.ArrayList;
import java.util.List;

public class Palindrome {
    public static void main(String[] args) {
        System.out.println("isPalindrome: " + isPalindrome(1221));
    }

    /**
     * Chekc if given number is palindrome without converting it to leetcoce.string
     *
     * @param x
     * @return boolean
     */
    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false; // because it will have a negative sign
        }

        List<Integer> list = new ArrayList();
        int m = 0;
        int i = 0;
        while (x != 0) {
            m = x % 10;
            x = x / 10;
            list.add(i, m);
        }

        int len = list.size();
        for (int j = 0; j < list.size() / 2; j++) {
            if (list.get(j) != list.get(len-1-j)) {
                return false;
            }
        }

        return true;
    }
}
