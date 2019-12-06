package interview.phone.microsoft;

import java.util.Stack;

public class EvaluateExpression2019 {
    public static void main(String[] args) throws Exception {
        System.out.println("compute(\"7 + 1 - 7 + 12\") = " + compute("7 + 1 - 7 + 12"));
    }

    public static int compute(String expression) throws Exception {
        if (null == expression || expression.isEmpty()) {
            return 0;
        }

        Stack<Character> operations = new Stack<>();
        Stack<Integer> values = new Stack<>();

        char[] chars = expression.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];

            if (! ((c >= '0' && c <= '9') || (c == '+' || c == '-' || c == '*' || c == '/'))) {
                continue;
            }

            // digit
            if (c >= '0' && c <= '9') {
                StringBuilder sb = new StringBuilder();
                while (i < chars.length && c >= '0' && c <= '9') {
                    sb.append(c);
                    i++;
                    if (i == chars.length) break;
                    c = chars[i];
                }
                values.push(Integer.parseInt(sb.toString()));
            }

            // operand
            if (c == '+' || c == '-' || c == '*' || c == '/') {
                if (operations.isEmpty()) {
                    operations.push(c);
                } else {
                    values.push(evaluate(operations.pop(), values.pop(), values.pop()));
                    operations.push(c);
                }
            }
        }

        while (! operations.isEmpty()) {
            values.push(evaluate(operations.pop(), values.pop(), values.pop()));
        }

        return values.pop();
    }

    private static int evaluate(char operand, int a, int b) throws Exception {
        if (operand == '+') {
            return a + b;
        } else if (operand == '-') {
            return b - a;
        } else if (operand == '*') {
            return a * b;
        } else if (operand == '/') {
            return b / a;
        }
        throw new Exception("Invalid operation");
    }
}
