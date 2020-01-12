package leetcode.string;

// https://leetcode.com/problems/compare-version-numbers/
public class VersionCompare {

    public static void main(String[] args) {
        System.out.println("compare(\"1.0.0\", \"1.0.3\") = " + compareVersion("1.0.0", "1.0.3"));
        System.out.println("compare(\"1.0.0\", \"1\") = " + compareVersion("1.0.0", "1"));
    }

    public static int compareVersion(String version1, String version2) {
        if (null == version1 || version1.isEmpty() ||
                null == version2 || version2.isEmpty()) {
            return -1;
        }

        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int i = 0, j = 0;

        while (i < v1.length || j < v2.length) {
            int a = 0;
            if (i < v1.length) {
                a = Integer.parseInt(v1[i++]);
            }

            int b = 0;
            if (j < v2.length) {
                b = Integer.parseInt(v2[j++]);
            }

            if (a > b) {
                return 1;
            } else if (a < b) {
                return -1;
            }
        }

        return 0;
    }
}
