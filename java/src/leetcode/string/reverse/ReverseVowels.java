package leetcode.string.reverse;

public class ReverseVowels {

    public static void main(String[] args) {
        System.out.println("reverseVowels(\"ppddffgghh\") = " + reverseVowels("ppddffgghh"));
        System.out.println("reverseVowels(\"aabbccee\") = " + reverseVowels("aabbccee"));
    }

    /**
     * Reverse vowels of given leetcode.string input
     *
     * @param input
     * @return String
     */
    public static String reverseVowels(String input) {
        if (null == input || input.isEmpty()) {
            return "";
        }

        String vowels = "aeiouAEIOU";
        int start = 0;
        int end = input.length() - 1;
        char[] chars = input.toCharArray();

        while (start < end) {
            while (start < end && vowels.indexOf(chars[start]) == -1) {
                start++;
            }
            while (start < end && vowels.indexOf(chars[end]) == -1) {
                end--;
            }

            char tmp = chars[start];
            chars[start] = chars[end];
            chars[end] = tmp;

            start++;
            end--;
        }

        return new String(chars);
    }
}
