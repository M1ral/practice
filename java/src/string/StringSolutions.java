package string;

public class StringSolutions {

    public static void main(String[] args) {

        // reverse words in a string
        // https://www.programcreek.com/2014/05/leetcode-reverse-words-in-a-string-ii-java/
        System.out.println("reverseWords(\"the sky is blue\")" + reverseWords("the sky is blue"));
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
    private static String reverseWords(String input) {
        if (null == input || input.isEmpty()) {
            return null;
        }

        String[] words = input.split(" ");
        StringBuilder output = new StringBuilder();

        for (int i = words.length - 1; i >= 0; i--) {
            output.append(words[i]);
            if (i > 0) {
                output.append(" ");
            }
        }

        return output.toString();
    }
}
