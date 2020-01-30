package interview.onsite.microsoft;

import java.util.*;

public class Microsoft2019 {
    public static void main(String[] args) {
        printFib(10);
        System.out.println("isValidParentheses(\"a(b)(d(e))\") = " + isValidParentheses("a(b)(d(e))"));
        System.out.println("isValidParentheses(\"[(b)(d(e))]\") = " + isValidParentheses("[(b)(d(e))]"));
        System.out.println("isValidParentheses(\"[(b}(d(e))]\") = " + isValidParentheses("[(b}(d(e))]"));
    }

    // interview 1
    public static int[][] spiralMatrix2(int n) {
        return new int[][]{};
    }

    // interview 2 - version of fibonacci
    // print in the following order
    // 1 = 1
    // 2 = 3
    // 3 = 6
    // 4 = 10 and so on ... until 99.
    public static void printFib(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
            System.out.println(i + " = " + sum);
        }
    }

    // interview 3 - Object oriented design for Product list page and product details page

    // interview 4 - Valid parentheses
    public static boolean isValidParentheses(String input) {
        if (null == input || input.isEmpty()) {
            return false;
        }

        Map<Character, Character> map = new HashMap<>();
        Set<Character> open = new HashSet<>(Arrays.asList('(', '{', '['));
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        Deque<Character> stack = new ArrayDeque<>();

        for (char ch : input.toCharArray()) {
            if (open.contains(ch)) {
                stack.add(ch);
            } else if (map.keySet().contains(ch)) {
                if (stack.isEmpty()) return false;
                if (map.get(ch) != stack.removeLast()) return false;
            }
        }
        return stack.isEmpty();
    }
}
