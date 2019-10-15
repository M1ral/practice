package programcreek.dp;

public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        System.out.println(longestPalindromicSubstring("aaabcbadeedbc"));
    }

    public static String longestPalindromicSubstring(String input) {
        if (null == input || input.isEmpty() || input.length() < 2) {
            return input;
        }

        String longest = "";
        for (int i = 0; i < input.length(); i++) {
            // odd (one character in center)
            String temp = expand(input, i, i);
            if (temp.length() > longest.length()) {
                longest = temp;
            }

            // even (two characters in center)
            temp = expand(input, i, i+1);
            if (temp.length() > longest.length()) {
                longest = temp;
            }
        }

        return longest;
    }

    // expand to both sides from begin and end (to left and right respectively)
    // and look for palindrome
    public static String expand(String s, int begin, int end) {
        while (begin >= 0 && end < s.length() && s.charAt(begin) == s.charAt(end)) {
            begin--;
            end++;
        }
        return s.substring(begin+1, end);
    }
}
