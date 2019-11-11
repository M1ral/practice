package interview.phone.twentyninteen.uber;

import java.util.*;

public class PrintPalindromePermutations {

    public static void main(String args[]) throws Exception {
        // approach used during interview
        System.out.println(Arrays.toString(findPalindromePermutations("abab").toArray()));
        System.out.println(Arrays.toString(findPalindromePermutations("acbab").toArray()));
        System.out.println(Arrays.toString(findPalindromePermutations("asssa").toArray()));

        // alternative approach
        System.out.println(Arrays.toString(generatePalindromes("abab").toArray()));
        System.out.println(Arrays.toString(generatePalindromes("acbab").toArray()));
        System.out.println(Arrays.toString(generatePalindromes("asssa").toArray()));
    }

    public static List<String> findPalindromePermutations(String str) {
        if (null == str || str.isEmpty()) {
            return new ArrayList();
        }

        Set<String> result = new HashSet();
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
                    return Collections.emptyList();
                }
            }
        }

        // find palindromes
        permute("", map, result, str.length());

        return new ArrayList<>(result);
    }

    // build palindrome permutations
    private static void permute(String temp, Map<Character, Integer> map,
                                Set<String> result, int strLength) {
        if (temp.length() == strLength) {
            result.add(temp);
            return;
        }

        // backtrack
        for (char ch : map.keySet()) {
            if (map.get(ch) == 0) {
                continue;
            }

            int count = map.get(ch);
            int mid = temp.length() / 2;
            // choose current character and update map
            if (count == 1) {
                temp = mid > 0 ? temp.substring(0, mid) + ch + temp.substring(mid) : temp + ch;
                map.put(ch, map.get(ch) - 1);
            } else {
                temp += ch;
                temp = ch + temp;
                map.put(ch, map.get(ch) - 2);
            }

            // explore
            permute(temp, map, result, strLength);

            // unchoose and update map
            if (count == 1) {
                temp = mid > 0 ? temp.substring(0, mid) + temp.substring(mid) : temp;
                map.put(ch, map.get(ch) + 1);
            } else {
                temp = temp.substring(1, temp.length() - 1);
                map.put(ch, map.get(ch) + 2);
            }
        }
    }

    // IGNORE THIS ONE FOR NOW - UNDERSTAND IT LATER
    public static List<String> generatePalindromes(String s) {
        List<String> res = new ArrayList<>();
        int[] table = new int[128];
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            table[s.charAt(i)]++;
            cnt = (table[s.charAt(i)] % 2 == 0) ? cnt - 1 : cnt + 1;
        }
        if (s.equals("") || cnt > 1) {
            return res;
        }
        String temp = "";
        for (int i = 0; i < 128 && cnt == 1; i++) {
            if (table[i] % 2 == 1) {
                temp += (char) i;
                break;
            }
        }
        backtrackHelper(table, temp, res, s.length());

        return res;
    }

    public static void backtrackHelper(int[] table, String curr, List<String> res, int l) {
        if (curr.length() == l) {
            res.add(curr);
            return;
        }
        for (int i = 0; i < 128; i++) {
            if (table[i] > 1) {
                table[i] -= 2;
                char c = (char) i;
                String temp = c + curr + c;
                backtrackHelper(table, temp, res, l);
                table[i] += 2;
            }
        }
    }
}
