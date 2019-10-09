package ctci.arraysstrings;

public class ReplaceSpaces {

    public static void main(String[] args) {
        replaceSpaces("Miral Patel");
    }

    // Replace space character with %20 in the given input string
    public static void replaceSpaces(String input) {
        if (null == input || input.isEmpty()) {
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (char ch : input.toCharArray()) {
            if (ch == ' ') {
                sb.append("%20");
                continue;
            }
            sb.append(ch);
        }
        input = sb.toString();
        System.out.println(input);
    }
}
