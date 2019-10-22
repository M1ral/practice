package leetcode.dp;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PhoneNumberLetters {

    public static void main(String[] args) {
        System.out.println("letterCombinations(\"23\") = " + letterComb2("23"));
    }

    public static List<String> letterCombinations(String digits) {
        LinkedList<String> ans = new LinkedList<String>();
        if (digits.isEmpty()) return ans;
        String[] mapping = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ans.add("");

        while (ans.peek().length() != digits.length()) {
            String remove = ans.remove();
            String map = mapping[digits.charAt(remove.length()) - '0'];
            for (char c : map.toCharArray()) {
                ans.addLast(remove + c);
            }
        }

        return ans;
    }

    public static List<String> letterComb2(String digits) {
        List<String> result = new ArrayList<>();
        if (null == digits || digits.isEmpty()) {
            return result;
        }

        result.add("");
        String[] keyboardMap = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        while(result.get(0).length() != digits.length()) {
            String temp = result.remove(0);
            String current = keyboardMap[Character.getNumericValue(digits.charAt(temp.length()))];

            for (char ch : current.toCharArray()) {
                result.add(temp + ch);
            }
        }

        return result;
    }
}
