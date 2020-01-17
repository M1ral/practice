package leetcode.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// https://leetcode.com/problems/encode-and-decode-strings/
public class EncodeDecodeString {

    public static void main(String[] args) {
        String encoded = encode(Arrays.asList("abc", "def", "ghijkl"));
        System.out.println("decode(encoded) = " + decode(encoded));
    }

    // Encodes a list of strings to a single string.
    public static String encode(List<String> strs) {
        if (null == strs || strs.isEmpty()) {
            return null;
        }

        StringBuilder sb = new StringBuilder();
        for (String str : strs)
            sb.append(str.length()).append("/").append(str);

        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public static List<String> decode(String s) {
        if (null == s || s.isEmpty()) {
            return Collections.emptyList();
        }

        List<String> list = new ArrayList<String>();
        int i = 0;
        while (i < s.length()) {
            int slash = s.indexOf('/', i);
            int size = Integer.valueOf(s.substring(i, slash));
            i = slash + size + 1;
            list.add(s.substring(slash + 1, i));
        }
        return list;
    }
}
