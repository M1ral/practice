package interview.phone.microsoft;

import java.util.Stack;

public class EvaluateExpression2019 {

    public static void main(String[] args) throws Exception {
        System.out.println("compute(\"7 + 1 - 7 + 12\") = " + compute("7 + 1 - 7 + 12"));
        System.out.println("compute(\"7 + 1 - 7 + 12\") = " + compute("(100 -  2) + 12"));
    }

    public static int compute(String s) {
        if (null == s || s.isEmpty()) {
            return 0;
        }

        char[] tokens = s.toCharArray();
        Stack<Character> ops = new Stack<>();
        Stack<Integer> values = new Stack<>();

        for (int i = 0; i < tokens.length; i++) {
            char c = tokens[i];
            if (c == ' ') {
                continue; // ignore spaces
            }
            // digit
            else if (Character.isDigit(c)) {
                StringBuilder sb = new StringBuilder();
                while (i < tokens.length && tokens[i] >= '0' && tokens[i] <= '9') {
                    sb.append(tokens[i++]);
                }
                values.push(Integer.parseInt(sb.toString()));
            }
            // handle brackets
            else if (c == '(') {
                ops.push(c);
            } else if (c == ')') {
                // compute expression
                while (ops.peek() != '(') {
                    values.push(apply(ops.pop(), values.pop(), values.pop()));
                }
                ops.pop();
            }
            // operators
            else if (c == '+' || c == '-' || c == '*' || c == '/') {
                while (!ops.isEmpty() && hasPrecedence(c, ops.peek())) {
                    values.push(apply(ops.pop(), values.pop(), values.pop()));
                }
                ops.push(c);
            }
        }

        while (!ops.isEmpty()) {
            values.push(apply(ops.pop(), values.pop(), values.pop()));
        }

        return values.pop();
    }

    private static boolean hasPrecedence(char op1, char op2) {
        if (op2 == '(' || op2 == ')') {
            return false;
        } else if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-')) {
            return false;
        }
        return true;
    }

    private static int apply(char operation, int b, int a) {
        switch (operation) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b == 0) throw new UnsupportedOperationException("Cannot divide by zero!");
                return a / b;
        }
        return 0;
    }
}
