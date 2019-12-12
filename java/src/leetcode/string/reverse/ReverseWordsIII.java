package leetcode.string.reverse;

// https://leetcode.com/problems/reverse-words-in-a-string-iii/
public class ReverseWordsIII {

    public static void main(String[] args) {
        System.out.println("reverseWords(\"the sky is blue\") = " + reverseWords("the sky is blue"));
    }
    
    public static String reverseWords(String s) {
        if (null == s || s.isEmpty()) {
            return s;
        }

        String[] strs = s.split(" ");
        StringBuilder sb = new StringBuilder();

        for (String str : strs) {
            sb.append(reverse(str)).append(" ");
            // sb.append(
            // new StringBuilder(str).reverse())
            // .append(" ");
        }
        return sb.toString().trim();
    }

    private static String reverse(String str) {
        int l = 0, r = str.length() - 1;
        char[] chars = str.toCharArray();
        while (l < r) {
            char temp = chars[l];
            chars[l] = chars[r];
            chars[r] = temp;
            l++;
            r--;
        }
        return new String(chars);
    }
}

