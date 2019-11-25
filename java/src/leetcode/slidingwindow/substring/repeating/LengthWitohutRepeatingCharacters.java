package leetcode.slidingwindow.substring.repeating;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/longest-substring-without-repeating-characters/
public class LengthWitohutRepeatingCharacters {
    public static void main(String[] args) {
        System.out.println("withoutRepeatingChars(\"ABCDAEFBH\") = " + withoutRepeatingChars("ABCDAEFBH"));
    }

    // ABCDAEFBH - ABCD, BCDAEF, CDAEFBH - 7
    public static int withoutRepeatingChars(String s) {
        if (null == s || s.isEmpty()) {
            return 0;
        }

        int max = 0;
        Map<Character, Integer> map = new HashMap();
        String temp = "";

        for (char ch : s.toCharArray()) {
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
                while (map.get(ch) != 1) {
                    char toRemove = temp.charAt(0);
                    temp = temp.substring(1);
                    map.put(toRemove, map.get(toRemove) - 1);
                }
            } else {
                map.put(ch, 1);
            }

            temp += ch;
            max = Math.max(max, temp.length());
        }

        return max;
    }
}
