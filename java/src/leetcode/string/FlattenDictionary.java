package leetcode.string;

import java.util.Arrays;

/**
 * Input: {
 *   'a': 1,
 *   'b': {
 *     'c': 2,
 *     'd': {
 *       'e': 3
 *     }
 *   }
 * }
 *
 * Output: {
 *   'a': 1,
 *   'b.c': 2,
 *   'b.d.e': 3
 * }
 */
public class FlattenDictionary {
    public static void main(String[] args) {
        String dict = "a: 1, b: {c: 2, d: {e: 3}}";
        flatten(dict);
    }

    public static String flatten(String dict) {
        String[] strs = dict.split(":");
        System.out.println("Arrays.toString(dict.split(\",\")) = " + Arrays.toString(dict.split(",")));
        return null;
    }
}


