package string;

public class ReverseWords {

    public static void main(String[] args) {

        // reverse words in a string
        // https://www.programcreek.com/2014/05/leetcode-reverse-words-in-a-string-ii-java/
        System.out.println("reverseWords(\"the sky is blue\")" + reverseWords("the sky is blue"));
        System.out.println("reverseWords(\" 1\")" + reverseWords(" 1"));

        // test
        String str = "Hello\nMiral\n\nRegards,\nMiral Patel";
        System.out.println("replaceNewLineChar(str) = " + replaceNewLineChar(str));
    }

    /**
     * Reverse given input string
     * For example,
     * Given s = "the sky is blue",
     * return "blue is sky the".
     *
     * @param input
     * @return
     */
    public static String reverseWords(String input) {
        if (null == input || input.isEmpty()) {
            return null;
        }

        String[] words = input.split(" ");
        StringBuilder output = new StringBuilder();

        for (int i = words.length - 1; i >= 0; i--) {
            String word = words[i].trim();
            if (word.isEmpty()) {
                continue;
            }

            output.append(word);

            if (i > 0) {
                output.append(" ");
            }
        }

        return output.toString().trim();
    }

    /**
     * Print count and say - program creek
     * 1 is read off as "one 1" or 11.
     * 11 is read off as "two 1s" or 21.
     * 21 is read off as "one 2, then one 1" or 1211.
     *
     * @param n
     * @return
     */
    public static String countAndSay(int n) {
        if (n <= 0)
            return null;

        String result = "1";
        int i = 1;

        while (i < n) {
            StringBuilder sb = new StringBuilder();
            int count = 1;
            for (int j = 1; j < result.length(); j++) {
                if (result.charAt(j) == result.charAt(j - 1)) {
                    count++;
                } else {
                    sb.append(count);
                    sb.append(result.charAt(j - 1));
                    count = 1;
                }
            }

            sb.append(count);
            sb.append(result.charAt(result.length() - 1));
            result = sb.toString();
            i++;
        }

        return result;
    }

    private static String replaceNewLineChar(String str) {
        return str.replaceAll("(\r\n|\n)", "<br />");
    }
}
