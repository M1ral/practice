package interview.phone.twentyninteen.uber;

import java.util.*;

public class PrintPalindromePermutations {

    public static void main(String args[]) throws Exception {
        System.out.println(Arrays.toString(findPalindromePermutations("abab").toArray()));
    }

    public static List<String> findPalindromePermutations(String str) {
        if (null == str || str.isEmpty()) {
            return new ArrayList();
        }

        List<String> result = new ArrayList();
        Map<Character, Integer> map = new HashMap();
        char[] chars = str.toCharArray();

        // build char map
        for (char ch : chars) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        // if palindrome not possible
        int oddCharCount = 0;
        for (char ch : map.keySet()) {
            if (map.get(ch) % 2 != 0) {
                oddCharCount++;
                if (oddCharCount > 1) {
                    return result;
                }
            }
        }

        // find palindromes
        permute("", map, result, str.length());

        return result;
    }

    // build palindrome permutations
    private static void permute(String temp, Map<Character, Integer> map,
                                List<String> result, int strLength) {
        if (temp.length() == strLength) {
            result.add(temp);
            return;
        }

        // backtrack
        for (char ch : map.keySet()) {
            if (map.get(ch) == 0) {
                continue;
            }
            // choose current character and update map
            temp += ch;
            temp = ch + temp;
            map.put(ch, map.get(ch) - 2);

            // explore
            permute(temp, map, result, strLength);

            // unchoose and update map
            temp = temp.substring(1, temp.length()-1);
            map.put(ch, map.get(ch) + 2);
        }
    }
}
