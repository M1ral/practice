package leetcode.dp.lclis;

// https://leetcode.com/problems/longest-continuous-increasing-subsequence/
public class LongestContinuousSubSeq {

    public static void main(String[] args) {
        System.out.println("findLengthOfLCIS({1,2,3,4,2,3}) = " +
                findLengthOfLCIS(new int[]{1, 2, 3, 4, 2, 3}));
    }

    public static int findLengthOfLCIS(int[] nums) {
        if (null == nums || nums.length == 0) {
            return 0;
        }

        int index = 0, count = 0, result = Integer.MIN_VALUE;
        for (int n : nums) {
            if (index == 0 || n > nums[index - 1]) {
                count++;
                result = Math.max(result, count);
            } else {
                count = 1;
            }
            index++;
        }

        return result;
    }
}
