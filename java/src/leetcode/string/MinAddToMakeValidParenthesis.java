package leetcode.string;

import java.util.Stack;

public class MinAddToMakeValidParenthesis {

    public static void main(String[] args) {
        System.out.println("minAddToMakeValid(\"())\") = " + minAddToMakeValid("())"));
        System.out.println("minAddToMakeValid(\"()))((\") = " + minAddToMakeValid("()))(("));
    }

    public static int minAddToMakeValid(String S) {
        if (null == S || S.isEmpty()) {
            return 0;
        }

        char open = '(';
        char close = ')';
        int extra = 0;
        char[] sCharArr = S.toCharArray();
        int openCount = 0, closeCount = 0;
        Stack<Character> stack = new Stack();

        for (char ch : sCharArr) {
            if (ch == open) {
                openCount++;
                stack.push(ch);
            } else if (ch == close) {
                if (stack.isEmpty()) {
                    extra++;
                } else {
                    closeCount++;
                    stack.pop();
                }
            }
        }
        return Math.abs(openCount - closeCount) + extra;
    }
}
