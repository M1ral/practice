package leetcoce.specials;

import java.util.Stack;

public class ReversePolishNotation {

    public static void main(String[] args) {
        System.out.println("evalRPN(\"2\", \"1\", \"-\", 5, \"+\") = " + evalRPN(new String[] {"2", "1", "-", "5", "+"}));
    }

    public static int evalRPN(String[] tokens) {
        int result = 0;
        if (null == tokens || tokens.length == 0) {
            return result;
        }

        String operators = "+-*/";
        Stack<String> stack = new Stack<>();

        for (String t : tokens) {
            if (!operators.contains(t)) {
                stack.push(t);
            } else {
                if (stack.size() < 2) {
                    return result;
                }
                int a = Integer.valueOf(stack.pop());
                int b = Integer.valueOf(stack.pop());

                switch (t) {
                    case "+" :
                        stack.push(String.valueOf(a + b));
                        break;
                    case "-" :
                        stack.push(String.valueOf(b - a));
                        break;
                    case "*" :
                        stack.push(String.valueOf(a * b));
                        break;
                    case "/" :
                        stack.push(String.valueOf(b / a));
                        break;
                }
            }
        }

        result = Integer.valueOf(stack.pop());
        return result;
    }
}
