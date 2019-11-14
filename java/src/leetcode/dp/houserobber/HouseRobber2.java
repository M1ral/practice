package leetcode.dp.houserobber;

public class HouseRobber2 {

    public static void main(String[] args) {
        System.out.println("robCircularHouses({2,3,2}) = " + robCircularHouses(new int[]{2, 3, 2}));
        System.out.println("robCircularHouses({1,2,3,1}) = " + robCircularHouses(new int[]{1, 2, 3, 1}));
    }

    public static int robCircularHouses(int[] nums) {
        if (null == nums || nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        int max1 = rob(nums, 0, nums.length - 2);
        int max2 = rob(nums, 1, nums.length - 1);

        return Math.max(max1, max2);
    }

    public static int rob(int[] nums, int i, int j) {
        if (i == j) {
            return nums[i];
        }

        int[] dp = new int[nums.length];
        dp[i] = nums[i];
        dp[i + 1] = Math.max(nums[i + 1], dp[i]);

        for (int k = i + 2; k <= j; k++) {
            dp[k] = Math.max(dp[k - 1], dp[k - 2] + nums[k]);
        }

        return dp[j];
    }
}
