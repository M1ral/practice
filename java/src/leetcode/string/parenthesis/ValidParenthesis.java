package leetcode.string.parenthesis;

import java.util.ArrayDeque;
import java.util.Deque;

public class ValidParenthesis {

    public static void main(String[] args) {
        System.out.println("isValid(\"({})\") : " + isValidParenthesis("({})"));
        System.out.println("isValid(\"({}]\") : " + isValidParenthesis("({}]"));
    }

    /**
     * Check given leetcoce.string has valid parenthesis
     *
     * @param s
     * @return boolean
     */
    public static boolean isValidParenthesis(String s) {
        if (null == s || s.isEmpty()) {
            return true;
        }

        Deque<Character> stack = new ArrayDeque<Character>();
        char[] chars = s.toCharArray();

        for (char ch : chars) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) return false;
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


