package leetcode.slidingwindow;

public class MaxConsecutiveOnesI {

    public static void main(String[] args) {
        System.out.println("lengthOfMaxConsecutiveSequence({1,1,0,1,1,1,0}) = " +
                lengthOfMaxConsecutiveSequence(new int[]{1, 1, 0, 1, 1, 1, 0}));
    }

    public static int lengthOfMaxConsecutiveSequence(int[] nums) {
        if (null == nums || nums.length == 0) {
            return 0;
        }

        int max = 0, currentMax = 0;
        for (int n : nums) {
            currentMax = n == 0 ? 0 : currentMax + 1;
            max = Math.max(max, currentMax);
        }

        return max;
    }
}
