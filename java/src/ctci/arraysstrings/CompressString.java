package ctci.arraysstrings;

public class CompressString {

    public static void main(String[] args) {
        System.out.println("compressString(\"aabbccd\") = " + compressString("aabbccd"));
        System.out.println("compressString(\"abc\") = " + compressString("abc"));
        System.out.println("compressString(\"aabbbbbcde\") = " + compressString("aabbbbbcde"));
        System.out.println("compressString(\"abcd\") = " + compressString("abcd"));
        System.out.println("compressString(\"abccdd\") = " + compressString("abccdd"));
    }

    public static String compressString(String input) {
        if (null == input || input.isEmpty()) {
            return input;
        }

        StringBuilder sb = new StringBuilder();
        char prev = input.charAt(0);
        int count = 1;

        for (int i = 1; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (prev == ch) {
                count++;
                continue;
            }
            sb.append(prev);
            sb.append(count);
            prev = ch;
            count = 1;
        }
        sb.append(prev);
        sb.append(count);

        return sb.toString();
    }
}
