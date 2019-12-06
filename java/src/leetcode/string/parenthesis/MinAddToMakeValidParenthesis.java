package leetcode.string.parenthesis;

import java.util.ArrayDeque;
import java.util.Deque;

public class MinAddToMakeValidParenthesis {

    public static void main(String[] args) {
        System.out.println("minAddToMakeValid(\"())\") = " + minAddToMakeValid("())"));
        System.out.println("minAddToMakeValid(\"()))((\") = " + minAddToMakeValid("()))(("));
        System.out.println("minAddToMakeValid(\"((((\") = " + minAddToMakeValid("(((("));
        System.out.println("minAddToMakeValid(\"))))\") = " + minAddToMakeValid("))))"));
    }

    public static int minAddToMakeValid(String S) {
        if (null == S || S.isEmpty()) {
            return 0;
        }

        final char open = '(', close = ')';
        char[] sCharArr = S.toCharArray();
        Deque<Character> stack = new ArrayDeque<>();
        int count = 0;

        for (char ch : sCharArr) {
            if (ch == open) {
                stack.push(ch);
            } else if (ch == close) {
                if (stack.isEmpty()) {
                    count++;
                } else {
                    stack.pop();
                }
            }
        }
        return stack.size() + count;
    }
}
