package leetcode.string.reverse;

// https://leetcode.com/problems/reverse-words-in-a-string-ii/
public class ReverseWordsII {

    /**
     * Input:  ["t","h","e"," ","s","k","y"," ","i","s"," ","b","l","u","e"]
     * Output: ["b","l","u","e"," ","i","s"," ","s","k","y"," ","t","h","e"]
     *
     * @param args
     */
    public static void main(String[] args) {
        char[] s = new char[]{'t','h','e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
        reverseWords(s);
        System.out.println("s = " + new String(s));
    }

    public static void reverseWords(char[] s) {
        if (null == s || s.length == 0) {
            return;
        }
        // 1. reverse whole sentence
        reverse(s, 0, s.length - 1);

        // reverse tokens
        int i = 0, start = 0;
        while (i < s.length) {
            if (s[i] == ' ') {
                reverse(s, start, i-1);
                start = i+1;
            }
            i++;
        }

        // reverse last token
        reverse(s, start, i-1);
    }

    private static void reverse(char[] s, int l, int r) {
        if (l > r) return;
        while (l < r) {
            char t = s[l];
            s[l] = s[r];
            s[r] = t;
            l++;
            r--;
        }
    }
}
