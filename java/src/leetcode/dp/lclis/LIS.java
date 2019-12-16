package leetcode.dp.lclis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static leetcode.dp.lclis.ElementsOfLIS.getElementsOfLIS;

// https://leetcode.com/problems/longest-increasing-subsequence/
public class LIS {

    // Based on Patience sorting
    // Explanation: https://leetcode.com/problems/longest-increasing-subsequence/discuss/74824/JavaPython-Binary-search-O(nlogn)-time-with-explanation/206357
    // https://www.cs.princeton.edu/courses/archive/spring13/cos423/lectures/LongestIncreasingSubsequence.pdf
    public static void main(String[] args) {
        System.out.println("lengthOfLIS({3, 5, 6, 2, 5, 4, 19, 5, 6, 7, 12, 2, 3}) = " +
                lengthOfLIS(new int[]{3, 5, 6, 2, 5, 4, 19, 5, 6, 7, 12, 2, 3}));
        System.out.println("lengthOfLISBinarySearch({3, 5, 6, 2, 5, 4, 19, 5, 6, 7, 12, 2, 3}) = " +
                lengthOfLISBinarySearch(new int[]{3, 5, 6, 2, 5, 4, 19, 5, 6, 7, 12, 2, 3}));
        System.out.println("getElementsOfLIS({3, 5, 6, 2, 5, 4, 19, 5, 6, 7, 12, 2, 3}) = " +
                getElementsOfLIS(new int[]{3, 5, 6, 2, 5, 4, 19, 5, 6, 7, 12, 2, 3}));
    }

    public static int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int[] max = new int[nums.length];
        Arrays.fill(max, 1);

        int result = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    max[i] = Math.max(max[i], max[j] + 1);
                }
            }
            result = Math.max(max[i], result);
        }
        return result;
    }

    public static int lengthOfLISBinarySearch(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        List<Integer> list = new ArrayList<>();

        for (int num : nums) {
            if (list.size() == 0 || num > list.get(list.size() - 1)) {
                list.add(num);
            } else {
                int index = Collections.binarySearch(list, num);
                if (index < 0) {
                    index = ~index;
                }

                // binary search
                /*int i = 0;
                int j = list.size() - 1;

                while (i < j) {
                    int mid = (i + j) / 2;
                    if (list.get(mid) < num) {
                        i = mid + 1;
                    } else {
                        j = mid;
                    }
                }

                list.set(j, num);*/
                list.set(index, num);
            }
        }

        return list.size();
    }
}
