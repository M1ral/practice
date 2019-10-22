package leetcode.dp;

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

        int ans = 0;
        int n = height.length;
        int[] leftMax = new int[n];
        leftMax[0] = height[0];

        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i-1], height[i]);
        }

        int[] rightMax = new int[n];
        rightMax[n-1] = height[n-1];

        for (int i = n-2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i+1], height[i]);
        }

        for (int i = 0; i < n; i++) {
            ans += (Math.min(leftMax[i], rightMax[i])) - height[i];
        }

        return ans;
    }
}
