package leetcode.string;

public class VersionCompare {

    public static void main(String[] args) {
        System.out.println("compare(\"1.0.0\", \"1.0.3\") = " + compare("1.0.0", "1.0.3"));
    }

    public static boolean compare(String v1, String v2) {
        if (null == v1 || v1.isEmpty() ||
            null == v2 || v2.isEmpty()) {
            return false;
        }

        return true;
    }
}
