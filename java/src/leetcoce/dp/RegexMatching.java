package leetcoce.dp;

public class RegexMatching {

    public static void main(String[] args) {
        System.out.println("isMatch(\"aabdc\", \"a*b.y\") = " + isMatch("aabdc", "a*b.c"));
    }

    /**
     * Check whether given text matches the regex
     *
     * @param s
     * @param p
     * @return boolean
     */
    public static boolean isMatch(String s, String p) {
        char[] pattern = p.toCharArray(), text = s.toCharArray();
        boolean T[][] = new boolean[text.length + 1][pattern.length + 1];

        T[0][0] = true;

        //Deals with patterns like a* or a*b* or a*b*c*
        for (int i = 1; i < T[0].length; i++) {
            if (pattern[i-1] == '*') {
                T[0][i] = T[0][i - 2];
            }
        }

        for (int i = 1; i < T.length; i++) {
            for (int j = 1; j < T[0].length; j++) {
                if (pattern[j - 1] == '.' || pattern[j - 1] == text[i - 1]) {
                    T[i][j] = T[i-1][j-1];
                } else if (pattern[j - 1] == '*')  {
                    T[i][j] = T[i][j - 2];
                    if (pattern[j-2] == '.' || pattern[j - 2] == text[i - 1]) {
                        T[i][j] = T[i][j] || T[i - 1][j];
                    }
                }
            }
        }
        return T[text.length][pattern.length];
    }
}
