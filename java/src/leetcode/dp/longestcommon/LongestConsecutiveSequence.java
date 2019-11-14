package leetcode.dp.longestcommon;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    public static void main(String[] args) {
        System.out.println("longestConsecutiveLength(new int[]{100, 400, 2,3,1,7,4}) = " +
                longestConsecutiveLength(new int[]{100, 400, 2, 3, 1, 7, 4}));
    }

    /**
     * Return the length of longest consecutive sequence (which can occur anywhere in the leetcoce.array)
     *
     * Input: [100, 4, 200, 1, 3, 2]
     * Output: 4
     * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
     *
     * @param nums
     * @return int
     */
    public static int longestConsecutiveLength(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Set<Integer> set = new HashSet();
        for (int num : nums) {
            set.add(num);
        }

        int longestStreak = 0;
        for (int num : nums) {
            if (!set.contains(num - 1)) {
                int currentStreak = 1;

                while (set.contains(num + 1)) {
                    currentStreak++;
                    num = num + 1;
                }
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }
        return longestStreak;
    }
}
