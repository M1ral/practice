package string;

public class Palindrome {
    public static void main(String[] args) {
        System.out.println("is palindrome : " + isPalindrome("0P"));
        System.out.println("is palindrome : " + isPalindrome("1  22  1"));
        System.out.println("is palindrome : " + isPalindrome("1  22 3 1"));
    }

    /**
     * Check if given String is palindrome
     *
     * @param s
     * @return boolean
     */
    public static boolean isPalindrome(String s) {
        if (null == s || s.isEmpty()) {
            return false;
        }

        int i = 0;
        int j = s.length() - 1;

        while (i < j) {
            char si = Character.toLowerCase(s.charAt(i));
            if (!(Character.isDigit(si) || Character.isLetter(si))) {
                i++;
                continue;
            }

            char sj = Character.toLowerCase(s.charAt(j));
            if (!(Character.isDigit(sj) || Character.isLetter(sj))) {
                j--;
                continue;
            }

            if (si != sj) {
                return false;
            }

            i++;
            j--;
        }
        return true;
    }
}
