package string;

public class CountAndSay {

    public static void main(String[] args) {
        System.out.println("countAndSay(122) = " + countAndSay(122));
        System.out.println("countAndSay(12) = " + countAndSay(12));
        System.out.println("countAndSay(1112223453) = " + countAndSay(1112223453));
        System.out.println("countAndSay(1) = " + countAndSay(1));
    }

    /**
     * Print count and say - program creek
     * 1 is read off as "one 1" or 11.
     * 11 is read off as "two 1s" or 21.
     * 21 is read off as "one 2, then one 1" or 1211.
     *
     * @param n
     * @return String
     */
    public static String countAndSay(int n) {
        if (n <= 0) {
            return "";
        }

        StringBuilder result = new StringBuilder();
        int count = 1;
        int previous = n % 10;
        int current = 0;
        n = n / 10;

        while (n != 0) {
            current = n % 10;
            if (current == previous) {
                count++;
            } else {
                result = new StringBuilder().append(count).append(previous).append(result);
                count = 1;
            }
            previous = current;
            n = n / 10;
        }

        result = new StringBuilder().append(count).append(previous).append(result);
        return result.toString();
    }
}
