package leetcode.array.leftrightpointers.trappingrainwater;

/**
 * https://leetcode.com/problems/trapping-rain-water/solution/
 */
public class TrappingRainWater {

    public static void main(String[] args) {
        System.out.println("trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}) = " +
                trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }

    /**
     * Trap rain water
     * https://leetcode.com/problems/trapping-rain-water/description/
     *
     * @param height
     * @return int
     */
    public static int trap(int[] height) {
        if (null == height || height.length == 0) {
            return 0;
        }

        int n = height.length;
        int[] left = new int[n], right = new int[n];
        int leftMax = height[0], rightMax = height[n-1];

        // Keep track of max from left and right
        for (int i = 0; i < n; i++) {
            leftMax = Math.max(leftMax, height[i]);
            left[i] = leftMax;

            rightMax = Math.max(rightMax, height[n-i-1]);
            right[n-i-1] = rightMax;
        }

        // sum answer += min(leftMax, rightMax) - height[i]
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += (Math.min(left[i], right[i]) - height[i]);
        }

        return ans;
    }
}
