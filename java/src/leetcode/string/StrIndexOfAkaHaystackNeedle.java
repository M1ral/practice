package leetcode.string;

// https://leetcode.com/problems/implement-strstr/
public class StrIndexOfAkaHaystackNeedle {

    public static void main(String[] args) {
        System.out.println("indexOf(\"leetcode\", \"etc\") = " + indexOf("leetcode", "etc"));
    }

    /**
     * Returns the index of needle from haystack (aka String.indexOf())
     *
     * @param haystack
     * @param needle
     * @return int
     */
    public static int indexOf(String haystack, String needle) {
        if (null == haystack || null == needle) {
            return -1;
        }
        if (needle.isEmpty()) {
            return 0;
        }
        if (needle.length() > haystack.length()) {
            return -1;
        }

        int nl = needle.length();

        for (int i = 0; i < haystack.length(); i++) {
            if (i + nl > haystack.length()) {
                return -1;
            }

            if (haystack.charAt(i) == needle.charAt(0)) {
                int tmp = nl;
                int hi = i;
                int ni = 0;

                while (tmp != 0) {
                    if (haystack.charAt(hi) != needle.charAt(ni)) {
                        break;
                    }
                    tmp--;
                    hi++;
                    ni++;
                }

                if (tmp == 0) {
                    return i;
                }
            }
        }
        return -1;
    }
}
