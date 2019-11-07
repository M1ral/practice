package leetcode.string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindAnagrams {

    public static void main(String[] args) {
        System.out.println(findAnagrams("cbaebabacd", "abc"));
    }

    public static List<Integer> findAnagrams(String s, String p) {
        if (null == s || s.isEmpty() || null == p || p.isEmpty()) {
            return Collections.emptyList();
        }

        List<Integer> list = new ArrayList();
        int m = s.length(); int n = p.length();
        int[] pArr = new int[256], sArr = new int[256];

        // fill pArr and sArr
        for (int index = 0; index < n; index++) {
            pArr[p.charAt(index)] += 1;
            sArr[s.charAt(index)] += 1;
        }
        if (areAnagrams(sArr, pArr)) {
            list.add(0);
        }

        sArr[s.charAt(0)] -= 1; // increment i to 1

        for (int j = n, i = 1; j < s.length(); j++, i++) {
            char currentI = s.charAt(i);
            char currentJ = s.charAt(j);

            sArr[currentI] += 1;
            sArr[currentJ] += 1;

            if (areAnagrams(sArr, pArr)) {
                list.add(i);
            }

            sArr[currentI] -= 1;
            sArr[currentJ] -= 1;
        }

        return list;
    }

    public static boolean areAnagrams(int[] sArr, int[] pArr) {
        if (null == sArr || sArr.length == 0 ||
                null == pArr || pArr.length == 0) {
            return false;
        }

        for (int i = 0; i < sArr.length; i++) {
            if (pArr[i] != sArr[i])
                return false;
        }

        return true;
    }
}
