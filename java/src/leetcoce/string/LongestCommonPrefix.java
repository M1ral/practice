package leetcoce.string;

public class LongestCommonPrefix {

    public static void main(String[] args) {
        System.out.println("longestCommonPrefix(new String[]{\"leet\", \"leetcode\", \"lee\"}) = " +
                longestCommonPrefix(new String[]{"leet", "leetcode", "le", "length", "long", "legal"}));
    }

    /**
     * Returns the largest common prefix among given strs
     *
     * @param strs
     * @return String
     */
    public static String longestCommonPrefix(String[] strs) {
        if (null == strs || strs.length == 0) {
            return "";
        }

        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        return prefix;
    }
}
