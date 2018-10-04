package string;

import java.util.ArrayDeque;
import java.util.Deque;

public class ValidParenthesis {

    public static void main(String[] args) {
        System.out.println("isValid(\"({})\") : " + isValidParenthesis("({})"));
        System.out.println("isValid(\"({}]\") : " + isValidParenthesis("({}]"));
    }

    /**
     * Check given string has valid parenthesis
     *
     * @param s
     * @return boolean
     */
    public static boolean isValidParenthesis(String s) {
        if (null == s || s.isEmpty()) {
            return false;
        }

        String openBrackets = "({[";
        Deque<Character> stack = new ArrayDeque<>();

        for (char ch : s.toCharArray()) {
            if (openBrackets.indexOf(ch) > -1) {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                if (ch == ')') {
                    if (stack.pop() != '(') return false;
                } else if (ch == '}') {
                    if (stack.pop() != '{') return false;
                } else if (ch == ']') {
                    if (stack.pop() != '[') return false;
                }
            }
        }

        return stack.isEmpty();
    }
}


