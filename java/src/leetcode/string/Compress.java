package leetcode.string;

public class Compress {

    public static void main(String[] args) {
        System.out.println("compress(\"abcd\") = " + compress("abcd"));
        System.out.println("compress(\"aabbccd\") = " + compress("aabbccd"));
    }

    /**
     * Compress given input String
     *
     * @param s
     * @return
     */
    public static String compress(String s) {
        if (null == s || s.isEmpty()) {
            return null;
        }

        char previous = s.charAt(0), current;
        int count = 1;
        StringBuilder result = new StringBuilder();

        for (int i = 1; i < s.length(); i++) {
            current = s.charAt(i);
            if (current == previous) {
                count++;
            } else {
                result.append(previous).append(count);
                previous = current;
                count = 1;
            }
        }

        result.append(previous).append(count);
        return result.toString();
    }
}

