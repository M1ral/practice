package interview.phone.intuit;

public class PalindromeInteger {

    public static void main(String[] args) {
        System.out.println("isPalindrome(1221) = " + isPalindrome(1221));
        System.out.println("isPalindrome(1211) = " + isPalindrome(1211));
    }

    public static boolean isPalindrome(int num) {
        if (num == 0) {
            return true;
        }
        if (num < 0) {
            num = Math.abs(num);
        }

        // convert int to String
        String s = String.valueOf(num);
        char[] sChars = s.toCharArray();
        reverse(sChars);
        String t = new String(sChars);
        return s.compareTo(t) == 0 ? true : false;
    }

    public static void reverse(char[] chars) {
        if (null == chars || chars.length == 0) {
            return;
        }

        int l = 0, r = chars.length - 1;
        while (l < r) {
            char temp = chars[l];
            chars[l] = chars[r];
            chars[r] = temp;
            l++;
            r--;
        }
    }
}
