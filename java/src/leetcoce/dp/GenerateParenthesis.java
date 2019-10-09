package leetcoce.dp;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {

    public static void main(String[] args) {
        System.out.println("generateParenthesis(3) = " + generateParenthesis(3));
    }

    public static List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<String>();
        traverse(list, "", 0, 0, n);
        return list;
    }

    /**
     * iterations
     * -- ""
     * ((()))
     * -- ((
     * (()())
     * -- (()
     * (())()
     * -- (
     * ()(())
     * -- ()(
     * ()()()
     *
     * @param list
     * @param str
     * @param open
     * @param close
     * @param length
     */
    public static void traverse(List<String> list, String str, int open, int close, int length) {
        if (str.length() == length * 2) {
            list.add(str);
            return;
        }

        if (open < length) {
            traverse(list,  str + "(", open + 1, close, length);
        }
        if (close < open) {
            traverse(list, str + ")", open, close + 1, length);
        }
    }
}
