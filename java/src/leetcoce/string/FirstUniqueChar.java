package leetcoce.string;

public class FirstUniqueChar {

    public static void main(String[] args) {
        System.out.println("firstUniqChar(\"loveleetcode\") = " + firstUniqChar("loveleetcode"));
    }

    public static int firstUniqChar(String s) {
        if (null == s || s.isEmpty()) {
            return -1;
        }

        char[] chars = s.toCharArray();
        int[] checker = new int[256];

        for (char c : chars) {
            checker[c]++;
        }

        int i = 0;
        for (char c : chars) {
            if (checker[c] == 1) return i;
            i++;
        }

        return -1;
    }
}
