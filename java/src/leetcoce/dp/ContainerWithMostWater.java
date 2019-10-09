package leetcoce.dp;

public class ContainerWithMostWater {

    /**
     * https://leetcode.com/problems/container-with-most-water/description/
     */
    public static void main(String[] args) {
        System.out.println("maxArea(new int[]{1,8,6,2,5,4,8,3,7}) = " +
                maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }

    /**
     * https://leetcode.com/problems/container-with-most-water/solution/
     *
     * @param height
     * @return
     */
    public static int maxArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        int maxArea = 0, l = 0, r = height.length - 1;
        while (l < r) {
            maxArea = Math.max(maxArea, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return maxArea;
    }
}
