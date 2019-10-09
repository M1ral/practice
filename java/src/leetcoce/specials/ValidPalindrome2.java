package leetcoce.specials;

public class ValidPalindrome2 {
    public static void main(String[] args) {
        System.out.println("validPalindrome(\"abca\") = " + validPalindrome("abca"));
    }

    public static boolean validPalindrome(String s) {
        if (null == s || s.isEmpty()) {
            return false;
        }

        int l = 0, r = s.length() - 1;

        while (l <= r) {
            if (s.charAt(l) == s.charAt(r)) {
                l++;
                r--;
                continue;
            }
            if (isPalindromic(s, l+1, r) || isPalindromic(s, l, r-1)) {
                return true;
            } else {
                return false;
            }
        }
        return true;
    }

    private static boolean isPalindromic(String s, int l, int r) {
        if (null == s || s.isEmpty() || l > r) {
            return false;
        }

        while (l <= r) {
            if (s.charAt(l) == s.charAt(r)) {
                l++;
                r--;
                continue;
            } else {
                return false;
            }
        }

        return true;
    }
}
